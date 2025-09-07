/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.afco.model.rtp.audio;

import com.googlecode.jeneratedata.core.Generator;
import com.googlecode.jeneratedata.core.RandomSequenceArrayBasedGenerator;
import com.googlecode.jeneratedata.core.ShuffleSequenceArrayBasedGenerator;
import com.googlecode.jeneratedata.dates.DateGenerator;
import com.googlecode.jeneratedata.numbers.LongGenerator;
import com.googlecode.jeneratedata.text.AlphabeticStringGenerator;
import com.googlecode.jeneratedata.text.AlphanumericStringGenerator;
import com.googlecode.jeneratedata.text.NumericStringGenerator;
import com.googlecode.jeneratedata.util.ToUpperCaseTransformer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.ThreadLocalRandom;
import javax.xml.datatype.XMLGregorianCalendar;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A copy and paste of some generation utilities from the GenUtilities class from the afco-streamer to provide what the audio streamer needs and this is being used so we ONLY have 1 copy of the Extended Header tests.
 * These will be triggered by either data streamer or audio streamer work.  Did not want to add a dependency on afco-model via the streamer module. Dylan added the data streamer tests and it became insane to continue to manage both duplicate
 * sets of tests after needing to support multiple extended headers.  If anything, there will be more extended headers, so we cannot keep supporting duplicate test classes here.
 * These will need to be managed instead.
 *
 * @author jeremytaylor
 */
public class GenUtilities {

    private static final Logger log = LoggerFactory.getLogger(GenUtilities.class);
    public static final String MSN_DATE_SUFFIX_TEMPLATE = "ddMMMyy";
    public static final String FILENAME_DIFFERENTIATOR = "yyyyMMddHHmmssSSS";
    public static final Double TO_KPH_FACTOR = 1.60934;

    public static DateTime getRandomTimeWithinTimeInterval(DateTime start, DateTime end) {
        Generator<Date> rDateGen = new DateGenerator(start.toGregorianCalendar(), end.toGregorianCalendar());
        Date tmp = rDateGen.generate();
        DateTime rTime = DateTime.now().withMillis(tmp.getTime());
        if (rTime.isBefore(start) || rTime.isAfter(end)) {
            throw new IllegalStateException(
                    "The randomly generated time within the interval is not within the start and end time window.  Please revise.");
        }
        return rTime;
    }

    public static DateTime getJodaTimeFromDate(Date d) {
        return new DateTime().withMillis(d.getTime());
    }

    public static DateTime getJodaTimeFromXmlGregorianCalendar(XMLGregorianCalendar xcal) {
        return new DateTime().withMillis(xcal.toGregorianCalendar().getTimeInMillis());
    }

    /**
     * IDNOs can be less than 5 digits long in reality, but the File name of the
     * Zip file will have zeros prepended on. This adds a little more randomness
     * for the generator to behave a little more similarly to reality in that
     * idnos could have less than 5 digits in the XMLs. The ingest will do the
     * rest on the padding and the zip ingest will not need to be modified.
     *
     * @return String
     */
    public String getIdNoBeforeInit() {
        Generator<String> idNo5Gen = new NumericStringGenerator(5);
        Generator<String> idNo4Gen = new NumericStringGenerator(4);
        Generator<String> idNo3Gen = new NumericStringGenerator(3);
        String[] idNoOptions = {idNo5Gen.generate(), idNo4Gen.generate(), idNo3Gen.generate()};
        Generator<String> idNoGen = new RandomSequenceArrayBasedGenerator<>(idNoOptions);
        return idNoGen.generate();
    }

    /**
     * This is being used in the missionName fields so far. The filed here is
     * shortened to 4 length as the suffix massage provided adds 8 length, for a
     * total of 12, which the AGS ICD requires.
     *
     * @return String
     */
    public static String getMsnNamePrefixBeforeInit() {
        Generator<String> missionNumGen = new Generator<String>() {
            Generator<String> missionNumPart1Gen = new AlphabeticStringGenerator(4);

            @Override
            public String generate() {
                ToUpperCaseTransformer upperTrans = new ToUpperCaseTransformer();
                return upperTrans.transform(missionNumPart1Gen.generate().replaceAll("-|_", ""));
            }
        };
        return missionNumGen.generate();
    }

    public static Short getAudioSignalType() {
        Generator<SignalTypes> signalGen = new RandomSequenceArrayBasedGenerator<>(SignalTypes.getAudioSignalTypes());
        return signalGen.generate().signalTypeValue();
    }

    public static String getFullMsnName() {
        GregorianCalendar gcal = new GregorianCalendar();
        String missionNamePrefix = getMsnNamePrefixBeforeInit();
        StringBuilder buff = new StringBuilder();
        SimpleDateFormat sdf = new SimpleDateFormat(MSN_DATE_SUFFIX_TEMPLATE);
        buff.append(missionNamePrefix);
        buff.append("-");
        buff.append(sdf.format(gcal.getTime()));
        if (buff.toString().length() != 12) {
            throw new IllegalStateException("An missionName muse equal 12 chars per AGS ICD!");
        }
        return buff.toString().toUpperCase();
    }

    public static String getFileNameDifferentiatorFromTime(XMLGregorianCalendar timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat(FILENAME_DIFFERENTIATOR);
        return sdf.format(timestamp.toGregorianCalendar().getTime());
    }

    public static int getRandomIntInRange(int min, int max) {
        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        if ((max + 1) <= min) {
            return min;
        } else {
            return ThreadLocalRandom.current().nextInt(min, max + 1);
        }
    }

    /**
     * This is a non-perfect way of getting random longs, but a way that doesn't
     * interfere with Executor threads. Unfortunately, ThreadLocalRandom and
     * Random completely interferred and could not be used.
     *
     * @param min long
     * @param max long
     * @return long
     */
    public static long getRandomSleepFromMinMax(long min, long max) {
        if (max == min) {
            return min;
        }
        Generator<Long> lGen = new LongGenerator();
        long sleepTime = Math.abs(lGen.generate());
        sleepTime %= min;
        sleepTime += min;
        if (sleepTime > max) {
            long m = sleepTime - max;
            sleepTime = max - m;
        }
        return sleepTime;
    }

    public static Integer getFreqInHertz() {
        // now for big values in hertz as opposed to megahertz
        Generator<String> freqGen = new NumericStringGenerator(9);
        return new Integer(freqGen.generate());
    }

    public static String getBandwidth() {
        // this looks the right size for being in Hertz if it is in hertz
        Generator<String> bwGen = new NumericStringGenerator(5);
        String prefix = "K0000";
        String suffix = "M";
        StringBuilder buff = new StringBuilder();
        buff.append(prefix);
        buff.append(bwGen.generate());
        buff.append(suffix);
        return buff.toString();
    }

    public static String getCaseNot() {
        Generator<String> caseNot4LetterUpperTxtGen = new Generator<String>() {
            // NOTE: this was randomly generated before and now this is fixed a lot more as it is incredibly difficult
            // otherwise to limit casenot in current attempts I feel likely due to all the directions it comes from
            // in addition:  the hashcode and equals methods of Target class cannot be modified as the dataType or
            // dataOrientation field needs to be relevant in the hashCode and equals methods.
            Generator<String> caseNot4LetterGen = new ShuffleSequenceArrayBasedGenerator<>(
                    true, "UXYOKGJ6JGMKX6VT", "QWNISCTT2IO9FEUO", "MRNGJ1E2B5BCU6Y7");

            @Override
            public String generate() {
                ToUpperCaseTransformer upperTrans = new ToUpperCaseTransformer();
                return upperTrans.transform(caseNot4LetterGen.generate());
            }
        };
        return caseNot4LetterUpperTxtGen.generate();
    }

    public static String getCategory() {
        Generator<String> categoryUpperTxtGen = new Generator<String>() {
            Generator<String> categoryGen = new AlphanumericStringGenerator(6);

            @Override
            public String generate() {
                ToUpperCaseTransformer upperTrans = new ToUpperCaseTransformer();
                return upperTrans.transform(categoryGen.generate());
            }
        };
        return categoryUpperTxtGen.generate();
    }

    public static String getPacketDate(DateTime instant) {
        String template = "yyyyMMdd";
        return getDateFormatTemplatedResult(instant, template);
    }

    public static String getPacketTime(DateTime instant) {
        String template = "HHmmss";
        return getDateFormatTemplatedResult(instant, template);
    }

    public static String getOperatorID() {
        Generator<String> opIdGen = new RandomSequenceArrayBasedGenerator<>(
                "rick.hawkins",
                "dutch.schaefer",
                "al.dillon",
                "mac.eliot",
                "jorge.ramirez",
                "blain.cooper",
                "billy.sole",
                "homer.philips",
                "anna.gonsalves");
        return toPaddedString(opIdGen.generate(), 26);
    }

    public static String getDateFormatTemplatedResult(DateTime instant, String template) {
        SimpleDateFormat sdf = new SimpleDateFormat(template);
        return sdf.format(instant.toDate());
    }

    public static String getSigad() {
        Generator<String> sigadUpperTxtGen = new Generator<String>() {
            Generator<String> sigadGen = new AlphanumericStringGenerator(10);

            @Override
            public String generate() {
                ToUpperCaseTransformer upperTrans = new ToUpperCaseTransformer();
                return upperTrans.transform(sigadGen.generate());
            }
        };
        return sigadUpperTxtGen.generate();
    }

    public static String getFreqStrFromHertzValue(Integer nineDigitHertzValue) {
        StringBuilder buff = new StringBuilder();
        buff.append("H");
        // sometimes we weren't getting 9 digits, this insures that
        buff.append(toPaddedIntegerString(nineDigitHertzValue, 9));
        buff.append("M");
        return buff.toString();
    }

    public static String getPriority() {
        Generator<String> priGen = new NumericStringGenerator(1);
        return priGen.generate();
    }

    public static String toPaddedIdno(String originalIdno) {
        return toPaddedString(originalIdno, 5);
    }

    public static String getModulation() {
        Generator<String> modGen = new RandomSequenceArrayBasedGenerator<>(
                "NOT_SPEC", "AM", "FM", "LSB", "USB", "CW", "FSK_1bit", "FM_4bit", "PreD", "Special_1");
        return toPaddedString(modGen.generate(), 9);
    }

    public static String getOpNote() {
        String opNote = "FIVE LOAVES AND TWO FISH";
        return toPaddedString(opNote, 80);
    }

    public static String getKeyword() {
        String keyword = "AWESOMENESS";
        return toPaddedString(keyword, 30);
    }

    public static Long getSpecialField1() {
        Generator<Long> specialFieldGen =
                new RandomSequenceArrayBasedGenerator<>(0L, 4294967295L, 0xDEADBEEFL, 0xAAAABABEL);
        return specialFieldGen.generate();
    }

    public static String getSpecialField2() {
        Generator<String> specialFieldGen = new RandomSequenceArrayBasedGenerator<>(
                "Aboleth", "Demogorgon", "AbyssalChicken", "Vrock", "Wastrilith");
        return toPaddedString(specialFieldGen.generate(), 15);
    }

    public static String toPaddedPddg(String pddg) {
        return toPaddedString(pddg, 5);
    }

    public static String toPaddedCaseNot(String caseNot) {
        return toPaddedString(caseNot, 16);
    }

    public static String toPaddedClassification(String classification) {
        return toPaddedString(classification, 64);
    }

    public static String toPaddedString(String initial, int totalWidthAfterPadding) {
        int len = initial.length();
        int diff = totalWidthAfterPadding - len;
        String pad = " ";
        StringBuilder paddedTmp = new StringBuilder(initial);
        for (int i = 0; i < diff; i++) {
            paddedTmp.append(pad);
        }
        return paddedTmp.toString();
    }

    public static String toPaddedIntegerString(int initial, int totalWidthAfterPadding) {
        String tmp = "" + initial;
        int len = tmp.length();
        int diff = totalWidthAfterPadding - len;
        String pad = "0";
        StringBuilder paddedTmp = new StringBuilder();
        for (int i = 0; i < diff; i++) {
            paddedTmp.append(pad);
        }
        paddedTmp.append(initial);
        return paddedTmp.toString();
    }
}
