/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.afco.model.repo;

import java.util.List;
import net.acesinc.afco.model.report.Report;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 *
 * Creation Example:
 * curl -k --cert-type pkcs12 --cert ~/Documents/dev/certs/user-certs/alluser.p12:password -H "Content-Type: application/json" -X POST -d '{"mappingId":"ABC_123","creationDate":"2016-06-01T13:22:33.000Z","lastUpdated":"2016-06-01T13:22:33.000Z", "remoteId":"test","remoteReport": {"topic":"TOPIC2", "id":"test"}, "submittedByUser":"abserff","classification":{ "levels" : [ "UNCLASSIFIED" ], "compartments" : [ ], "releasabilities" : [ "FOUO" ] }}' https://localhost:8444/rest/report
 *
 * Query Examples:
 * Get Reports associated with a MappingId
 * https://localhost:8444/rest/report/search/findByMappingId?mappingId=ABC_123
 *
 * Get Reports associated with a topic (or some other field in the report)
 * https://localhost:8444/rest/report/search/findByFieldAndValue?fieldName=remoteReport.topic&fieldValue=TOPIC2
 *
 *
 * @author andrewserff
 */
@RepositoryRestResource(collectionResourceRel = "report", path = "report")
public interface ReportRepository extends MongoRepository<Report, String> {
    public List<Report> findByMappingId(@Param("mappingId") String mappingId);

    public Report findByRemoteId(@Param("remoteId") String remoteId);

    @Query("{ ?0 : ?1 }")
    public List<Report> findByFieldAndValue(
            @Param("fieldName") String fieldName, @Param("fieldValue") String fieldValue);
}
