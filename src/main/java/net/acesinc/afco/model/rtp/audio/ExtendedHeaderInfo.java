package net.acesinc.afco.model.rtp.audio;

import java.nio.charset.Charset;

/**
 * @author jeremytaylor
 */
public interface ExtendedHeaderInfo {
    public static final int AGS_EXTENDED_HEADER_PROFILE_19509_PREAMBLE_VALUE = 19509;
    public static final int ACTUAL_AGS_EXT_HEADER_32BIT_BLOCK_LENGTH_PROFILE_19509 = 88;
    public static final int ACTUAL_AGS_EXT_HEADER_PROFILE_19509_LENGTH_IN_BYTES =
            (int) ((ACTUAL_AGS_EXT_HEADER_32BIT_BLOCK_LENGTH_PROFILE_19509 * 32) / 8);
    public static final int AGS_EXTENDED_HEADER_PROFILE_19507_PREAMBLE_VALUE = 19507;
    public static final int ACTUAL_AGS_EXT_HEADER_32BIT_BLOCK_LENGTH_PROFILE_19507 = 87;
    public static final int ACTUAL_AGS_EXT_HEADER_PROFILE_19507_LENGTH_IN_BYTES =
            (int) ((ACTUAL_AGS_EXT_HEADER_32BIT_BLOCK_LENGTH_PROFILE_19507 * 32) / 8);
    public static final int AGS_EXTENDED_HEADER_PROFILE_19510_PREAMBLE_VALUE = 19510;
    public static final int ACTUAL_AGS_EXT_HEADER_32BIT_BLOCK_LENGTH_PROFILE_19510 = 95;
    public static final int ACTUAL_AGS_EXT_HEADER_PROFILE_19510_LENGTH_IN_BYTES =
            (int) ((ACTUAL_AGS_EXT_HEADER_32BIT_BLOCK_LENGTH_PROFILE_19510 * 32) / 8);
    public static final int AGS_EXTENDED_HEADER_PROFILE_19511_PREAMBLE_VALUE = 19511;
    public static final int ACTUAL_AGS_EXT_HEADER_32BIT_BLOCK_LENGTH_PROFILE_19511 = 100;
    public static final int ACTUAL_AGS_EXT_HEADER_PROFILE_19511_LENGTH_IN_BYTES =
            (int) ((ACTUAL_AGS_EXT_HEADER_32BIT_BLOCK_LENGTH_PROFILE_19511 * 32) / 8);
    public static final Charset UTF8 = Charset.forName("UTF-8");

    /**
     * @return integer (int) value of RTP extended header preamble profile
     */
    public int getAgsExtHeaderPreambleProfileValue();

    /**
     * @return integer (int) of corresponding 32 bit block length to a particular RTP extended header preamble profile
     */
    public int getActualAgsExtHeader32BitBlockLength();

    /**
     * @return integer (int) of corresponding length in bytes to a particular RTP extended header preamble profile
     */
    public int getActualAgsExtHeaderLengthInBytes();

    /**
     * @return the raw bytes serialized of the ExtendedHeaderInfo object
     */
    public byte[] toBytes();

    /**
     * a pretty print snapshot of the RTP extended header that will hit the logs
     */
    public void printSnapshot();

    /**
     * @return pretty print string of object
     */
    public String toString();

    /**
     * @return the classification
     */
    public String getClassification();

    /**
     * @param classification the classification to set
     */
    public void setClassification(String classification);

    /**
     * @return the missionName
     */
    public String getMissionName();

    /**
     * @param missionName the missionName to set
     */
    public void setMissionName(String missionName);

    /**
     * @return the caseNotation1
     */
    public String getCaseNotation1();

    /**
     * @param caseNotation1 the caseNotation1 to set
     */
    public void setCaseNotation1(String caseNotation1);

    /**
     * @return the caseNotation2
     */
    public String getCaseNotation2();

    /**
     * @param caseNotation2 the caseNotation2 to set
     */
    public void setCaseNotation2(String caseNotation2);

    /**
     * @return the caseNotation3
     */
    public String getCaseNotation3();

    /**
     * @param caseNotation3 the caseNotation3 to set
     */
    public void setCaseNotation3(String caseNotation3);

    /**
     * @return the emitterLongitude
     */
    public String getEmitterLongitude();

    /**
     * @param emitterLongitude the emitterLongitude to set
     */
    public void setEmitterLongitude(String emitterLongitude);

    /**
     * @return the firstPacketDate
     */
    public String getFirstPacketDate();

    /**
     * @param firstPacketDate the firstPacketDate to set
     */
    public void setFirstPacketDate(String firstPacketDate);

    /**
     * @return the currentPacketDate
     */
    public String getCurrentPacketDate();

    /**
     * @param currentPacketDate the currentPacketDate to set
     */
    public void setCurrentPacketDate(String currentPacketDate);

    /**
     * @return the firstPacketTime
     */
    public String getFirstPacketTime();

    /**
     * @param firstPacketTime the firstPacketTime to set
     */
    public void setFirstPacketTime(String firstPacketTime);

    /**
     * @return the currentPacketTime
     */
    public String getCurrentPacketTime();

    /**
     * @param currentPacketTime the currentPacketTime to set
     */
    public void setCurrentPacketTime(String currentPacketTime);

    /**
     * @return the category1
     */
    public String getCategory1();

    /**
     * @param category1 the category1 to set
     */
    public void setCategory1(String category1);

    /**
     * @return the category2
     */
    public String getCategory2();

    /**
     * @param category2 the category2 to set
     */
    public void setCategory2(String category2);

    /**
     * @return the category3
     */
    public String getCategory3();

    /**
     * @param category3 the category3 to set
     */
    public void setCategory3(String category3);

    /**
     * @return the sigad
     */
    public String getSigad();

    /**
     * @param sigad the sigad to set
     */
    public void setSigad(String sigad);

    /**
     * the deprecated ASCII frequency -- 11 chars
     */
    public String getDeprecatedAsciiFrequency();

    /**
     * @param deprecatedAsciiFrequency
     */
    public void setDeprecatedAsciiFrequency(String deprecatedAsciiFrequency);

    /**
     * @return the priority
     */
    public String getPriority();

    /**
     * @param priority the priority to set
     */
    public void setPriority(String priority);

    /**
     * @return the bandwidth
     */
    public String getBandwidth();

    /**
     * @param bandwidth the bandwidth to set
     */
    public void setBandwidth(String bandwidth);

    /**
     * @return the idno
     */
    public String getIdno();

    /**
     * @param idno the idno to set
     */
    public void setIdno(String idno);

    /**
     * @return the modulation
     */
    public String getModulation();

    /**
     * @param modulation the modulation to set
     */
    public void setModulation(String modulation);

    /**
     * @return the emitterLatitude
     */
    public String getEmitterLatitude();

    /**
     * @param emitterLatitude the emitterLatitude to set
     */
    public void setEmitterLatitude(String emitterLatitude);

    /**
     * @return the opNote
     */
    public String getOpNote();

    /**
     * @param opNote the opNote to set
     */
    public void setOpNote(String opNote);

    /**
     * @return the keyword
     */
    public String getKeyword();

    /**
     * @param keyword the keyword to set
     */
    public void setKeyword(String keyword);

    /**
     * @return the pddg
     */
    public String getPddg();

    /**
     * @param pddg the pddg to set
     */
    public void setPddg(String pddg);

    /**
     * @return the streamStateIndicator
     */
    public StreamStateType getStreamStateIndicator();

    /**
     * @param streamStateIndicator the streamStateIndicator to set
     */
    public void setStreamStateIndicator(StreamStateType streamStateIndicator);

    /**
     * @return the frequency
     */
    public long getFrequency();

    /**
     * @param frequency the frequency to set
     */
    public void setFrequency(long frequency);

    public void setOperatorId(String operatorId);

    public String getOperatorId();

    public Short getSignalType();

    public void setSignalType(Short signalType);

    public void setSpecialField1(long specialField1);

    public long getSpecialField1();

    public void setSpecialField2(String specialField2);

    public String getSpecialField2();
}
