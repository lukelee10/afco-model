package net.acesinc.afco.model.repo;

import java.util.Date;
import java.util.List;
import java.util.Set;
import net.acesinc.afco.model.subject.SignalSubject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "signal-event", path = "signal-event")
public interface SignalSubjectRepository extends MongoRepository<SignalSubject, String> {
    public SignalSubject findByMappingId(String mappingId);

    @Query(value = "{ 'lastUpdated' : {$gte : ?0, $lte: ?1 }}", fields = "{ 'mappingId' : 1}")
    public Page<SignalSubject> findbylastUpdatedBetween(Date from, Date to, Pageable pageable);

    @Query(value = "{ 'lastUpdated' : { $lte: ?0 }}", fields = "{ 'mappingId' : 1}")
    public Page<SignalSubject> findbylastUpdatedBefore(Date to, Pageable pageable);

    @Query("{ 'missionId' : {$in : ?0}}")
    public List<SignalSubject> findByMissionIds(@Param("missionId") Set<String> missionId);

    @Query(value = "{ missionId :?0 , startTime: { $ne: null } }", sort = "{ startTime: 1 }")
    public List<SignalSubject> findByMissionIdOrderByStartTime(String missionId);

    @Query(value = "{ missionId :?0 , stopTime: { $ne: null } }", sort = "{ stopTime: 1 }")
    public List<SignalSubject> findByMissionIdOrderByStopTime(String missionId);

    @Query(value = "{ 'startTime' : {$gte : ?1, $lte: ?2 },'missionId' : {$in : ?0}}")
    public List<SignalSubject> findByMissionIdAndStartTimeBetween(Set<String> missionId, Date from, Date to);

    // Search for a signal between min and max rf
    @Query(
            value = "{'characterization.radioFreqSummary.rfMin' : {$gte : ?0},"
                    + " 'characterization.radioFreqSummary.rfMax' : {$lte : ?1} }")
    public List<SignalSubject>
            findByCharacterizationRadioFreqSummaryRfMinGreaterThanEqualAndCharacterizationRadioFreqSummaryRfMaxLessThanEqual(
                    Double minRf, Double maxRf);

    @Query(
            value = "{'characterization.radioFreqSummary.rfMin' : {$gte : ?0},"
                    + " 'characterization.radioFreqSummary.rfMax' : {$lte : ?1} } },"
                    + " 'startTime' : {$gte : ?2},"
                    + " 'stopTime' : {$lte : ?3} }")
    public List<SignalSubject>
            findByCharacterizationRadioFreqSummaryRfMinGreaterThanEqualAndCharacterizationRadioFreqSummaryRfMaxLessThanEqualAndStartTimeGreaterThanEqualAndStopTimeLessThanEqual(
                    Double minRf, Double maxRf, Date startTime, Date endTime);

    @Query(value = "{'idents' : {$elemMatch : {'ident' : ?0} }, 'startTime' : {$gte : ?1, $lte : ?2}}")
    public List<SignalSubject> findByIdentsIdent(String elnot, Date startTime, Date stopTime);
}
