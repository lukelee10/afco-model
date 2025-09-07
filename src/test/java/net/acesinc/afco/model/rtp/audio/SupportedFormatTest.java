/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.afco.model.rtp.audio;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import javax.sound.sampled.AudioFormat;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A test to help test the audio format focused utility that focuses on payload
 * types for SDP to specify audio format details.
 *
 * @author jeremytaylor
 */
public class SupportedFormatTest {

    private static Logger log = LoggerFactory.getLogger(SupportedFormatTest.class);

    public SupportedFormatTest() {}

    SupportedAudioFormat saf;

    /**
     * to test SDP audio format rtp payloadType generation for pre-defined
     * payloadType example for payload type 8 -- here we are giving the rtpmap
     * as requested even though specs do NOT want rtpmap for pre-defined payload
     * types. We are just doing our duty.
     */
    @Test
    public void preDefinedPayloadTypeEight() {
        String expectedMLine = "m=audio 0 RTP/AVP 8";
        String expectedA1Line = "a=rtcp:12401";
        // a=rtpmap:8 PCMA/8000/1 or a=rtpmap: PCMA/8000 should both be fine technically, but it's a slight pain to
        // support both and the first
        // should still work.  When only using one channel is used, you aren't required to be explicit on specifying the
        // channel value.
        String expectedA2Line = "a=rtpmap:8 PCMA/8000/1";
        int rtpPort = 0;
        int rtcpPort = 12401;
        int payloadType = 8;
        saf = new SupportedAudioFormat(payloadType);
        saf.setBigEndian(true);
        saf.setChannels(1);
        saf.setEncoding(AudioFormat.Encoding.ALAW);
        saf.setFrameRate(8000.0F);
        saf.setFrameSize(2);
        saf.setSampleRate(8000.0F);
        saf.setSampleSizeInBits(8);

        String[] sdpResults = saf.toSdpOfferAnswerAudioFormatLines(rtpPort, rtcpPort);
        assertThat("sdpResults array is wrong length for pre-defined payloadType", sdpResults.length, is(equalTo(3)));
        StringBuilder buff = new StringBuilder();
        for (String sdpR : sdpResults) {
            buff.append(sdpR);
            buff.append("\n");
        }
        log.debug(buff.toString());

        assertThat("m-line is incorrect for pre-defined payloadType", sdpResults[0], is(equalTo(expectedMLine)));
        assertThat("1st a-line is incorrect for pre-defined payloadType", sdpResults[1], is(equalTo(expectedA1Line)));
        assertThat(
                "2nd a-line is incorrect for pre-defined payloadType -- even though we shouldn't have to display this, but are having to",
                sdpResults[2],
                is(equalTo(expectedA2Line)));
    }

    /**
     * to test SDP audio format rtp payloadType generation for pre-defined
     * payloadType example for payload type 0 -- here we are giving the rtpmap
     * as requested even though specs do NOT want rtpmap for pre-defined payload
     * types. We are just doing our duty. Here, we've discovered that the
     * channel for payload type 0 should not be mentioned, so this tests for
     * that.
     */
    @Test
    public void preDefinedPayloadTypeZero() {
        String expectedMLine = "m=audio 0 RTP/AVP 0";
        String expectedA1Line = "a=rtcp:12401";
        // a=rtpmap: PCMU/8000 should be used here instead of a=rtpmap:8 PCMU/8000/1.  Both should both be fine
        // technically, but we've been told explicitly to NOT mention the channel for when paylad type 0 is used.
        // Thus, the default of 1 channel is to be inferred and cannot be stated explicitly here.
        String expectedA2Line = "a=rtpmap:0 PCMU/8000";
        int rtpPort = 0;
        int rtcpPort = 12401;
        int payloadType = 0;
        saf = new SupportedAudioFormat(payloadType);
        saf.setBigEndian(true);
        saf.setChannels(1);
        saf.setEncoding(AudioFormat.Encoding.ULAW);
        saf.setFrameRate(8000.0F);
        saf.setFrameSize(2);
        saf.setSampleRate(8000.0F);
        saf.setSampleSizeInBits(8);

        String[] sdpResults = saf.toSdpOfferAnswerAudioFormatLines(rtpPort, rtcpPort);
        assertThat("sdpResults array is wrong length for pre-defined payloadType", sdpResults.length, is(equalTo(3)));
        StringBuilder buff = new StringBuilder();
        for (String sdpR : sdpResults) {
            buff.append(sdpR);
            buff.append("\n");
        }
        log.debug(buff.toString());

        assertThat("m-line is incorrect for pre-defined payloadType", sdpResults[0], is(equalTo(expectedMLine)));
        assertThat("1st a-line is incorrect for pre-defined payloadType", sdpResults[1], is(equalTo(expectedA1Line)));
        assertThat(
                "2nd a-line is incorrect for pre-defined payloadType -- even though we shouldn't have to display this, but are having to",
                sdpResults[2],
                is(equalTo(expectedA2Line)));
    }

    /**
     * to test SDP audio format rtp payloadType generation for user-defined
     * payloadType example
     */
    @Test
    public void userDefinedPayloadType() {
        String expectedMLine = "m=audio 0 RTP/AVP 36";
        String expectedA1Line = "a=rtcp:12401";
        // a=rtpmap:36 L8/8000/1 or a=rtpmap:36 L8/8000 should both be fine technically, but it's a slight pain to
        // support both and the first
        // should still work.  When only using one channel is used, you aren't required to be explicit on specifying the
        // channel value.
        String expectedA2Line = "a=rtpmap:36 L8/8000/1";
        int rtpPort = 0;
        int rtcpPort = 12401;
        int payloadType = 36;
        saf = new SupportedAudioFormat(payloadType);
        saf.setBigEndian(true);
        saf.setChannels(1);
        saf.setEncoding(AudioFormat.Encoding.PCM_SIGNED);
        saf.setFrameRate(8000.0F);
        saf.setFrameSize(2);
        saf.setSampleRate(8000.0F);
        saf.setSampleSizeInBits(8);

        String[] sdpResults = saf.toSdpOfferAnswerAudioFormatLines(rtpPort, rtcpPort);
        assertThat("sdpResults array is wrong length for user-defined payloadType", sdpResults.length, is(equalTo(3)));
        StringBuilder buff = new StringBuilder();
        for (String sdpR : sdpResults) {
            buff.append(sdpR);
            buff.append("\n");
        }
        log.debug(buff.toString());
        assertThat("m-line is incorrect for user-defined payloadType", sdpResults[0], is(equalTo(expectedMLine)));
        assertThat("1st a-line is incorrect for user-defined payloadType", sdpResults[1], is(equalTo(expectedA1Line)));
        assertThat("2nd a-line is incorrect for user-defined payloadType", sdpResults[2], is(equalTo(expectedA2Line)));
    }

    /**
     * This tests for NO NPE being thrown on PT is user-defined, but for an
     * IllegalArgument exception instead when the encoding is not set on calls
     * to ToSDPOfferAnswer....
     */
    @Test
    public void noEncodingSetAndUsingToSdpOfferAnswerAudioFormatLines() {
        int rtpPort = 0;
        int rtcpPort = 12401;
        int payloadType = 36;
        saf = new SupportedAudioFormat(payloadType);
        saf.setBigEndian(true);
        saf.setChannels(1);
        // no encoding set
        saf.setFrameRate(8000.0F);
        saf.setFrameSize(2);
        saf.setSampleRate(8000.0F);
        saf.setSampleSizeInBits(8);
        boolean flag1 = false;
        boolean flag2 = true;
        try {
            saf.toSdpOfferAnswerAudioFormatLines(rtpPort, rtcpPort);
            flag2 = true;
        } catch (NullPointerException npe) {
            flag2 = false;
        } catch (IllegalArgumentException iae) {
            flag1 = true;
        }

        assertThat("IllegalArgumentException was NOT thrown when encoding was NOT set", flag1, is(true));
        assertThat(
                "NullPointerException should NOT be thrown when encoding is NOT set.  Unwanted NPE. We want to prevent this one.",
                flag2,
                is(true));
    }

    /**
     * This tests for NO NPE being thrown when no encoding set on toString()
     * method
     */
    @Test
    public void noEnodingSetAndUsingToString() {
        String enc = "Encoding is NOT set!!!";
        int payloadType = 36;
        saf = new SupportedAudioFormat(payloadType);
        saf.setBigEndian(true);
        saf.setChannels(1);
        // no encoding set
        saf.setFrameRate(8000.0F);
        saf.setFrameSize(2);
        saf.setSampleRate(8000.0F);
        saf.setSampleSizeInBits(8);
        boolean flag = false;
        String tmp = "";
        try {
            tmp = saf.toString();
            flag = true;
        } catch (NullPointerException npe) {
            flag = false;
        }
        assertThat(
                "NullPointerException should NOT be thrown when encoding is NOT set.  Unwanted NPE. We want to prevent this one.",
                flag,
                is(true));
        assertThat(
                "Does NOT contain expected string in toString() statement when encoding is NOT set.",
                tmp.contains(enc),
                is(true));
    }

    /**
     * This tests for NO NPE being thrown when no encoding set on
     * toAudioFormat() method
     */
    @Test
    public void noEncodingSetAndUsingToAudioFormat() {
        int payloadType = 36;
        saf = new SupportedAudioFormat(payloadType);
        // no encoding set
        saf = new SupportedAudioFormat(payloadType);
        saf.setBigEndian(true);
        saf.setChannels(1);
        // no encoding set
        saf.setFrameRate(8000.0F);
        saf.setFrameSize(2);
        saf.setSampleRate(8000.0F);
        saf.setSampleSizeInBits(8);
        boolean flag = false;
        try {
            saf.toAudioFormat();
            flag = true;
        } catch (NullPointerException npe) {
            flag = false;
        }
        assertThat(
                "NullPointerException should NOT be thrown when encoding is NOT set.  Unwanted NPE. We want to prevent this one.",
                flag,
                is(true));
    }
}
