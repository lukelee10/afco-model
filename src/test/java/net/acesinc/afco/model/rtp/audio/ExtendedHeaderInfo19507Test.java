/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.afco.model.rtp.audio;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.joda.time.DateTime;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author jeremytaylor
 */
public class ExtendedHeaderInfo19507Test {

    private static final Logger log = LoggerFactory.getLogger(ExtendedHeaderInfo19507Test.class);

    @BeforeClass
    public static void setUpClass() {}

    @AfterClass
    public static void tearDownClass() {}

    @Before
    public void setUp() {}

    @After
    public void tearDown() {}

    @Ignore
    @Test
    public void testEncoding001() {
        log.debug("start");
        ExtendedHeaderInfo extHeaderInfo = new ExtendedHeaderInfo19507();
        extHeaderInfo.setClassification(GenUtilities.toPaddedClassification("UNCLASSIFIED_FOUO"));
        extHeaderInfo.setMissionName("FUEW-22JAN18");
        extHeaderInfo.setCaseNotation1(GenUtilities.getCaseNot());
        extHeaderInfo.setCaseNotation2(GenUtilities.getCaseNot());
        extHeaderInfo.setCaseNotation3(GenUtilities.getCaseNot());
        extHeaderInfo.setEmitterLongitude("1322712E");
        DateTime now = DateTime.now();
        DateTime tenMinutesAgo = DateTime.now().minusMinutes(10);
        extHeaderInfo.setFirstPacketDate(GenUtilities.getPacketDate(tenMinutesAgo));
        extHeaderInfo.setCurrentPacketDate(GenUtilities.getPacketDate(now));
        extHeaderInfo.setFirstPacketTime(GenUtilities.getPacketTime(tenMinutesAgo));
        extHeaderInfo.setCurrentPacketTime(GenUtilities.getPacketTime(now));
        extHeaderInfo.setCategory1(GenUtilities.getCategory());
        extHeaderInfo.setCategory2(GenUtilities.getCategory());
        extHeaderInfo.setCategory3(GenUtilities.getCategory());
        extHeaderInfo.setSigad(GenUtilities.getSigad());
        extHeaderInfo.setDeprecatedAsciiFrequency(GenUtilities.getFreqStrFromHertzValue(GenUtilities.getFreqInHertz()));
        extHeaderInfo.setPriority(GenUtilities.getPriority());
        extHeaderInfo.setBandwidth(GenUtilities.getBandwidth());
        extHeaderInfo.setIdno(GenUtilities.toPaddedIdno("08"));
        extHeaderInfo.setModulation(GenUtilities.getModulation());
        extHeaderInfo.setEmitterLatitude("321254S");
        extHeaderInfo.setOpNote(GenUtilities.getOpNote());
        extHeaderInfo.setKeyword(GenUtilities.getKeyword());
        extHeaderInfo.setPddg(GenUtilities.toPaddedPddg("AA"));
        // this addition here won't change size and shouldn't change affect of test -- default value had been given
        extHeaderInfo.setStreamStateIndicator(StreamStateType.START);
        log.debug("building extension header for mission [" + extHeaderInfo.getMissionName() + "] IDNO ["
                + extHeaderInfo.getIdno() + "]...");
        extHeaderInfo.printSnapshot();
        byte[] raw = extHeaderInfo.toBytes();
        assertThat(
                "wrong encoded byte length!!!",
                raw.length,
                is(equalTo(ExtendedHeaderInfo.ACTUAL_AGS_EXT_HEADER_PROFILE_19507_LENGTH_IN_BYTES)));
        log.debug("Encoded: [" + new String(raw) + "]");
        log.debug("end");
    }

    @Ignore
    @Test
    public void testEncoding002() {
        log.debug("start");
        ExtendedHeaderInfo extHeaderInfo = new ExtendedHeaderInfo19507();
        extHeaderInfo.setClassification(GenUtilities.toPaddedClassification("UNCLASSIFIED_FOUO"));
        extHeaderInfo.setMissionName("FUEW-22JAN18");
        extHeaderInfo.setCaseNotation1(GenUtilities.getCaseNot());
        extHeaderInfo.setCaseNotation2(GenUtilities.getCaseNot());
        extHeaderInfo.setCaseNotation3(GenUtilities.getCaseNot());
        extHeaderInfo.setEmitterLongitude("1322712E");
        DateTime now = DateTime.now();
        DateTime tenMinutesAgo = DateTime.now().minusMinutes(10);
        extHeaderInfo.setFirstPacketDate(GenUtilities.getPacketDate(tenMinutesAgo));
        extHeaderInfo.setCurrentPacketDate(GenUtilities.getPacketDate(now));
        extHeaderInfo.setFirstPacketTime(GenUtilities.getPacketTime(tenMinutesAgo));
        extHeaderInfo.setCurrentPacketTime(GenUtilities.getPacketTime(now));
        extHeaderInfo.setCategory1(GenUtilities.getCategory());
        extHeaderInfo.setCategory2(GenUtilities.getCategory());
        extHeaderInfo.setCategory3(GenUtilities.getCategory());
        extHeaderInfo.setSigad(GenUtilities.getSigad());
        extHeaderInfo.setDeprecatedAsciiFrequency(GenUtilities.getFreqStrFromHertzValue(GenUtilities.getFreqInHertz()));
        extHeaderInfo.setPriority(GenUtilities.getPriority());
        extHeaderInfo.setBandwidth(GenUtilities.getBandwidth());
        extHeaderInfo.setIdno(GenUtilities.toPaddedIdno("232"));
        extHeaderInfo.setModulation(GenUtilities.getModulation());
        extHeaderInfo.setEmitterLatitude("321254S");
        extHeaderInfo.setOpNote(GenUtilities.getOpNote());
        extHeaderInfo.setKeyword(GenUtilities.getKeyword());
        extHeaderInfo.setPddg(GenUtilities.toPaddedPddg("AA"));
        // this addition here won't change size and shouldn't change affect of test -- default value had been given
        extHeaderInfo.setStreamStateIndicator(StreamStateType.START);
        log.debug("building extension header for mission [" + extHeaderInfo.getMissionName() + "] IDNO ["
                + extHeaderInfo.getIdno() + "]...");
        extHeaderInfo.printSnapshot();
        byte[] raw = extHeaderInfo.toBytes();
        assertThat(
                "wrong encoded byte length!!!",
                raw.length,
                is(equalTo(ExtendedHeaderInfo.ACTUAL_AGS_EXT_HEADER_PROFILE_19507_LENGTH_IN_BYTES)));
        log.debug("Encoded: [" + new String(raw) + "]");
        log.debug("end");
    }

    @Ignore
    @Test
    public void testEncoding003() {
        log.debug("start");
        ExtendedHeaderInfo extHeaderInfo = new ExtendedHeaderInfo19507();
        extHeaderInfo.setClassification(GenUtilities.toPaddedClassification("UNCLASSIFIED_FOUO"));
        extHeaderInfo.setMissionName("FUEW-22JAN18");
        extHeaderInfo.setCaseNotation1(GenUtilities.getCaseNot());
        extHeaderInfo.setCaseNotation2(GenUtilities.getCaseNot());
        extHeaderInfo.setCaseNotation3(GenUtilities.getCaseNot());
        extHeaderInfo.setEmitterLongitude("1322712E");
        DateTime now = DateTime.now();
        DateTime tenMinutesAgo = DateTime.now().minusMinutes(10);
        extHeaderInfo.setFirstPacketDate(GenUtilities.getPacketDate(tenMinutesAgo));
        extHeaderInfo.setCurrentPacketDate(GenUtilities.getPacketDate(now));
        extHeaderInfo.setFirstPacketTime(GenUtilities.getPacketTime(tenMinutesAgo));
        extHeaderInfo.setCurrentPacketTime(GenUtilities.getPacketTime(now));
        extHeaderInfo.setCategory1(GenUtilities.getCategory());
        extHeaderInfo.setCategory2(GenUtilities.getCategory());
        extHeaderInfo.setCategory3(GenUtilities.getCategory());
        extHeaderInfo.setSigad(GenUtilities.getSigad());
        extHeaderInfo.setDeprecatedAsciiFrequency(GenUtilities.getFreqStrFromHertzValue(GenUtilities.getFreqInHertz()));
        extHeaderInfo.setPriority(GenUtilities.getPriority());
        extHeaderInfo.setBandwidth(GenUtilities.getBandwidth());
        extHeaderInfo.setIdno(GenUtilities.toPaddedIdno("1312"));
        extHeaderInfo.setModulation(GenUtilities.getModulation());
        extHeaderInfo.setEmitterLatitude("321254S");
        extHeaderInfo.setOpNote(GenUtilities.getOpNote());
        extHeaderInfo.setKeyword(GenUtilities.getKeyword());
        extHeaderInfo.setPddg(GenUtilities.toPaddedPddg("AA"));
        // this addition here won't change size and shouldn't change affect of test -- default value had been given
        extHeaderInfo.setStreamStateIndicator(StreamStateType.START);
        log.debug("building extension header for mission [" + extHeaderInfo.getMissionName() + "] IDNO ["
                + extHeaderInfo.getIdno() + "]...");
        extHeaderInfo.printSnapshot();
        byte[] raw = extHeaderInfo.toBytes();
        assertThat(
                "wrong encoded byte length!!!",
                raw.length,
                is(equalTo(ExtendedHeaderInfo.ACTUAL_AGS_EXT_HEADER_PROFILE_19507_LENGTH_IN_BYTES)));
        log.debug("Encoded: [" + new String(raw) + "]");
        log.debug("end");
    }

    @Ignore
    @Test
    public void testEncoding004() {
        log.debug("start");
        ExtendedHeaderInfo extHeaderInfo = new ExtendedHeaderInfo19507();
        extHeaderInfo.setClassification(GenUtilities.toPaddedClassification("UNCLASSIFIED_FOUO"));
        extHeaderInfo.setMissionName("FUEW-22JAN18");
        extHeaderInfo.setCaseNotation1(GenUtilities.getCaseNot());
        extHeaderInfo.setCaseNotation2(GenUtilities.getCaseNot());
        extHeaderInfo.setCaseNotation3(GenUtilities.getCaseNot());
        extHeaderInfo.setEmitterLongitude("1322712E");
        DateTime now = DateTime.now();
        DateTime tenMinutesAgo = DateTime.now().minusMinutes(10);
        extHeaderInfo.setFirstPacketDate(GenUtilities.getPacketDate(tenMinutesAgo));
        extHeaderInfo.setCurrentPacketDate(GenUtilities.getPacketDate(now));
        extHeaderInfo.setFirstPacketTime(GenUtilities.getPacketTime(tenMinutesAgo));
        extHeaderInfo.setCurrentPacketTime(GenUtilities.getPacketTime(now));
        extHeaderInfo.setCategory1(GenUtilities.getCategory());
        extHeaderInfo.setCategory2(GenUtilities.getCategory());
        extHeaderInfo.setCategory3(GenUtilities.getCategory());
        extHeaderInfo.setSigad(GenUtilities.getSigad());
        extHeaderInfo.setDeprecatedAsciiFrequency(GenUtilities.getFreqStrFromHertzValue(GenUtilities.getFreqInHertz()));
        extHeaderInfo.setPriority(GenUtilities.getPriority());
        extHeaderInfo.setBandwidth(GenUtilities.getBandwidth());
        extHeaderInfo.setIdno(GenUtilities.toPaddedIdno("13121"));
        extHeaderInfo.setModulation(GenUtilities.getModulation());
        extHeaderInfo.setEmitterLatitude("321254S");
        extHeaderInfo.setOpNote(GenUtilities.getOpNote());
        extHeaderInfo.setKeyword(GenUtilities.getKeyword());
        extHeaderInfo.setPddg(GenUtilities.toPaddedPddg("AA"));
        // this addition here won't change size and shouldn't change affect of test -- default value had been given
        extHeaderInfo.setStreamStateIndicator(StreamStateType.START);
        log.debug("building extension header for mission [" + extHeaderInfo.getMissionName() + "] IDNO ["
                + extHeaderInfo.getIdno() + "]...");
        extHeaderInfo.printSnapshot();
        byte[] raw = extHeaderInfo.toBytes();
        assertThat(
                "wrong encoded byte length!!!",
                raw.length,
                is(equalTo(ExtendedHeaderInfo.ACTUAL_AGS_EXT_HEADER_PROFILE_19507_LENGTH_IN_BYTES)));
        log.debug("Encoded: [" + new String(raw) + "]");
        log.debug("end");
    }

    @Ignore
    @Test
    public void testEncoding005() {
        log.debug("start");
        ExtendedHeaderInfo extHeaderInfo = new ExtendedHeaderInfo19507();
        extHeaderInfo.setClassification(GenUtilities.toPaddedClassification("UNCLASSIFIED_FOUO"));
        extHeaderInfo.setMissionName("FUEW-22JAN18");
        extHeaderInfo.setCaseNotation1(GenUtilities.getCaseNot());
        extHeaderInfo.setCaseNotation2(GenUtilities.getCaseNot());
        extHeaderInfo.setCaseNotation3(GenUtilities.getCaseNot());
        extHeaderInfo.setEmitterLongitude("1322712E");
        DateTime now = DateTime.now();
        DateTime tenMinutesAgo = DateTime.now().minusMinutes(10);
        extHeaderInfo.setFirstPacketDate(GenUtilities.getPacketDate(tenMinutesAgo));
        extHeaderInfo.setCurrentPacketDate(GenUtilities.getPacketDate(now));
        extHeaderInfo.setFirstPacketTime(GenUtilities.getPacketTime(tenMinutesAgo));
        extHeaderInfo.setCurrentPacketTime(GenUtilities.getPacketTime(now));
        extHeaderInfo.setCategory1(GenUtilities.getCategory());
        extHeaderInfo.setCategory2(GenUtilities.getCategory());
        extHeaderInfo.setCategory3(GenUtilities.getCategory());
        extHeaderInfo.setSigad(GenUtilities.getSigad());
        extHeaderInfo.setDeprecatedAsciiFrequency(GenUtilities.getFreqStrFromHertzValue(GenUtilities.getFreqInHertz()));
        extHeaderInfo.setPriority(GenUtilities.getPriority());
        extHeaderInfo.setBandwidth(GenUtilities.getBandwidth());
        extHeaderInfo.setIdno(GenUtilities.toPaddedIdno("5"));
        extHeaderInfo.setModulation(GenUtilities.getModulation());
        extHeaderInfo.setEmitterLatitude("321254S");
        extHeaderInfo.setOpNote(GenUtilities.getOpNote());
        extHeaderInfo.setKeyword(GenUtilities.getKeyword());
        extHeaderInfo.setPddg(GenUtilities.toPaddedPddg("AA"));
        // this addition here won't change size and shouldn't change affect of test -- default value had been given
        extHeaderInfo.setStreamStateIndicator(StreamStateType.START);
        log.debug("building extension header for mission [" + extHeaderInfo.getMissionName() + "] IDNO ["
                + extHeaderInfo.getIdno() + "]...");
        extHeaderInfo.printSnapshot();
        byte[] raw = extHeaderInfo.toBytes();
        assertThat(
                "wrong encoded byte length!!!",
                raw.length,
                is(equalTo(ExtendedHeaderInfo.ACTUAL_AGS_EXT_HEADER_PROFILE_19507_LENGTH_IN_BYTES)));
        log.debug("Encoded: [" + new String(raw) + "]");
        log.debug("end");
    }

    @Test
    public void testDecoding001() {
        log.debug("start");
        ExtendedHeaderInfo extHeaderInfo = new ExtendedHeaderInfo19507();
        extHeaderInfo.setClassification(GenUtilities.toPaddedClassification("UNCLASSIFIED_FOUO"));
        extHeaderInfo.setMissionName("FUEW-22JAN18");
        extHeaderInfo.setCaseNotation1(GenUtilities.getCaseNot());
        extHeaderInfo.setCaseNotation2(GenUtilities.getCaseNot());
        extHeaderInfo.setCaseNotation3(GenUtilities.getCaseNot());
        extHeaderInfo.setEmitterLongitude("1322712E");
        DateTime now = DateTime.now();
        DateTime tenMinutesAgo = DateTime.now().minusMinutes(10);
        extHeaderInfo.setFirstPacketDate(GenUtilities.getPacketDate(tenMinutesAgo));
        extHeaderInfo.setCurrentPacketDate(GenUtilities.getPacketDate(now));
        extHeaderInfo.setFirstPacketTime(GenUtilities.getPacketTime(tenMinutesAgo));
        extHeaderInfo.setCurrentPacketTime(GenUtilities.getPacketTime(now));
        extHeaderInfo.setCategory1(GenUtilities.getCategory());
        extHeaderInfo.setCategory2(GenUtilities.getCategory());
        extHeaderInfo.setCategory3(GenUtilities.getCategory());
        extHeaderInfo.setSigad(GenUtilities.getSigad());
        extHeaderInfo.setDeprecatedAsciiFrequency(GenUtilities.getFreqStrFromHertzValue(GenUtilities.getFreqInHertz()));
        extHeaderInfo.setPriority(GenUtilities.getPriority());
        extHeaderInfo.setBandwidth(GenUtilities.getBandwidth());
        extHeaderInfo.setIdno(GenUtilities.toPaddedIdno("08"));
        extHeaderInfo.setModulation(GenUtilities.getModulation());
        extHeaderInfo.setEmitterLatitude("321254S");
        extHeaderInfo.setOpNote(GenUtilities.getOpNote());
        extHeaderInfo.setKeyword(GenUtilities.getKeyword());
        extHeaderInfo.setPddg(GenUtilities.toPaddedPddg("AA"));
        // this addition here won't change size and shouldn't change affect of test -- default value had been given
        extHeaderInfo.setStreamStateIndicator(StreamStateType.START);
        byte[] raw = extHeaderInfo.toBytes();
        ExtendedHeaderInfo received = SupportedExtendedHeaderInfo.toExtendedHeaderFromBytes(
                ExtendedHeaderInfo.AGS_EXTENDED_HEADER_PROFILE_19507_PREAMBLE_VALUE, raw);
        assertThat("wrong encoded byte length!!!", received.toBytes().length, is(equalTo(raw.length)));
        assertThat(
                "wrong classification", received.getClassification(), is(equalTo(extHeaderInfo.getClassification())));
        assertThat("wrong missionName", received.getMissionName(), is(equalTo(extHeaderInfo.getMissionName())));
        assertThat("wrong caseNotation1", received.getCaseNotation1(), is(equalTo(extHeaderInfo.getCaseNotation1())));
        assertThat("wrong caseNotation2", received.getCaseNotation2(), is(equalTo(extHeaderInfo.getCaseNotation2())));
        assertThat("wrong caseNotation3", received.getCaseNotation3(), is(equalTo(extHeaderInfo.getCaseNotation3())));
        assertThat(
                "wrong emitterLongitude",
                received.getEmitterLongitude(),
                is(equalTo(extHeaderInfo.getEmitterLongitude())));
        assertThat(
                "wrong firstPacketDate",
                received.getFirstPacketDate(),
                is(equalTo(extHeaderInfo.getFirstPacketDate())));
        assertThat(
                "wrong currentPacketDate",
                received.getCurrentPacketDate(),
                is(equalTo(extHeaderInfo.getCurrentPacketDate())));
        assertThat(
                "wrong firstPacketTime",
                received.getFirstPacketTime(),
                is(equalTo(extHeaderInfo.getFirstPacketTime())));
        assertThat(
                "wrong currentPacketTime",
                received.getCurrentPacketTime(),
                is(equalTo(extHeaderInfo.getCurrentPacketTime())));
        assertThat("wrong category1", received.getCategory1(), is(equalTo(extHeaderInfo.getCategory1())));
        assertThat("wrong category2", received.getCategory2(), is(equalTo(extHeaderInfo.getCategory2())));
        assertThat("wrong category3", received.getCategory3(), is(equalTo(extHeaderInfo.getCategory3())));
        assertThat("wrong sigad", received.getSigad(), is(equalTo(extHeaderInfo.getSigad())));
        assertThat(
                "wrong frequency",
                received.getDeprecatedAsciiFrequency(),
                is(equalTo(extHeaderInfo.getDeprecatedAsciiFrequency())));
        assertThat("wrong priority", received.getPriority(), is(equalTo(extHeaderInfo.getPriority())));
        assertThat("wrong bandwidth", received.getBandwidth(), is(equalTo(extHeaderInfo.getBandwidth())));
        assertThat("wrong idno", received.getIdno(), is(equalTo(extHeaderInfo.getIdno())));
        assertThat("wrong modulation", received.getModulation(), is(equalTo(extHeaderInfo.getModulation())));
        assertThat(
                "wrong emitterLatitude",
                received.getEmitterLatitude(),
                is(equalTo(extHeaderInfo.getEmitterLatitude())));
        assertThat("wrong opNote", received.getOpNote(), is(equalTo(extHeaderInfo.getOpNote())));
        assertThat("wrong keyword", received.getKeyword(), is(equalTo(extHeaderInfo.getKeyword())));
        assertThat("wrong pddg", received.getPddg(), is(equalTo(extHeaderInfo.getPddg())));
        assertThat(
                "wrong SSI",
                received.getStreamStateIndicator().getRawStreamStateIndicatorValue(),
                is(equalTo(extHeaderInfo.getStreamStateIndicator().getRawStreamStateIndicatorValue())));
        log.debug("end");
    }

    @Test
    public void testDecoding002() {

        log.debug("start");
        ExtendedHeaderInfo extHeaderInfo = new ExtendedHeaderInfo19507();
        extHeaderInfo.setClassification(GenUtilities.toPaddedClassification("UNCLASSIFIED_FOUO"));
        extHeaderInfo.setMissionName("FUEW-22JAN18");
        extHeaderInfo.setCaseNotation1(GenUtilities.getCaseNot());
        extHeaderInfo.setCaseNotation2(GenUtilities.getCaseNot());
        extHeaderInfo.setCaseNotation3(GenUtilities.getCaseNot());
        extHeaderInfo.setEmitterLongitude("1322712E");
        DateTime now = DateTime.now();
        DateTime tenMinutesAgo = DateTime.now().minusMinutes(10);
        extHeaderInfo.setFirstPacketDate(GenUtilities.getPacketDate(tenMinutesAgo));
        extHeaderInfo.setCurrentPacketDate(GenUtilities.getPacketDate(now));
        extHeaderInfo.setFirstPacketTime(GenUtilities.getPacketTime(tenMinutesAgo));
        extHeaderInfo.setCurrentPacketTime(GenUtilities.getPacketTime(now));
        extHeaderInfo.setCategory1(GenUtilities.getCategory());
        extHeaderInfo.setCategory2(GenUtilities.getCategory());
        extHeaderInfo.setCategory3(GenUtilities.getCategory());
        extHeaderInfo.setSigad(GenUtilities.getSigad());
        extHeaderInfo.setDeprecatedAsciiFrequency(GenUtilities.getFreqStrFromHertzValue(GenUtilities.getFreqInHertz()));
        extHeaderInfo.setPriority(GenUtilities.getPriority());
        extHeaderInfo.setBandwidth(GenUtilities.getBandwidth());
        extHeaderInfo.setIdno(GenUtilities.toPaddedIdno("232"));
        extHeaderInfo.setModulation(GenUtilities.getModulation());
        extHeaderInfo.setEmitterLatitude("321254S");
        extHeaderInfo.setOpNote(GenUtilities.getOpNote());
        extHeaderInfo.setKeyword(GenUtilities.getKeyword());
        extHeaderInfo.setPddg(GenUtilities.toPaddedPddg("AA"));
        extHeaderInfo.setStreamStateIndicator(StreamStateType.START);
        byte[] raw = extHeaderInfo.toBytes();
        ExtendedHeaderInfo received = SupportedExtendedHeaderInfo.toExtendedHeaderFromBytes(
                ExtendedHeaderInfo.AGS_EXTENDED_HEADER_PROFILE_19507_PREAMBLE_VALUE, raw);
        assertThat("wrong encoded byte length!!!", received.toBytes().length, is(equalTo(raw.length)));
        assertThat(
                "wrong classification", received.getClassification(), is(equalTo(extHeaderInfo.getClassification())));
        assertThat("wrong missionName", received.getMissionName(), is(equalTo(extHeaderInfo.getMissionName())));
        assertThat("wrong caseNotation1", received.getCaseNotation1(), is(equalTo(extHeaderInfo.getCaseNotation1())));
        assertThat("wrong caseNotation2", received.getCaseNotation2(), is(equalTo(extHeaderInfo.getCaseNotation2())));
        assertThat("wrong caseNotation3", received.getCaseNotation3(), is(equalTo(extHeaderInfo.getCaseNotation3())));
        assertThat(
                "wrong emitterLongitude",
                received.getEmitterLongitude(),
                is(equalTo(extHeaderInfo.getEmitterLongitude())));
        assertThat(
                "wrong firstPacketDate",
                received.getFirstPacketDate(),
                is(equalTo(extHeaderInfo.getFirstPacketDate())));
        assertThat(
                "wrong currentPacketDate",
                received.getCurrentPacketDate(),
                is(equalTo(extHeaderInfo.getCurrentPacketDate())));
        assertThat(
                "wrong firstPacketTime",
                received.getFirstPacketTime(),
                is(equalTo(extHeaderInfo.getFirstPacketTime())));
        assertThat(
                "wrong currentPacketTime",
                received.getCurrentPacketTime(),
                is(equalTo(extHeaderInfo.getCurrentPacketTime())));
        assertThat("wrong category1", received.getCategory1(), is(equalTo(extHeaderInfo.getCategory1())));
        assertThat("wrong category2", received.getCategory2(), is(equalTo(extHeaderInfo.getCategory2())));
        assertThat("wrong category3", received.getCategory3(), is(equalTo(extHeaderInfo.getCategory3())));
        assertThat("wrong sigad", received.getSigad(), is(equalTo(extHeaderInfo.getSigad())));
        assertThat(
                "wrong frequency",
                received.getDeprecatedAsciiFrequency(),
                is(equalTo(extHeaderInfo.getDeprecatedAsciiFrequency())));
        assertThat("wrong priority", received.getPriority(), is(equalTo(extHeaderInfo.getPriority())));
        assertThat("wrong bandwidth", received.getBandwidth(), is(equalTo(extHeaderInfo.getBandwidth())));
        assertThat("wrong idno", received.getIdno(), is(equalTo(extHeaderInfo.getIdno())));
        assertThat("wrong modulation", received.getModulation(), is(equalTo(extHeaderInfo.getModulation())));
        assertThat(
                "wrong emitterLatitude",
                received.getEmitterLatitude(),
                is(equalTo(extHeaderInfo.getEmitterLatitude())));
        assertThat("wrong opNote", received.getOpNote(), is(equalTo(extHeaderInfo.getOpNote())));
        assertThat("wrong keyword", received.getKeyword(), is(equalTo(extHeaderInfo.getKeyword())));
        assertThat("wrong pddg", received.getPddg(), is(equalTo(extHeaderInfo.getPddg())));
        assertThat(
                "wrong SSI",
                received.getStreamStateIndicator().getRawStreamStateIndicatorValue(),
                is(equalTo(extHeaderInfo.getStreamStateIndicator().getRawStreamStateIndicatorValue())));
        log.debug("end");
    }

    @Test
    public void testDecoding003() {
        log.debug("start");
        ExtendedHeaderInfo extHeaderInfo = new ExtendedHeaderInfo19507();
        extHeaderInfo.setClassification(GenUtilities.toPaddedClassification("UNCLASSIFIED_FOUO"));
        extHeaderInfo.setMissionName("FUEW-22JAN18");
        extHeaderInfo.setCaseNotation1(GenUtilities.getCaseNot());
        extHeaderInfo.setCaseNotation2(GenUtilities.getCaseNot());
        extHeaderInfo.setCaseNotation3(GenUtilities.getCaseNot());
        extHeaderInfo.setEmitterLongitude("1322712E");
        DateTime now = DateTime.now();
        DateTime tenMinutesAgo = DateTime.now().minusMinutes(10);
        extHeaderInfo.setFirstPacketDate(GenUtilities.getPacketDate(tenMinutesAgo));
        extHeaderInfo.setCurrentPacketDate(GenUtilities.getPacketDate(now));
        extHeaderInfo.setFirstPacketTime(GenUtilities.getPacketTime(tenMinutesAgo));
        extHeaderInfo.setCurrentPacketTime(GenUtilities.getPacketTime(now));
        extHeaderInfo.setCategory1(GenUtilities.getCategory());
        extHeaderInfo.setCategory2(GenUtilities.getCategory());
        extHeaderInfo.setCategory3(GenUtilities.getCategory());
        extHeaderInfo.setSigad(GenUtilities.getSigad());
        extHeaderInfo.setDeprecatedAsciiFrequency(GenUtilities.getFreqStrFromHertzValue(GenUtilities.getFreqInHertz()));
        extHeaderInfo.setPriority(GenUtilities.getPriority());
        extHeaderInfo.setBandwidth(GenUtilities.getBandwidth());
        extHeaderInfo.setIdno(GenUtilities.toPaddedIdno("1312"));
        extHeaderInfo.setModulation(GenUtilities.getModulation());
        extHeaderInfo.setEmitterLatitude("321254S");
        extHeaderInfo.setOpNote(GenUtilities.getOpNote());
        extHeaderInfo.setKeyword(GenUtilities.getKeyword());
        extHeaderInfo.setPddg(GenUtilities.toPaddedPddg("AA"));
        extHeaderInfo.setStreamStateIndicator(StreamStateType.START);
        byte[] raw = extHeaderInfo.toBytes();
        ExtendedHeaderInfo received = SupportedExtendedHeaderInfo.toExtendedHeaderFromBytes(
                ExtendedHeaderInfo.AGS_EXTENDED_HEADER_PROFILE_19507_PREAMBLE_VALUE, raw);
        assertThat("wrong encoded byte length!!!", received.toBytes().length, is(equalTo(raw.length)));
        assertThat(
                "wrong classification", received.getClassification(), is(equalTo(extHeaderInfo.getClassification())));
        assertThat("wrong missionName", received.getMissionName(), is(equalTo(extHeaderInfo.getMissionName())));
        assertThat("wrong caseNotation1", received.getCaseNotation1(), is(equalTo(extHeaderInfo.getCaseNotation1())));
        assertThat("wrong caseNotation2", received.getCaseNotation2(), is(equalTo(extHeaderInfo.getCaseNotation2())));
        assertThat("wrong caseNotation3", received.getCaseNotation3(), is(equalTo(extHeaderInfo.getCaseNotation3())));
        assertThat(
                "wrong emitterLongitude",
                received.getEmitterLongitude(),
                is(equalTo(extHeaderInfo.getEmitterLongitude())));
        assertThat(
                "wrong firstPacketDate",
                received.getFirstPacketDate(),
                is(equalTo(extHeaderInfo.getFirstPacketDate())));
        assertThat(
                "wrong currentPacketDate",
                received.getCurrentPacketDate(),
                is(equalTo(extHeaderInfo.getCurrentPacketDate())));
        assertThat(
                "wrong firstPacketTime",
                received.getFirstPacketTime(),
                is(equalTo(extHeaderInfo.getFirstPacketTime())));
        assertThat(
                "wrong currentPacketTime",
                received.getCurrentPacketTime(),
                is(equalTo(extHeaderInfo.getCurrentPacketTime())));
        assertThat("wrong category1", received.getCategory1(), is(equalTo(extHeaderInfo.getCategory1())));
        assertThat("wrong category2", received.getCategory2(), is(equalTo(extHeaderInfo.getCategory2())));
        assertThat("wrong category3", received.getCategory3(), is(equalTo(extHeaderInfo.getCategory3())));
        assertThat("wrong sigad", received.getSigad(), is(equalTo(extHeaderInfo.getSigad())));
        assertThat(
                "wrong frequency",
                received.getDeprecatedAsciiFrequency(),
                is(equalTo(extHeaderInfo.getDeprecatedAsciiFrequency())));
        assertThat("wrong priority", received.getPriority(), is(equalTo(extHeaderInfo.getPriority())));
        assertThat("wrong bandwidth", received.getBandwidth(), is(equalTo(extHeaderInfo.getBandwidth())));
        assertThat("wrong idno", received.getIdno(), is(equalTo(extHeaderInfo.getIdno())));
        assertThat("wrong modulation", received.getModulation(), is(equalTo(extHeaderInfo.getModulation())));
        assertThat(
                "wrong emitterLatitude",
                received.getEmitterLatitude(),
                is(equalTo(extHeaderInfo.getEmitterLatitude())));
        assertThat("wrong opNote", received.getOpNote(), is(equalTo(extHeaderInfo.getOpNote())));
        assertThat("wrong keyword", received.getKeyword(), is(equalTo(extHeaderInfo.getKeyword())));
        assertThat("wrong pddg", received.getPddg(), is(equalTo(extHeaderInfo.getPddg())));
        assertThat(
                "wrong SSI",
                received.getStreamStateIndicator().getRawStreamStateIndicatorValue(),
                is(equalTo(extHeaderInfo.getStreamStateIndicator().getRawStreamStateIndicatorValue())));
        log.debug("end");
    }

    @Test
    public void testDecoding004() {
        log.debug("start");
        ExtendedHeaderInfo extHeaderInfo = new ExtendedHeaderInfo19507();
        extHeaderInfo.setClassification(GenUtilities.toPaddedClassification("UNCLASSIFIED_FOUO"));
        extHeaderInfo.setMissionName("FUEW-22JAN18");
        extHeaderInfo.setCaseNotation1(GenUtilities.getCaseNot());
        extHeaderInfo.setCaseNotation2(GenUtilities.getCaseNot());
        extHeaderInfo.setCaseNotation3(GenUtilities.getCaseNot());
        extHeaderInfo.setEmitterLongitude("1322712E");
        DateTime now = DateTime.now();
        DateTime tenMinutesAgo = DateTime.now().minusMinutes(10);
        extHeaderInfo.setFirstPacketDate(GenUtilities.getPacketDate(tenMinutesAgo));
        extHeaderInfo.setCurrentPacketDate(GenUtilities.getPacketDate(now));
        extHeaderInfo.setFirstPacketTime(GenUtilities.getPacketTime(tenMinutesAgo));
        extHeaderInfo.setCurrentPacketTime(GenUtilities.getPacketTime(now));
        extHeaderInfo.setCategory1(GenUtilities.getCategory());
        extHeaderInfo.setCategory2(GenUtilities.getCategory());
        extHeaderInfo.setCategory3(GenUtilities.getCategory());
        extHeaderInfo.setSigad(GenUtilities.getSigad());
        extHeaderInfo.setDeprecatedAsciiFrequency(GenUtilities.getFreqStrFromHertzValue(GenUtilities.getFreqInHertz()));
        extHeaderInfo.setPriority(GenUtilities.getPriority());
        extHeaderInfo.setBandwidth(GenUtilities.getBandwidth());
        extHeaderInfo.setIdno(GenUtilities.toPaddedIdno("13121"));
        extHeaderInfo.setModulation(GenUtilities.getModulation());
        extHeaderInfo.setEmitterLatitude("321254S");
        extHeaderInfo.setOpNote(GenUtilities.getOpNote());
        extHeaderInfo.setKeyword(GenUtilities.getKeyword());
        extHeaderInfo.setPddg(GenUtilities.toPaddedPddg("AA"));
        extHeaderInfo.setStreamStateIndicator(StreamStateType.START);
        byte[] raw = extHeaderInfo.toBytes();
        ExtendedHeaderInfo received = SupportedExtendedHeaderInfo.toExtendedHeaderFromBytes(
                ExtendedHeaderInfo.AGS_EXTENDED_HEADER_PROFILE_19507_PREAMBLE_VALUE, raw);
        assertThat("wrong encoded byte length!!!", received.toBytes().length, is(equalTo(raw.length)));
        assertThat(
                "wrong classification", received.getClassification(), is(equalTo(extHeaderInfo.getClassification())));
        assertThat("wrong missionName", received.getMissionName(), is(equalTo(extHeaderInfo.getMissionName())));
        assertThat("wrong caseNotation1", received.getCaseNotation1(), is(equalTo(extHeaderInfo.getCaseNotation1())));
        assertThat("wrong caseNotation2", received.getCaseNotation2(), is(equalTo(extHeaderInfo.getCaseNotation2())));
        assertThat("wrong caseNotation3", received.getCaseNotation3(), is(equalTo(extHeaderInfo.getCaseNotation3())));
        assertThat(
                "wrong emitterLongitude",
                received.getEmitterLongitude(),
                is(equalTo(extHeaderInfo.getEmitterLongitude())));
        assertThat(
                "wrong firstPacketDate",
                received.getFirstPacketDate(),
                is(equalTo(extHeaderInfo.getFirstPacketDate())));
        assertThat(
                "wrong currentPacketDate",
                received.getCurrentPacketDate(),
                is(equalTo(extHeaderInfo.getCurrentPacketDate())));
        assertThat(
                "wrong firstPacketTime",
                received.getFirstPacketTime(),
                is(equalTo(extHeaderInfo.getFirstPacketTime())));
        assertThat(
                "wrong currentPacketTime",
                received.getCurrentPacketTime(),
                is(equalTo(extHeaderInfo.getCurrentPacketTime())));
        assertThat("wrong category1", received.getCategory1(), is(equalTo(extHeaderInfo.getCategory1())));
        assertThat("wrong category2", received.getCategory2(), is(equalTo(extHeaderInfo.getCategory2())));
        assertThat("wrong category3", received.getCategory3(), is(equalTo(extHeaderInfo.getCategory3())));
        assertThat("wrong sigad", received.getSigad(), is(equalTo(extHeaderInfo.getSigad())));
        assertThat(
                "wrong frequency",
                received.getDeprecatedAsciiFrequency(),
                is(equalTo(extHeaderInfo.getDeprecatedAsciiFrequency())));
        assertThat("wrong priority", received.getPriority(), is(equalTo(extHeaderInfo.getPriority())));
        assertThat("wrong bandwidth", received.getBandwidth(), is(equalTo(extHeaderInfo.getBandwidth())));
        assertThat("wrong idno", received.getIdno(), is(equalTo(extHeaderInfo.getIdno())));
        assertThat("wrong modulation", received.getModulation(), is(equalTo(extHeaderInfo.getModulation())));
        assertThat(
                "wrong emitterLatitude",
                received.getEmitterLatitude(),
                is(equalTo(extHeaderInfo.getEmitterLatitude())));
        assertThat("wrong opNote", received.getOpNote(), is(equalTo(extHeaderInfo.getOpNote())));
        assertThat("wrong keyword", received.getKeyword(), is(equalTo(extHeaderInfo.getKeyword())));
        assertThat("wrong pddg", received.getPddg(), is(equalTo(extHeaderInfo.getPddg())));
        assertThat(
                "wrong SSI",
                received.getStreamStateIndicator().getRawStreamStateIndicatorValue(),
                is(equalTo(extHeaderInfo.getStreamStateIndicator().getRawStreamStateIndicatorValue())));
        log.debug("end");
    }

    @Test
    public void testDecoding005() {
        log.debug("start");
        ExtendedHeaderInfo extHeaderInfo = new ExtendedHeaderInfo19507();
        extHeaderInfo.setClassification(GenUtilities.toPaddedClassification("UNCLASSIFIED_FOUO"));
        extHeaderInfo.setMissionName("FUEW-22JAN18");
        extHeaderInfo.setCaseNotation1(GenUtilities.getCaseNot());
        extHeaderInfo.setCaseNotation2(GenUtilities.getCaseNot());
        extHeaderInfo.setCaseNotation3(GenUtilities.getCaseNot());
        extHeaderInfo.setEmitterLongitude("1322712E");
        DateTime now = DateTime.now();
        DateTime tenMinutesAgo = DateTime.now().minusMinutes(10);
        extHeaderInfo.setFirstPacketDate(GenUtilities.getPacketDate(tenMinutesAgo));
        extHeaderInfo.setCurrentPacketDate(GenUtilities.getPacketDate(now));
        extHeaderInfo.setFirstPacketTime(GenUtilities.getPacketTime(tenMinutesAgo));
        extHeaderInfo.setCurrentPacketTime(GenUtilities.getPacketTime(now));
        extHeaderInfo.setCategory1(GenUtilities.getCategory());
        extHeaderInfo.setCategory2(GenUtilities.getCategory());
        extHeaderInfo.setCategory3(GenUtilities.getCategory());
        extHeaderInfo.setSigad(GenUtilities.getSigad());
        extHeaderInfo.setDeprecatedAsciiFrequency(GenUtilities.getFreqStrFromHertzValue(GenUtilities.getFreqInHertz()));
        extHeaderInfo.setPriority(GenUtilities.getPriority());
        extHeaderInfo.setBandwidth(GenUtilities.getBandwidth());
        extHeaderInfo.setIdno(GenUtilities.toPaddedIdno("5"));
        extHeaderInfo.setModulation(GenUtilities.getModulation());
        extHeaderInfo.setEmitterLatitude("321254S");
        extHeaderInfo.setOpNote(GenUtilities.getOpNote());
        extHeaderInfo.setKeyword(GenUtilities.getKeyword());
        extHeaderInfo.setPddg(GenUtilities.toPaddedPddg("AA"));
        extHeaderInfo.setStreamStateIndicator(StreamStateType.START);
        byte[] raw = extHeaderInfo.toBytes();
        ExtendedHeaderInfo received = SupportedExtendedHeaderInfo.toExtendedHeaderFromBytes(
                ExtendedHeaderInfo.AGS_EXTENDED_HEADER_PROFILE_19507_PREAMBLE_VALUE, raw);
        assertThat("wrong encoded byte length!!!", received.toBytes().length, is(equalTo(raw.length)));
        assertThat(
                "wrong classification", received.getClassification(), is(equalTo(extHeaderInfo.getClassification())));
        assertThat("wrong missionName", received.getMissionName(), is(equalTo(extHeaderInfo.getMissionName())));
        assertThat("wrong caseNotation1", received.getCaseNotation1(), is(equalTo(extHeaderInfo.getCaseNotation1())));
        assertThat("wrong caseNotation2", received.getCaseNotation2(), is(equalTo(extHeaderInfo.getCaseNotation2())));
        assertThat("wrong caseNotation3", received.getCaseNotation3(), is(equalTo(extHeaderInfo.getCaseNotation3())));
        assertThat(
                "wrong emitterLongitude",
                received.getEmitterLongitude(),
                is(equalTo(extHeaderInfo.getEmitterLongitude())));
        assertThat(
                "wrong firstPacketDate",
                received.getFirstPacketDate(),
                is(equalTo(extHeaderInfo.getFirstPacketDate())));
        assertThat(
                "wrong currentPacketDate",
                received.getCurrentPacketDate(),
                is(equalTo(extHeaderInfo.getCurrentPacketDate())));
        assertThat(
                "wrong firstPacketTime",
                received.getFirstPacketTime(),
                is(equalTo(extHeaderInfo.getFirstPacketTime())));
        assertThat(
                "wrong currentPacketTime",
                received.getCurrentPacketTime(),
                is(equalTo(extHeaderInfo.getCurrentPacketTime())));
        assertThat("wrong category1", received.getCategory1(), is(equalTo(extHeaderInfo.getCategory1())));
        assertThat("wrong category2", received.getCategory2(), is(equalTo(extHeaderInfo.getCategory2())));
        assertThat("wrong category3", received.getCategory3(), is(equalTo(extHeaderInfo.getCategory3())));
        assertThat("wrong sigad", received.getSigad(), is(equalTo(extHeaderInfo.getSigad())));
        assertThat(
                "wrong frequency",
                received.getDeprecatedAsciiFrequency(),
                is(equalTo(extHeaderInfo.getDeprecatedAsciiFrequency())));
        assertThat("wrong priority", received.getPriority(), is(equalTo(extHeaderInfo.getPriority())));
        assertThat("wrong bandwidth", received.getBandwidth(), is(equalTo(extHeaderInfo.getBandwidth())));
        assertThat("wrong idno", received.getIdno(), is(equalTo(extHeaderInfo.getIdno())));
        assertThat("wrong modulation", received.getModulation(), is(equalTo(extHeaderInfo.getModulation())));
        assertThat(
                "wrong emitterLatitude",
                received.getEmitterLatitude(),
                is(equalTo(extHeaderInfo.getEmitterLatitude())));
        assertThat("wrong opNote", received.getOpNote(), is(equalTo(extHeaderInfo.getOpNote())));
        assertThat("wrong keyword", received.getKeyword(), is(equalTo(extHeaderInfo.getKeyword())));
        assertThat("wrong pddg", received.getPddg(), is(equalTo(extHeaderInfo.getPddg())));
        assertThat(
                "wrong SSI",
                received.getStreamStateIndicator().getRawStreamStateIndicatorValue(),
                is(equalTo(extHeaderInfo.getStreamStateIndicator().getRawStreamStateIndicatorValue())));
        log.debug("end");
    }

    @Test
    public void testException0001() {
        log.debug("start");
        boolean flag1 = false;
        boolean flag2 = false;
        ExtendedHeaderInfo extHeaderInfo = new ExtendedHeaderInfo19507();
        try {
            extHeaderInfo.setFrequency(0L);
        } catch (UnsupportedOperationException uoe1) {
            flag1 = true;
        }
        try {
            extHeaderInfo.getFrequency();
        } catch (UnsupportedOperationException uoe1) {
            flag2 = true;
        }
        assertThat(
                "Extended header info setter is NOT throwing unsupported exception for setting frequency in long for profile 19507.",
                flag1,
                is(equalTo(true)));
        assertThat(
                "Extended header info setter is NOT throwing unsupported exception for getting frequency in long for profile 19507.",
                flag2,
                is(equalTo(true)));
        log.debug("end");
    }

    @Test
    public void testPrintSnapshot() {
        log.debug("start");
        ExtendedHeaderInfo extHeaderInfo = new ExtendedHeaderInfo19507();
        extHeaderInfo.setClassification(GenUtilities.toPaddedClassification("UNCLASSIFIED_FOUO"));
        extHeaderInfo.setMissionName("FUEW-22JAN18");
        extHeaderInfo.setCaseNotation1(GenUtilities.getCaseNot());
        extHeaderInfo.setCaseNotation2(GenUtilities.getCaseNot());
        extHeaderInfo.setCaseNotation3(GenUtilities.getCaseNot());
        extHeaderInfo.setEmitterLongitude("1322712E");
        DateTime now = DateTime.now();
        DateTime tenMinutesAgo = DateTime.now().minusMinutes(10);
        extHeaderInfo.setFirstPacketDate(GenUtilities.getPacketDate(tenMinutesAgo));
        extHeaderInfo.setCurrentPacketDate(GenUtilities.getPacketDate(now));
        extHeaderInfo.setFirstPacketTime(GenUtilities.getPacketTime(tenMinutesAgo));
        extHeaderInfo.setCurrentPacketTime(GenUtilities.getPacketTime(now));
        extHeaderInfo.setCategory1(GenUtilities.getCategory());
        extHeaderInfo.setCategory2(GenUtilities.getCategory());
        extHeaderInfo.setCategory3(GenUtilities.getCategory());
        extHeaderInfo.setSigad(GenUtilities.getSigad());
        extHeaderInfo.setDeprecatedAsciiFrequency(GenUtilities.getFreqStrFromHertzValue(GenUtilities.getFreqInHertz()));
        extHeaderInfo.setPriority(GenUtilities.getPriority());
        extHeaderInfo.setBandwidth(GenUtilities.getBandwidth());
        extHeaderInfo.setIdno(GenUtilities.toPaddedIdno("5"));
        extHeaderInfo.setModulation(GenUtilities.getModulation());
        extHeaderInfo.setEmitterLatitude("321254S");
        extHeaderInfo.setOpNote(GenUtilities.getOpNote());
        extHeaderInfo.setKeyword(GenUtilities.getKeyword());
        extHeaderInfo.setPddg(GenUtilities.toPaddedPddg("AA"));
        extHeaderInfo.setStreamStateIndicator(StreamStateType.START);
        extHeaderInfo.printSnapshot();
        // no exception should be thrown
        log.debug("end");
    }

    @Test
    public void testToString() {
        log.debug("start");
        ExtendedHeaderInfo extHeaderInfo = new ExtendedHeaderInfo19507();
        extHeaderInfo.setClassification(GenUtilities.toPaddedClassification("UNCLASSIFIED_FOUO"));
        extHeaderInfo.setMissionName("FUEW-22JAN18");
        extHeaderInfo.setCaseNotation1(GenUtilities.getCaseNot());
        extHeaderInfo.setCaseNotation2(GenUtilities.getCaseNot());
        extHeaderInfo.setCaseNotation3(GenUtilities.getCaseNot());
        extHeaderInfo.setEmitterLongitude("1322712E");
        DateTime now = DateTime.now();
        DateTime tenMinutesAgo = DateTime.now().minusMinutes(10);
        extHeaderInfo.setFirstPacketDate(GenUtilities.getPacketDate(tenMinutesAgo));
        extHeaderInfo.setCurrentPacketDate(GenUtilities.getPacketDate(now));
        extHeaderInfo.setFirstPacketTime(GenUtilities.getPacketTime(tenMinutesAgo));
        extHeaderInfo.setCurrentPacketTime(GenUtilities.getPacketTime(now));
        extHeaderInfo.setCategory1(GenUtilities.getCategory());
        extHeaderInfo.setCategory2(GenUtilities.getCategory());
        extHeaderInfo.setCategory3(GenUtilities.getCategory());
        extHeaderInfo.setSigad(GenUtilities.getSigad());
        extHeaderInfo.setDeprecatedAsciiFrequency(GenUtilities.getFreqStrFromHertzValue(GenUtilities.getFreqInHertz()));
        extHeaderInfo.setPriority(GenUtilities.getPriority());
        extHeaderInfo.setBandwidth(GenUtilities.getBandwidth());
        extHeaderInfo.setIdno(GenUtilities.toPaddedIdno("5"));
        extHeaderInfo.setModulation(GenUtilities.getModulation());
        extHeaderInfo.setEmitterLatitude("321254S");
        extHeaderInfo.setOpNote(GenUtilities.getOpNote());
        extHeaderInfo.setKeyword(GenUtilities.getKeyword());
        extHeaderInfo.setPddg(GenUtilities.toPaddedPddg("AA"));
        extHeaderInfo.setStreamStateIndicator(StreamStateType.START);
        extHeaderInfo.toString();
        // no exception should be thrown
        log.debug("end");
    }
}
