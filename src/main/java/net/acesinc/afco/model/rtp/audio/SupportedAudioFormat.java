/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.afco.model.rtp.audio;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioFormat.Encoding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author jeremytaylor
 */
public class SupportedAudioFormat {

    private static final Logger log = LoggerFactory.getLogger(SupportedAudioFormat.class);
    private int payloadType;
    private Encoding encoding;
    private float sampleRate = 8000.0F;
    private int sampleSizeInBits = -1;
    private int channels = 1;
    // *************
    // UPDATE:  Reached out to AGS for agreement on frameSize=2.
    private int frameSize = 2;
    // *************
    // frameRate, a.k.a., clockRate
    // this is 8000 Hz on table 4 of RFC 3551 for payload types 0 and 8
    // RFC 3551 says typically samlple rate and clock rate should be the same and we have agreed on 8000 Hz for all
    // sample rates.
    // UPDATE: Reached out to AGS for agreement on frameRate/clockRate to be 8000 Hz across all payload types.
    private float frameRate = 8000.0f;
    private boolean bigEndian = true;
    // below are strings to help w/ switch statements that must be constants as done, but cannot be set via
    // Audio.Format.Encoding.toString().
    // They have equivalent values of what the toString() method will provide as a result.
    public static final String ALAW = "ALAW";
    public static final String PCM_FLOAT = "PCM_FLOAT";
    public static final String PCM_SIGNED = "PCM_SIGNED";
    public static final String PCM_UNSIGNED = "PCM_UNSIGNED";
    public static final String ULAW = "ULAW";
    public static final String NO_ENCODING = "Encoding is NOT set!!!";

    /**
     * For now we won't use this other constructor explicitly. When we get more
     * confidence, we might remove the other constructor below. Sound has been
     * received fine on other side w/o concern of frameSize, but still making
     * this configurable anyway. Thus, for now, won't use this constructor so
     * much.
     *
     * @param payloadType
     */
    public SupportedAudioFormat(int payloadType) {
        super();
        this.payloadType = payloadType;
    }
    /**
     * Explanation: This is a remnant that has helpful documentation and notes on these different payload types.
     * Keeping around for historical purposes for the near future.
     * switch (this.getPayloadType()) {
     * Per RFC 3551, types 0 and 8 are defined to some extent in table 4 and section 4.5.14
     * case ZERO: {
     * in RFC 3551, table 4 as PCMU:  PCM is signed per 4.5.14 and is MU-LAW and thus should be
     * PCM-ULAW-SIGNED or PCM-MU-LAW-SIGNED
     * in AGS ICD: table 7, this conflicts and says "8 bit mu-law (G.711)" --> G.711 is the correct
     * cryptic term for PCMU/PCMA, but mu-law alone is not correct as it is PCM, signed, and mu-law
     * in Javadocs confusion:  PCM_SIGNED vs ULAW (???) --> I don't see a matching choice.  We may need
     * an audio library to support more.
     * WARNING:  Currently am not 100% sure if we are using correct encoding name in Java.  Have come
     * up w/ this article below and best educated guess.  Came up w/ nothing helpful on additional Java libs that could
     * support more audio encodings.
     * UPDATE:  1)
     * https://stackoverflow.com/questions/26824663/how-do-i-use-audio-sample-data-from-java-sound -->
     * 2) based on this article, Java's somewhat improper naming of Encoding.ULAW is
     * apparently actually meaning PCM signed with mu-law companding, which is what PCMU is.
     * 3) Lack of detail:
     * a) Reached out to AGS for lack of attention to detail for them using the term
     * MU-LAW, which is not PCM at all according to my understanding.
     * b) Java is also wrong in their terminology to me based on audio article readings of
     * what PCM and MU-LAW mean vs PCM w/ MU-LAW companding, which is really what Java is meaning apparently.
     * this.encoding = Encoding.ULAW;best educated guess based on article above and poor Javadocs that
     * this is intead PCM-signed w/ mu-law companding
     * this.bigEndian = true;
     * this.sampleSizeInBits = DEFAULT_SAMPLE_SIZE_IN_BITS;
     * }
     * break;
     * case EIGHT: {
     * in RFC 3551, table 4 as PCMA: PCM is signed per 4.5.14 and is A-LAW and thus should be
     * PCM-ALAW-SIGNED
     * in AGS ICD, table 7:  this conflicts and says "8-bit A-law (G.711)" --> G.711 is the correct
     * cryptic term for PCMU/PCMA, but a-law along is not correct as it is PCM, signed, and a-law
     * WARNING:  Currently am not 100% sure if we are using correct encoding name in Java.  Have come
     * up w/ this article below and best educated guess.  Came up w/ nothing helpful on additional Java libs that could
     * support more audio encodings.
     * UPDATE:  1)
     * https://stackoverflow.com/questions/26824663/how-do-i-use-audio-sample-data-from-java-sound -->
     * 2) based on this article, Java's somewhat improper naming of Encoding.ALAW is
     * apparently actually meaning PCM signed with a-law companding, which is what PCMA is.
     * 3) Lack of detail:
     * a) Reached out to AGS for lack of attention to detail for them using the term A-LAW,
     * which is not PCM at all according to my understanding.
     * b) Java is also wrong in their terminology to me based on audio article readings of
     * what PCM and A-LAW mean vs PCM w/ A-LAW companding, which is really what Java is meaning apparently.
     * this.encoding = Encoding.ALAW;//best educated guess based on article above and poor Javadocs that
     * this is intead PCM-signed w/ a-law companding
     * this.bigEndian = true;
     * this.sampleSizeInBits = DEFAULT_SAMPLE_SIZE_IN_BITS;
     * }
     * break;
     * case THIRTY_SIX:{
     * WARNING: Attempting PCM linear -- best guess was PCM_SIGNED and needs on relay side are PCM_SIGNED
     * Also: PCM linear lingo on destination system has translated to PCM_SIGNED in the past on Java.
     * this.encoding = Encoding.PCM_SIGNED;
     * this.bigEndian = true;
     * this.sampleSizeInBits = DEFAULT_SAMPLE_SIZE_IN_BITS;
     * }
     * break;
     * case FORTY: {
     * A TESTING Payload type ACES has defined for testing due to Audio format support issues w/ Java
     * this.encoding = Encoding.PCM_SIGNED;
     * this.bigEndian = true;
     * this.sampleSizeInBits = 16;
     * ////                AudioFormat format = new AudioFormat(encoding, ((float) 8000.0), 16, 1, frameSize, ((float)
     * 8000.0), true);
     * }
     * break;
     * case ELEVEN: {
     * A TESTING Payload type for testing due to Audio format support issues w/ Java --best understing
     * of payload type 11 based on RFC 3551
     * this.encoding = Encoding.PCM_SIGNED;
     * this.bigEndian = true;
     * this.sampleSizeInBits = 16;
     * this.frameRate = 44100.0F;
     * this.sampleRate = 44100.0F;
     * ////                AudioFormat format = new AudioFormat(encoding, ((float) 44100.0), 16, 1, frameSize, ((float)
     * 44100.0), true);
     * }
     * break;
     * default:throw new IllegalArgumentException("Illegal payload type is not allowed and is being passed
     * in.");
     * }
     * log.debug("initialized encoding:=" + this.encoding.toString());
     * log.debug("initialized isBigEndian:=" + this.bigEndian);
     */
    /**
     * to obtain a Java AudioFormat
     *
     * @return
     */
    public AudioFormat toAudioFormat() {
        // these log statements below are helpful, but basically redundant to the two agent classes using them, so they
        // deserve to be trace-level
        log.trace(
                String.format("Creating AudioFormat from payload type. Payload type info is: [%d].", this.payloadType));
        String enc = NO_ENCODING;
        if (this.encoding != null) {
            enc = this.encoding.toString();
        }
        log.trace(String.format(
                "creating audio format of: encoding[%s], sampleRate[%.1f], sampleSizeInBits[%d], channels[%d], frameSize[%d], frameRate[%.1f], isBigEndian[%b] ...",
                enc,
                this.sampleRate,
                this.sampleSizeInBits,
                this.channels,
                this.frameSize,
                this.frameRate,
                this.bigEndian));
        AudioFormat format = new AudioFormat(
                this.encoding,
                this.sampleRate,
                this.sampleSizeInBits,
                this.channels,
                this.frameSize,
                this.frameRate,
                this.bigEndian);
        return format;
    }

    /**
     * @return the payloadType
     */
    public int getPayloadType() {
        return payloadType;
    }

    /**
     * @return the encoding
     */
    public Encoding getEncoding() {
        return encoding;
    }

    /**
     * @return the sampleRate
     */
    public float getSampleRate() {
        return sampleRate;
    }

    /**
     * @return the sampleSizeInBits
     */
    public int getSampleSizeInBits() {
        return sampleSizeInBits;
    }

    /**
     * @return the channels
     */
    public int getChannels() {
        return channels;
    }

    /**
     * @return the frameSize
     */
    public int getFrameSize() {
        return frameSize;
    }

    /**
     * @return the frameRate
     */
    public float getFrameRate() {
        return frameRate;
    }

    /**
     * @return the bigEndian
     */
    public boolean isBigEndian() {
        return bigEndian;
    }

    /**
     * @param payloadType the payloadType to set
     */
    public void setPayloadType(int payloadType) {
        this.payloadType = payloadType;
    }

    /**
     * @param encoding the encoding to set
     */
    public void setEncoding(Encoding encoding) {
        this.encoding = encoding;
    }

    /**
     * @param sampleRate the sampleRate to set
     */
    public void setSampleRate(float sampleRate) {
        this.sampleRate = sampleRate;
    }

    /**
     * @param sampleSizeInBits the sampleSizeInBits to set
     */
    public void setSampleSizeInBits(int sampleSizeInBits) {
        this.sampleSizeInBits = sampleSizeInBits;
    }

    /**
     * @param channels the channels to set
     */
    public void setChannels(int channels) {
        this.channels = channels;
    }

    /**
     * @param frameSize the frameSize to set
     */
    public void setFrameSize(int frameSize) {
        this.frameSize = frameSize;
    }

    /**
     * @param frameRate the frameRate to set
     */
    public void setFrameRate(float frameRate) {
        this.frameRate = frameRate;
    }

    /**
     * @param bigEndian the bigEndian to set
     */
    public void setBigEndian(boolean bigEndian) {
        this.bigEndian = bigEndian;
    }

    /**
     * This utility tries to help facilitate generating the a-line and m-line
     * focused in SDP on clarifying what the audio format is for the payload
     * type. In payload types 0-34, the user-defined cases will react w/ this
     * method a certain way. For greater than payload type value 34, an rtpmap
     * a-line is needed. This utility helps facilitate in a manner that just
     * focuses on the SDP offer/answer model w/ regards to only offerring the
     * audio format we were originally receiving. In RFC-4566, multiple payload
     * types w/ different formats can be offered. Based on desire for no quality
     * loss due to conversion, we feel we should only stick to original payload
     * type and audio format sub-settings being offered. --> UPDATEs: 1) the
     * rtpmap will be offered for every payload type now. 2) the rtcp port will
     * be explicitly specified ahead of time now
     *
     * @param rtpPort
     * @return
     */
    public String[] toSdpOfferAnswerAudioFormatLines(int rtpPort, int rtcpPort) {
        // Reference RFC 3264 & 4566 for more details
        String delim = " ";
        String fmtDlm = "/";
        String rtpProfile = "RTP/AVP";
        // the M-Line
        // M-Line examples:
        // 1) m=audio 49232 RTP/AVP 0
        // 2) m=audio 49232 RTP/AVP 98
        // breakdown:  m=audio <port> RTP/AVP <payloadType or payloadTypes>
        // disclaimer: We do not expect to have to have to list more than one payloadType in our scenarios w/ SDP for a
        // particular session.
        StringBuilder mLine = new StringBuilder("m=audio");
        mLine.append(delim);
        mLine.append(rtpPort);
        mLine.append(delim);
        mLine.append(rtpProfile);
        mLine.append(delim);
        mLine.append(this.payloadType);
        // the first A-line, the rtcp port
        // FROM RFC-3605
        // a=rtcp:53020 --> using this one in this code
        // a=rtcp:53020 IN IP4 x.x.x.x --> another scenario allowed by this RFC, but not planning on using this until
        // requested
        // a=rtcp:53020 IN IP6 xxxx:xxxx:xxxx:xxxx:xxxx:xxxx:xxxx:xxxx --> another scenario allowed by this RFC, but not
        // planning on using this until requested
        StringBuilder a1Line = new StringBuilder("a=rtcp:");
        a1Line.append(rtcpPort);
        // the second A-Line, the rtpmap
        // FROM RFC-4566:  a=rtpmap:<payload type> <encoding name>/<clock rate> [/<encoding parameters>]
        // My TRANSLATION: a=rtpmap:<payload type> <encoding name>/<clock rate> [/<channel>]
        // !!!Clarification!!!: "encoding paramaters" is the most cryptic way possible to explain that this is the
        // channel, which is 1 or 2.
        //                     As a result, interpret "encoding parameters" as channel. 1 seems to be implicit default
        // if omitted.
        //                     The two RFCs were pretty cryptic to me on what this field referred to.
        // example 1: a=rtpmap:97 L16/8000
        // example 2: a=rtpmap:98 L16/11025/2
        StringBuilder a2Line = new StringBuilder("a=rtpmap:");

        // requested deviation from RFC 3264 and RFC 4566:  give RTPMAP for even pre-defined payload types as well as
        // the dynamic ones
        a2Line.append(this.payloadType);
        a2Line.append(delim);
        String enc = NO_ENCODING;
        if (this.encoding != null) {
            enc = this.encoding.toString();
        }
        switch (enc) {
                // please reference RFC 3551, p. 33 for Strings being used
            case ALAW:
                {
                    a2Line.append("PCMA");
                }
                break;
            case PCM_FLOAT:
                throw new IllegalArgumentException(String.format(
                        "port[%d] -- PCM_FLOAT is a valid audio encoding in Java, but is not supported in the audio video profile RFC of 3511 and thus cannot be supported in SDP related RFCs.",
                        rtpPort));
            case PCM_SIGNED:
                {
                    a2Line.append("L");
                    a2Line.append(this.sampleSizeInBits);
                }
                break;
            case PCM_UNSIGNED: {
                // ****!!!!WARNING!!!!*****:
                // RFC 3511 and other RFCs have never been extremely clear on whether the audio enoding translates to
                // either PCM_SIGNED vs PCM_UNSIGNED.
                // RFC 3511 will reference PCM as 'L' or "linear".  Client will refer to format as "linear".  Through
                // experience, what they expect as "linear" is PCM_SIGNED.
                // As a result, an illegal argument exception will be thrown here as this type should never be used to
                // obtain SDP related strings.
                throw new IllegalArgumentException(String.format(
                        "port[%d] -- PCM_UNSIGNED is incorrectly being attempted to be used for SDP. Please NEVER use PCM_UNSIGNED in RTP relay communication, but use PCM_SIGNED instead!!!",
                        rtpPort));
            }
            case ULAW:
                {
                    a2Line.append("PCMU");
                }
                break;
            default:
                throw new IllegalArgumentException(String.format(
                        "port[%d] -- An unsupported audio encoding [%s] is being used in attempt to generate SDP strings.",
                        rtpPort, enc));
        }
        a2Line.append(fmtDlm);
        a2Line.append(Math.round(frameRate));
        if (this.payloadType != 0) {
            a2Line.append(fmtDlm);
            a2Line.append(this.channels);
        }

        return new String[] {mLine.toString(), a1Line.toString(), a2Line.toString()};
    }

    @Override
    public String toString() {
        String enc = NO_ENCODING;
        if (this.encoding != null) {
            enc = this.encoding.toString();
        }
        return String.format(
                "\npayloadType [%d]; audio format of: encoding[%s], sampleRate[%.1f], sampleSizeInBits[%d], channels[%d], frameSize[%d], frameRate[%.1f], isBigEndian[%b]",
                this.payloadType,
                enc,
                this.sampleRate,
                this.sampleSizeInBits,
                this.channels,
                this.frameSize,
                this.frameRate,
                this.bigEndian);
    }
}
