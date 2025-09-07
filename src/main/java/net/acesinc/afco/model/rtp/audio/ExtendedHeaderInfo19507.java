package net.acesinc.afco.model.rtp.audio;

import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author jeremytaylor
 */
public class ExtendedHeaderInfo19507 extends SupportedExtendedHeaderInfo {

    private static final Logger log =
            LoggerFactory.getLogger(net.acesinc.afco.model.rtp.audio.ExtendedHeaderInfo19507.class);

    /**
     * 64 chars
     */
    private String classification;
    /**
     * 12 chars
     */
    private String missionName;
    /**
     * 16 chars
     */
    private String caseNotation1;
    /**
     * 16 chars
     */
    private String caseNotation2;
    /**
     * 16 chars
     */
    private String caseNotation3;
    /**
     * 8 chars
     */
    private String emitterLongitude;
    /**
     * 8 chars
     */
    private String firstPacketDate;
    /**
     * 8 chars
     */
    private String currentPacketDate;
    /**
     * 6 chars
     */
    private String firstPacketTime;
    /**
     * 6 chars
     */
    private String currentPacketTime;
    /**
     * 6 chars
     */
    private String category1;
    /**
     * 6 chars
     */
    private String category2;
    /**
     * 6 chars
     */
    private String category3;
    /**
     * 10 chars
     */
    private String sigad;
    /**
     * 11 chars
     */
    private String deprecatedAsciiFrequency;
    /**
     * 1 char
     */
    private String priority;
    /**
     * 11 chars
     */
    private String bandwidth;
    /**
     * 5 chars
     */
    private String idno;
    /**
     * 9 chars
     */
    private String modulation;
    /**
     * 7 chars
     */
    private String emitterLatitude;
    /**
     * 80 chars
     */
    private String opNote;
    /**
     * 30 chars
     */
    private String keyword;
    /**
     * 5 chars
     */
    private String pddg;
    /**
     * 1 char -- using enum here
     */
    private StreamStateType streamStateIndicator = StreamStateType.UNKNOWN;

    @Override
    public int getAgsExtHeaderPreambleProfileValue() {
        return ExtendedHeaderInfo.AGS_EXTENDED_HEADER_PROFILE_19507_PREAMBLE_VALUE;
    }

    @Override
    public byte[] toBytes() {
        //        log.debug("converting extended header to raw bytes as actually packaged in the RTP packet...");
        StringBuilder extHeaderInChars = new StringBuilder();
        extHeaderInChars.append(this.classification);
        extHeaderInChars.append(this.missionName);
        extHeaderInChars.append(this.caseNotation1);
        extHeaderInChars.append(this.caseNotation2);
        extHeaderInChars.append(this.caseNotation3);
        extHeaderInChars.append(this.emitterLongitude);
        extHeaderInChars.append(this.firstPacketDate);
        extHeaderInChars.append(this.currentPacketDate);
        extHeaderInChars.append(this.firstPacketTime);
        extHeaderInChars.append(this.currentPacketTime);
        extHeaderInChars.append(this.category1);
        extHeaderInChars.append(this.category2);
        extHeaderInChars.append(this.category3);
        extHeaderInChars.append(this.sigad);
        extHeaderInChars.append(this.deprecatedAsciiFrequency);
        extHeaderInChars.append(this.priority);
        extHeaderInChars.append(this.bandwidth);
        extHeaderInChars.append(this.idno);
        extHeaderInChars.append(this.modulation);
        extHeaderInChars.append(this.emitterLatitude);
        extHeaderInChars.append(this.opNote);
        extHeaderInChars.append(this.keyword);
        extHeaderInChars.append(this.pddg);
        extHeaderInChars.append(this.getStreamStateIndicator().getRawStreamStateIndicatorValue());
        byte[] extHeaderRawContents =
                Arrays.copyOf(extHeaderInChars.toString().getBytes(UTF8), this.getActualAgsExtHeaderLengthInBytes());
        //        log.debug("Constructed Raw extHeaderContents: [" + new String(extHeaderRawContents)+"]");
        if (extHeaderRawContents.length != this.getActualAgsExtHeaderLengthInBytes()) {
            throw new IllegalStateException(String.format(
                    "The length of the encoded raw extended header contents is [%d] bytes and should instead be [%d] bytes.",
                    extHeaderRawContents.length, this.getActualAgsExtHeaderLengthInBytes()));
        }
        return extHeaderRawContents;
    }

    /**
     * Deserializizes the RTP
     *
     * @param rawExtendedHeader
     * @return ExtendedHeaderInfo19507
     */
    public static net.acesinc.afco.model.rtp.audio.ExtendedHeaderInfo19507 toExtendedHeaderFromBytes(
            byte[] rawExtendedHeader) {
        log.trace("deserializing raw extension header bytes into ExtendedHeaderInfo instance...");
        if (rawExtendedHeader.length
                != ExtendedHeaderInfo19507.getSupportedProfileBytesLength(
                        ExtendedHeaderInfo.AGS_EXTENDED_HEADER_PROFILE_19507_PREAMBLE_VALUE)) {
            log.error(String.format(
                    "Error, rawExtenderHeader length in bytes is: [%d]. rawExtendedHeader length in bytes SHOULD BE: [%d].",
                    rawExtendedHeader.length,
                    ExtendedHeaderInfo19507.getSupportedProfileBytesLength(
                            ExtendedHeaderInfo.AGS_EXTENDED_HEADER_PROFILE_19507_PREAMBLE_VALUE)));
            throw new IllegalArgumentException(String.format(
                    "the byte[] array passed to ExtendedHeaderFromBytes(byte[]) static method is of an illegal length in bytes and should be the length of [%d].",
                    ExtendedHeaderInfo19507.getSupportedProfileBytesLength(
                            ExtendedHeaderInfo.AGS_EXTENDED_HEADER_PROFILE_19507_PREAMBLE_VALUE)));
        }
        net.acesinc.afco.model.rtp.audio.ExtendedHeaderInfo19507 tmp =
                new net.acesinc.afco.model.rtp.audio.ExtendedHeaderInfo19507();
        byte[] rawClassification = Arrays.copyOfRange(rawExtendedHeader, 0, 64);
        tmp.setClassification(new String(rawClassification));
        //        log.debug("classification [" + tmp.getClassification()+"]");
        byte[] rawMissionName = Arrays.copyOfRange(rawExtendedHeader, 64, 76);
        tmp.setMissionName(new String(rawMissionName));
        //        log.debug("missionName [" + tmp.getMissionName()+"]");
        byte[] rawCaseNotation1 = Arrays.copyOfRange(rawExtendedHeader, 76, 92);
        tmp.setCaseNotation1(new String(rawCaseNotation1));
        //        log.debug("caseNotation1 [" + tmp.getCaseNotation1()+"]");
        byte[] rawCaseNotation2 = Arrays.copyOfRange(rawExtendedHeader, 92, 108);
        tmp.setCaseNotation2(new String(rawCaseNotation2));
        //        log.debug("caseNotation2 [" + tmp.getCaseNotation2()+"]");
        byte[] rawCaseNotation3 = Arrays.copyOfRange(rawExtendedHeader, 108, 124);
        tmp.setCaseNotation3(new String(rawCaseNotation3));
        //        log.debug("caseNotation3 [" + tmp.getCaseNotation3()+"]");
        byte[] rawEmitterLongitude = Arrays.copyOfRange(rawExtendedHeader, 124, 132);
        tmp.setEmitterLongitude(new String(rawEmitterLongitude));
        //        log.debug("emitterLongitude [" + tmp.getEmitterLongitude()+"]");
        byte[] rawFirstPacketDate = Arrays.copyOfRange(rawExtendedHeader, 132, 140);
        tmp.setFirstPacketDate(new String(rawFirstPacketDate));
        //        log.debug("firstPacketDate [" + tmp.getFirstPacketDate()+"]");
        byte[] rawCurrentPacketDate = Arrays.copyOfRange(rawExtendedHeader, 140, 148);
        tmp.setCurrentPacketDate(new String(rawCurrentPacketDate));
        //        log.debug("currentPacketDate [" + tmp.getCurrentPacketDate()+"]");
        byte[] rawFirstPacketTime = Arrays.copyOfRange(rawExtendedHeader, 148, 154);
        tmp.setFirstPacketTime(new String(rawFirstPacketTime));
        //        log.debug("firstPacketTime [" + tmp.getFirstPacketTime()+"]");
        byte[] rawCurrentPacketTime = Arrays.copyOfRange(rawExtendedHeader, 154, 160);
        tmp.setCurrentPacketTime(new String(rawCurrentPacketTime));
        //        log.debug("currentPacketTime [" + tmp.getCurrentPacketTime()+"]");
        byte[] rawCategory1 = Arrays.copyOfRange(rawExtendedHeader, 160, 166);
        tmp.setCategory1(new String(rawCategory1));
        //        log.debug("category1 [" + tmp.getCategory1()+"]");
        byte[] rawCategory2 = Arrays.copyOfRange(rawExtendedHeader, 166, 172);
        tmp.setCategory2(new String(rawCategory2));
        //        log.debug("category2 [" + tmp.getCategory2()+"]");
        byte[] rawCategory3 = Arrays.copyOfRange(rawExtendedHeader, 172, 178);
        tmp.setCategory3(new String(rawCategory3));
        //        log.debug("category3 [" + tmp.getCategory3()+"]");
        byte[] rawSigad = Arrays.copyOfRange(rawExtendedHeader, 178, 188);
        tmp.setSigad(new String(rawSigad));
        //        log.debug("sigad [" + tmp.getSigad()+"]");
        byte[] rawDeprecatedAsciiFrequency = Arrays.copyOfRange(rawExtendedHeader, 188, 199);
        tmp.setDeprecatedAsciiFrequency(new String(rawDeprecatedAsciiFrequency));
        //        log.debug("frequency [" + tmp.getFrequency()+"]");
        byte[] rawPriority = Arrays.copyOfRange(rawExtendedHeader, 199, 200);
        tmp.setPriority(new String(rawPriority));
        //        log.debug("priority [" + tmp.getPriority()+"]");
        byte[] rawBandwidth = Arrays.copyOfRange(rawExtendedHeader, 200, 211);
        tmp.setBandwidth(new String(rawBandwidth));
        //        log.debug("bandwidth [" + tmp.getBandwidth()+"]");
        byte[] rawIdno = Arrays.copyOfRange(rawExtendedHeader, 211, 216);
        tmp.setIdno(new String(rawIdno));
        //        log.debug("idno [" + tmp.getIdno()+"]");
        byte[] rawModulation = Arrays.copyOfRange(rawExtendedHeader, 216, 225);
        tmp.setModulation(new String(rawModulation));
        //        log.debug("modulation [" + tmp.getModulation()+"]");
        byte[] rawEmitterLatitude = Arrays.copyOfRange(rawExtendedHeader, 225, 232);
        tmp.setEmitterLatitude(new String(rawEmitterLatitude));
        //        log.debug("emitterLatitude [" + tmp.getEmitterLatitude()+"]");
        byte[] rawOpNote = Arrays.copyOfRange(rawExtendedHeader, 232, 312);
        tmp.setOpNote(new String(rawOpNote));
        //        log.debug("opNote [" + tmp.getOpNote()+"]");
        byte[] rawKeyword = Arrays.copyOfRange(rawExtendedHeader, 312, 342);
        tmp.setKeyword(new String(rawKeyword));
        //        log.debug("keyword [" + tmp.getKeyword()+"]");
        byte[] rawPddg = Arrays.copyOfRange(rawExtendedHeader, 342, 347);
        tmp.setPddg(new String(rawPddg));
        //        log.debug("pddg [" + tmp.getPddg()+"]");
        byte[] rawStreamStateIndicator = Arrays.copyOfRange(rawExtendedHeader, 347, 348);
        tmp.setStreamStateIndicator(
                StreamStateType.getStreamStateTypeFromRawValue(new String(rawStreamStateIndicator)));
        //        log.debug("streamStateIndicator raw value [" +
        // tmp.getStreamStateIndicator().getRawStreamStateIndicatorValue() + "]" + "; enum value [" +
        // tmp.getStreamStateIndicator().name() + "]");
        return tmp;
    }

    /**
     * @return the classification
     */
    @Override
    public String getClassification() {
        return classification;
    }

    /**
     * @param classification the classification to set
     */
    @Override
    public void setClassification(String classification) {
        this.classification = classification;
    }

    /**
     * @return the missionName
     */
    @Override
    public String getMissionName() {
        return missionName;
    }

    /**
     * @param missionName the missionName to set
     */
    @Override
    public void setMissionName(String missionName) {
        this.missionName = missionName;
        if (this.missionName.length() != 12) {
            log.error(String.format(
                    "missionName length is [%d] chars.  Expected length is [12]. MissionName is [%s].",
                    missionName.length(), this.missionName));
            throw new IllegalStateException("Mission Name must be 12 chars long!");
        }
    }

    /**
     * @return the caseNotation1
     */
    @Override
    public String getCaseNotation1() {
        return caseNotation1;
    }

    /**
     * @param caseNotation1 the caseNotation1 to set
     */
    @Override
    public void setCaseNotation1(String caseNotation1) {
        this.caseNotation1 = caseNotation1;
    }

    /**
     * @return the caseNotation2
     */
    @Override
    public String getCaseNotation2() {
        return caseNotation2;
    }

    /**
     * @param caseNotation2 the caseNotation2 to set
     */
    @Override
    public void setCaseNotation2(String caseNotation2) {
        this.caseNotation2 = caseNotation2;
    }

    /**
     * @return the caseNotation3
     */
    @Override
    public String getCaseNotation3() {
        return caseNotation3;
    }

    /**
     * @param caseNotation3 the caseNotation3 to set
     */
    @Override
    public void setCaseNotation3(String caseNotation3) {
        this.caseNotation3 = caseNotation3;
    }

    /**
     * @return the emitterLongitude
     */
    @Override
    public String getEmitterLongitude() {
        return emitterLongitude;
    }

    /**
     * @param emitterLongitude the emitterLongitude to set
     */
    @Override
    public void setEmitterLongitude(String emitterLongitude) {
        this.emitterLongitude = emitterLongitude;
    }

    /**
     * @return the firstPacketDate
     */
    @Override
    public String getFirstPacketDate() {
        return firstPacketDate;
    }

    /**
     * @param firstPacketDate the firstPacketDate to set
     */
    @Override
    public void setFirstPacketDate(String firstPacketDate) {
        this.firstPacketDate = firstPacketDate;
    }

    /**
     * @return the currentPacketDate
     */
    @Override
    public String getCurrentPacketDate() {
        return currentPacketDate;
    }

    /**
     * @param currentPacketDate the currentPacketDate to set
     */
    @Override
    public void setCurrentPacketDate(String currentPacketDate) {
        this.currentPacketDate = currentPacketDate;
    }

    /**
     * @return the firstPacketTime
     */
    @Override
    public String getFirstPacketTime() {
        return firstPacketTime;
    }

    /**
     * @param firstPacketTime the firstPacketTime to set
     */
    @Override
    public void setFirstPacketTime(String firstPacketTime) {
        this.firstPacketTime = firstPacketTime;
    }

    /**
     * @return the currentPacketTime
     */
    @Override
    public String getCurrentPacketTime() {
        return currentPacketTime;
    }

    /**
     * @param currentPacketTime the currentPacketTime to set
     */
    @Override
    public void setCurrentPacketTime(String currentPacketTime) {
        this.currentPacketTime = currentPacketTime;
    }

    /**
     * @return the category1
     */
    @Override
    public String getCategory1() {
        return category1;
    }

    /**
     * @param category1 the category1 to set
     */
    @Override
    public void setCategory1(String category1) {
        this.category1 = category1;
    }

    /**
     * @return the category2
     */
    @Override
    public String getCategory2() {
        return category2;
    }

    /**
     * @param category2 the category2 to set
     */
    @Override
    public void setCategory2(String category2) {
        this.category2 = category2;
    }

    /**
     * @return the category3
     */
    @Override
    public String getCategory3() {
        return category3;
    }

    /**
     * @param category3 the category3 to set
     */
    @Override
    public void setCategory3(String category3) {
        this.category3 = category3;
    }

    /**
     * @return the sigad
     */
    @Override
    public String getSigad() {
        return sigad;
    }

    /**
     * @param sigad the sigad to set
     */
    @Override
    public void setSigad(String sigad) {
        this.sigad = sigad;
    }

    /**
     * the deprecated ASCII frequency -- 11 chars
     */
    @Override
    public String getDeprecatedAsciiFrequency() {
        return deprecatedAsciiFrequency;
    }

    /**
     * @param deprecatedAsciiFrequency
     */
    @Override
    public void setDeprecatedAsciiFrequency(String deprecatedAsciiFrequency) {
        this.deprecatedAsciiFrequency = deprecatedAsciiFrequency;
    }

    /**
     * @return the priority
     */
    @Override
    public String getPriority() {
        return priority;
    }

    /**
     * @param priority the priority to set
     */
    @Override
    public void setPriority(String priority) {
        this.priority = priority;
    }

    /**
     * @return the bandwidth
     */
    @Override
    public String getBandwidth() {
        return bandwidth;
    }

    /**
     * @param bandwidth the bandwidth to set
     */
    @Override
    public void setBandwidth(String bandwidth) {
        this.bandwidth = bandwidth;
    }

    /**
     * @return the idno
     */
    @Override
    public String getIdno() {
        return idno;
    }

    /**
     * @param idno the idno to set
     */
    @Override
    public void setIdno(String idno) {
        this.idno = idno;
    }

    /**
     * @return the modulation
     */
    @Override
    public String getModulation() {
        return modulation;
    }

    /**
     * @param modulation the modulation to set
     */
    @Override
    public void setModulation(String modulation) {
        this.modulation = modulation;
    }

    /**
     * @return the emitterLatitude
     */
    @Override
    public String getEmitterLatitude() {
        return emitterLatitude;
    }

    /**
     * @param emitterLatitude the emitterLatitude to set
     */
    @Override
    public void setEmitterLatitude(String emitterLatitude) {
        this.emitterLatitude = emitterLatitude;
    }

    /**
     * @return the opNote
     */
    @Override
    public String getOpNote() {
        return opNote;
    }

    /**
     * @param opNote the opNote to set
     */
    @Override
    public void setOpNote(String opNote) {
        this.opNote = opNote;
    }

    /**
     * @return the keyword
     */
    @Override
    public String getKeyword() {
        return keyword;
    }

    /**
     * @param keyword the keyword to set
     */
    @Override
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    /**
     * @return the pddg
     */
    @Override
    public String getPddg() {
        return pddg;
    }

    /**
     * @param pddg the pddg to set
     */
    @Override
    public void setPddg(String pddg) {
        this.pddg = pddg;
    }

    /**
     * @return the streamStateIndicator
     */
    @Override
    public StreamStateType getStreamStateIndicator() {
        return streamStateIndicator;
    }

    /**
     * @param streamStateIndicator the streamStateIndicator to set
     */
    @Override
    public void setStreamStateIndicator(StreamStateType streamStateIndicator) {
        this.streamStateIndicator = streamStateIndicator;
    }

    @Override
    public long getFrequency() {
        throw new UnsupportedOperationException(
                "RTP Extended Header Preamble Profile value 19507 does NOT support a Long for frequency!!!");
    }

    @Override
    public void setFrequency(long frequency) {
        throw new UnsupportedOperationException(
                "RTP Extended Header Preamble Profile value 19507 does NOT support a Long for frequency!!!");
    }

    /**
     * @return the operator id
     */
    @Override
    public String getOperatorId() {
        throw new UnsupportedOperationException(
                "RTP Extended Header Preamble Profile value 19507 does NOT support Operator ID!!!");
    }

    /**
     * @param operatorId the operator id to set
     */
    @Override
    public void setOperatorId(String operatorId) {
        throw new UnsupportedOperationException(
                "RTP Extended Header Preamble Profile value 19507 does NOT support Operator ID!!!");
    }

    /**
     * @return the signal type
     */
    @Override
    public Short getSignalType() {
        throw new UnsupportedOperationException(
                "RTP Extended Header Preamble Profile value 19507 does NOT support Signal Type!!!");
    }

    /**
     * @param signalType the signal type to set
     */
    @Override
    public void setSignalType(Short signalType) {
        throw new UnsupportedOperationException(
                "RTP Extended Header Preamble Profile value 19507 does NOT support Signal Type!!!");
    }

    /**
     * @return the specialField1
     */
    @Override
    public long getSpecialField1() {
        throw new UnsupportedOperationException(
                "RTP Extended Header Preamble Profile value 19507 does NOT support SpecialField1!!!");
    }

    /**
     * @param specialField1 the specialField1 id to set
     */
    @Override
    public void setSpecialField1(long specialField1) {
        throw new UnsupportedOperationException(
                "RTP Extended Header Preamble Profile value 19507 does NOT support SpecialField1!!!");
    }

    /**
     * @return the specialField2
     */
    @Override
    public String getSpecialField2() {
        throw new UnsupportedOperationException(
                "RTP Extended Header Preamble Profile value 19507 does NOT support SpecialField2!!!");
    }

    /**
     * @param specialField2 the specialField2 to set
     */
    @Override
    public void setSpecialField2(String specialField2) {
        throw new UnsupportedOperationException(
                "RTP Extended Header Preamble Profile value 19507 does NOT support SpecialField2!!!");
    }

    /**
     * Convenience method that logs the extended header at log.info level
     */
    @Override
    public void printSnapshot() {
        // NOTE: Please maintain these logging statements at INFO level.  This has been discussed and it is desirable to
        // retain and maintain the below.
        log.debug(this.toString());
    }

    /**
     * Convenience method for when printSnapshot is being finicky when being called from outside this package, so we can force this in logs no matter what easily.
     * @return pretty-print of extHdr
     */
    @Override
    @SuppressWarnings({"StringConcatenationInsideStringBufferAppend", "DuplicatedCode"})
    public String toString() {
        StringBuilder buff = new StringBuilder("\nExtension header pretty-print-out:");
        buff.append(String.format("\nclassification [%s]", this.getClassification()));
        buff.append(String.format("\nmissionName [%s]", this.getMissionName()));
        buff.append(String.format("\ncaseNotation1 [%s]", this.getCaseNotation1()));
        buff.append(String.format("\ncaseNotation2 [%s]", this.getCaseNotation2()));
        buff.append(String.format("\ncaseNotation3 [%s]", this.getCaseNotation3()));
        buff.append(String.format("\nemitterLongitude [%s]", this.getEmitterLongitude()));
        buff.append(String.format("\nfirstPacketDate [%s]", this.getFirstPacketDate()));
        buff.append(String.format("\ncurrentPacketDate [%s]", this.getCurrentPacketDate()));
        buff.append(String.format("\nfirstPacketTime [%s]", this.getFirstPacketTime()));
        buff.append(String.format("\ncurrentPacketTime [%s]", this.getCurrentPacketTime()));
        buff.append(String.format("\ncategory1 [%s]", this.getCategory1()));
        buff.append(String.format("\ncategory2 [%s]", this.getCategory2()));
        buff.append(String.format("\ncategory3 [%s]", this.getCategory3()));
        buff.append(String.format("\nsigad [%s]", this.getSigad()));
        buff.append(String.format("\ndeprecatedAsciiFrequency [%s]", this.getDeprecatedAsciiFrequency()));
        buff.append(String.format("\npriority [%s]", this.getPriority()));
        buff.append(String.format("\nbandwidth [%s]", this.getBandwidth()));
        buff.append(String.format("\nidno [%s]", this.getIdno()));
        buff.append(String.format("\nmodulation [%s]", this.getModulation()));
        buff.append(String.format("\nemitterLatitude [%s]", this.getEmitterLatitude()));
        buff.append(String.format("\nopNote [%s]", this.getOpNote()));
        buff.append(String.format("\nkeyword [%s]", this.getKeyword()));
        buff.append(String.format("\npddg [%s]", this.getPddg()));
        buff.append(String.format(
                "\nstreamStateIndicator raw value [%s]; enum value [%s]",
                this.getStreamStateIndicator().getRawStreamStateIndicatorValue(),
                this.getStreamStateIndicator().name()));
        return buff.toString();
    }
}
