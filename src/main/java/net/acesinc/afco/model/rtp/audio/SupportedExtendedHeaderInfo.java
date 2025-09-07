package net.acesinc.afco.model.rtp.audio;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class SupportedExtendedHeaderInfo implements ExtendedHeaderInfo {
    private static final Map<Integer, Integer> supportedProfilesBlockSizeLookup;
    private static final Map<Integer, Integer> supportedProfilesLengthLookup;

    /*
     * Default supported profile constant.  Used for when an unknown RTP AGS_EXT header is sent.
     *
     * This value NEEDS to be changed with the latest supported AGS_EXT_HEADER profile
     */
    public static final int DEFAULT_SUPPORTED_PROFILE = 19511;

    static {
        supportedProfilesBlockSizeLookup = new HashMap<>();
        supportedProfilesBlockSizeLookup.put(
                ExtendedHeaderInfo.AGS_EXTENDED_HEADER_PROFILE_19507_PREAMBLE_VALUE,
                ExtendedHeaderInfo.ACTUAL_AGS_EXT_HEADER_32BIT_BLOCK_LENGTH_PROFILE_19507);
        supportedProfilesBlockSizeLookup.put(
                ExtendedHeaderInfo.AGS_EXTENDED_HEADER_PROFILE_19509_PREAMBLE_VALUE,
                ExtendedHeaderInfo.ACTUAL_AGS_EXT_HEADER_32BIT_BLOCK_LENGTH_PROFILE_19509);
        supportedProfilesBlockSizeLookup.put(
                ExtendedHeaderInfo.AGS_EXTENDED_HEADER_PROFILE_19510_PREAMBLE_VALUE,
                ExtendedHeaderInfo.ACTUAL_AGS_EXT_HEADER_32BIT_BLOCK_LENGTH_PROFILE_19510);
        supportedProfilesBlockSizeLookup.put(
                ExtendedHeaderInfo.AGS_EXTENDED_HEADER_PROFILE_19511_PREAMBLE_VALUE,
                ExtendedHeaderInfo.ACTUAL_AGS_EXT_HEADER_32BIT_BLOCK_LENGTH_PROFILE_19511);
        supportedProfilesLengthLookup = new HashMap<>();
        supportedProfilesLengthLookup.put(
                ExtendedHeaderInfo.AGS_EXTENDED_HEADER_PROFILE_19507_PREAMBLE_VALUE,
                ExtendedHeaderInfo.ACTUAL_AGS_EXT_HEADER_PROFILE_19507_LENGTH_IN_BYTES);
        supportedProfilesLengthLookup.put(
                ExtendedHeaderInfo.AGS_EXTENDED_HEADER_PROFILE_19509_PREAMBLE_VALUE,
                ExtendedHeaderInfo.ACTUAL_AGS_EXT_HEADER_PROFILE_19509_LENGTH_IN_BYTES);
        supportedProfilesLengthLookup.put(
                ExtendedHeaderInfo.AGS_EXTENDED_HEADER_PROFILE_19510_PREAMBLE_VALUE,
                ExtendedHeaderInfo.ACTUAL_AGS_EXT_HEADER_PROFILE_19510_LENGTH_IN_BYTES);
        supportedProfilesLengthLookup.put(
                ExtendedHeaderInfo.AGS_EXTENDED_HEADER_PROFILE_19511_PREAMBLE_VALUE,
                ExtendedHeaderInfo.ACTUAL_AGS_EXT_HEADER_PROFILE_19511_LENGTH_IN_BYTES);
    }

    public static void addSupport(Integer profile, Integer blockLength, Integer lengthInBytes) {
        supportedProfilesBlockSizeLookup.put(profile, blockLength);
        supportedProfilesLengthLookup.put(profile, lengthInBytes);
    }

    public static Boolean isSupported(Integer profile) {
        return supportedProfilesBlockSizeLookup.containsKey(profile);
    }

    public static Set<Integer> getSupportedProfiles() {
        return supportedProfilesBlockSizeLookup.keySet();
    }

    public static Integer getSuportedProfile32BitBlockSize(Integer profile) {
        return supportedProfilesBlockSizeLookup.get(profile);
    }

    public static Integer getSupportedProfileBytesLength(Integer profile) {
        return supportedProfilesLengthLookup.get(profile);
    }

    public static ExtendedHeaderInfo toExtendedHeaderFromBytes(int profile, byte[] rawExtendedHeader) {
        switch (profile) {
            case ExtendedHeaderInfo.AGS_EXTENDED_HEADER_PROFILE_19507_PREAMBLE_VALUE: {
                return ExtendedHeaderInfo19507.toExtendedHeaderFromBytes(rawExtendedHeader);
            }
            case ExtendedHeaderInfo.AGS_EXTENDED_HEADER_PROFILE_19509_PREAMBLE_VALUE: {
                return ExtendedHeaderInfo19509.toExtendedHeaderFromBytes(rawExtendedHeader);
            }
            case ExtendedHeaderInfo.AGS_EXTENDED_HEADER_PROFILE_19510_PREAMBLE_VALUE:
                return ExtendedHeaderInfo19510.toExtendedHeaderFromBytes(rawExtendedHeader);

            case ExtendedHeaderInfo.AGS_EXTENDED_HEADER_PROFILE_19511_PREAMBLE_VALUE:
                return ExtendedHeaderInfo19511.toExtendedHeaderFromBytes(rawExtendedHeader);

            default: {
                return ExtendedHeaderInfo19511.toExtendedHeaderFromBytes(rawExtendedHeader, true)
                        .unsupportedProfileOverride(profile);
            }
        }
    }

    @Override
    public int getActualAgsExtHeader32BitBlockLength() {
        return SupportedExtendedHeaderInfo.getSuportedProfile32BitBlockSize(this.getAgsExtHeaderPreambleProfileValue());
    }

    @Override
    public int getActualAgsExtHeaderLengthInBytes() {
        return SupportedExtendedHeaderInfo.getSupportedProfileBytesLength(this.getAgsExtHeaderPreambleProfileValue());
    }

    /**
     *
     * @param b - a byte.
     * @return Short - A signed byte converted to an unsigned byte.  It is returned as a Short, since Java doesn't support
     * unsigned data types this is the next best data type in this case.
     */
    public static Short signedByteToShort(byte b) {
        return (short) (b & 0xFF);
    }

    /**
     * Disclaimer:  This is a convenience method from the RTP lib we are using from StaticProcs.java.  As we do NOT want a dependency on the RTP Lib to be able to compile afco-model, this method has been copied here as e now need this.
     * Converts an unsigned 32 bit integer, stored in a long, into an array of
     * bytes.
     *
     * @param j a long
     * @return byte[4] representing the unsigned integer, most significant bit
     * first.
     */
    public static byte[] uIntLongToByteWord(long j) {
        int i = (int) j;
        byte[] byteWord = new byte[4];
        byteWord[0] = (byte) ((i >>> 24) & 0x000000FF);
        byteWord[1] = (byte) ((i >> 16) & 0x000000FF);
        byteWord[2] = (byte) ((i >> 8) & 0x000000FF);
        byteWord[3] = (byte) (i & 0x00FF);
        return byteWord;
    }

    /**
     * Disclaimer:  This is a convenience method from the RTP lib we are using from StaticProcs.java.  As we do NOT want a dependency on the RTP Lib to be able to compile afco-model, this method has been copied here as e now need this.
     * Combines four bytes (most significant bit first) into a 32 bit unsigned
     * integer.
     *
     * @param bytes 4 bytes to be converted to 32-bit unsigned integer
     * @param index of most significant byte
     * @return long with the 32 bit unsigned integer
     */
    public static long bytesToUIntLong(byte[] bytes, int index) {
        long accum = 0;
        int i = 3;
        for (int shiftBy = 0; shiftBy < 32; shiftBy += 8) {
            accum |= ((long) (bytes[index + i] & 0xff)) << shiftBy;
            i--;
        }
        return accum;
    }
}
