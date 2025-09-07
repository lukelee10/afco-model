/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.afco.model.repo;

import java.util.ArrayList;
import java.util.List;
import net.acesinc.afco.model.distribution.Distributable;
import net.acesinc.afco.model.file.AudioDataFile;
import net.acesinc.afco.model.file.DataFile;
import net.acesinc.afco.model.file.ElintDataFile;
import net.acesinc.afco.model.file.MultipleMissionDataFile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author andrewserff
 */
@RepositoryRestResource(collectionResourceRel = "files", itemResourceRel = "file", path = "file")
public interface DataFileRepository extends MongoRepository<DataFile, String> {
    public DataFile getByFileName(@Param("fileName") String fileName);

    public DataFile findByFileNameAndMappingId(
            @Param("fileName") String fileName, @Param("mappingId") String mappingId);

    public List<DataFile> getByMappingId(@Param("mappingId") String mappingId);

    public List<DataFile> getByMappingIdIn(@Param("mappingIds") List<String> mappingIds);

    @Query("{ 'id' : ?0, 'dataType': 'SPECIAL_SIGNAL' }")
    public DataFile getSpecialSignalFileById(@Param("id") String id);

    public List<DataFile> getByMappingIdAndDataType(
            @Param("mappingId") String mappingId, @Param("dataType") String dataType);

    // let's make some helper methods that force the datatype so the user doesn't have to know.
    @Query("{ 'mappingId' : ?0, 'dataType': 'DWELL' }")
    public List<ElintDataFile> findElintDwellByMappingId(@Param("mappingId") String mappingId);

    @Query("{ 'mappingId' : ?0, 'dataType': 'POD' }")
    public List<ElintDataFile> findElintPodByMappingId(@Param("mappingId") String mappingId);

    @Query("{ 'mappingId' : ?0, 'dataType': 'PDW' }")
    public List<ElintDataFile> findElintPdwByMappingId(@Param("mappingId") String mappingId);

    @Query("{ 'mappingId' : ?0, 'dataType': 'PDW-CONVOLVED' }")
    public List<ElintDataFile> findElintPdwConvolvedByMappingId(
            @Param("mappingId") String mappingId, Pageable pageable);

    @Query("{ 'mappingId' : ?0, 'dataType': 'AUDIO' }")
    public List<AudioDataFile> findAudioByMappingId(@Param("mappingId") String mappingId);

    @Query("{ 'mappingId' : ?0, 'dataType': 'DATA' }")
    public List<AudioDataFile> findDataByMappingId(@Param("mappingId") String mappingId);

    @Query("{ 'id' : { $in: ?0 }, 'dataType': { $in: ['DATA', 'SPECIAL_SIGNAL'] } }")
    public List<DataFile> findDataFilesByDataFileIdIn(@Param("dataFileId") List<String> dataFileId);

    @Query("{ 'fileName': ?0, 'mappingId': ?1 }")
    public List<AudioDataFile> findDataFilesByFileNameMappingId(
            @Param("fileName") String fileName, @Param("mappingId") String mappingId);

    @Query("{ 'mappingId' : ?0, 'dataType': 'TRACAL' }")
    public List<DataFile> findTracalByMappingId(@Param("mappingId") String mappingId);

    @Query("{ 'mappingId' : ?0, 'dataType': 'CUT-SERVICE-TXT' }")
    public List<DataFile> findCutServiceTxtByMappingId(@Param("mappingId") String mappingId);

    @Query("{ 'mappingId' : {$in : ?0}, 'dataType': 'DWELL' }")
    public List<ElintDataFile> findElintByMappingIds(@Param("mappingId") List<String> mappingId);

    @Query("{ 'id' : ?0, 'dataType': 'AUDIO' }")
    public AudioDataFile getAudioById(@Param("id") String id);

    @Query("{ 'mappingId' : ?0, 'dataType': 'BINARY-DAT' }")
    public List<DataFile> findBinaryDatByMappingId(@Param("mappingId") String mappingId);

    @Query("{ 'mappingId' : ?0, 'dataType': 'HDR' }")
    public List<DataFile> findHdrByMappingId(@Param("mappingId") String mappingId);

    @Query("{ 'mappingId' : ?0, 'dataType': 'CSV' }")
    public List<DataFile> findCsvByMappingId(@Param("mappingId") String mappingId);

    @Query("{ 'mappingId' : ?0, 'dataType': 'KML' }")
    public List<DataFile> findKmlByMappingId(@Param("mappingId") String mappingId);

    @Query("{ 'mappingId' : ?0, 'dataType': 'PRED' }")
    public List<DataFile> findPredTarGzByMappingId(@Param("mappingId") String mappingId);

    @Query("{ 'mappingId' : ?0, 'dataType': 'PBIT' }")
    public List<DataFile> findPbitTarGzByMappingId(@Param("mappingId") String mappingId);

    @Query("{ 'mappingId' : ?0, 'dataType': 'ABIT-BINARY' }")
    public List<DataFile> findAbitBinaryByMappingId(@Param("mappingId") String mappingId);

    @Query("{ 'mappingId' : ?0, 'dataType': 'CEGS-BINARY' }")
    public List<DataFile> findCegsBinaryByMappingId(@Param("mappingId") String mappingId);

    @Query("{ 'mappingId' : ?0, 'dataType': 'SDS-METRIC-LOG' }")
    public List<DataFile> findSdsMetricLogByMappingId(@Param("mappingId") String mappingId);

    @Query("{'mappingId' : ?0, 'dataType': 'ECMS-ZIP'}")
    public List<MultipleMissionDataFile> findEcmsZipByMappingId(@Param("mappingId") String mappingId);

    @Query("{'missionId' : ?0, 'dataType': 'ECMS-ZIP'}")
    public List<MultipleMissionDataFile> findEcmsZipByMissionIdIn(@Param("missionIds") ArrayList<String> missionIds);

    @Query("{ 'absolutePath' : { $regex: ?0 } }")
    public List<DataFile> findAbsolutePathRegex(@Param("absolutePathRegex") String absolutePathRegex);

    @Query("{ 'mappingId' : { $regex: ?1 }, 'dataType': 'PRED' }")
    public List<DataFile> findPredTarGzAndMappingIdRegex(@Param("mappingIdRegex") String mappingIdRegex);

    /**
     * Due to some adjustments in the DataFileController, this is one of the two endpoints that a Mission focused page should call?
     *
     * @param mappingIdRegex
     * @return
     */
    @Query("{ 'mappingId' : { $regex: ?0 } }")
    public List<DataFile> findByRegexMappingId(@Param("mappingIdRegex") String mappingIdRegex);

    /**
     * Due to some adjustments in the DataFileController, this is one of the two endpoints that a Mission focused page should call?
     *
     * @param mappingIdRegex
     * @return
     */
    @Query("{ 'mappingId' : { $regex: ?0 } }")
    public Page<DataFile> findMappingIdRegex(@Param("mappingIdRegex") String mappingIdRegex, Pageable pageable);

    public Page<DataFile> findByMappingIdIn(@Param("mappingId") List<String> mappingId, Pageable pageable);

    @Query("{ 'mappingId' : ?0, 'dataType': 'SPECTROGRAM' }")
    public List<DataFile> findSpectrogramByMappingId(@Param("mappingId") String mappingId);

    @Query("{ 'mappingId' : ?0, 'dataType': 'SCRIPT_RESULT' }")
    public List<DataFile> findScriptResultByMappingId(@Param("mappingId") String mappingId);

    @Query("{ 'fileName' : ?0, 'dataType': 'SCRIPT_RESULT' }")
    public DataFile findScriptResultByFileName(@Param("fileName") String fileName);

    @Query("{ 'mappingId' : ?0, 'dataType': 'DWELL' }")
    public ElintDataFile findDwellByMappingId(@Param("mappingId") String mappingId);

    public Distributable findDistributableById(String id);

    public Long countByIdIn(@Param("id") List<String> id);
}
