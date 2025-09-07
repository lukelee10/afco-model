/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.afco.model.repo;

import java.util.List;
import net.acesinc.afco.model.subject.Subject;
import net.acesinc.afco.model.subject.SubjectType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 *
 * @author andrewserff
 */
@RepositoryRestResource(collectionResourceRel = "subject", path = "subject")
public interface SubjectRepository extends MongoRepository<Subject, String> {
    public Subject findByMappingId(String mappingId);

    public List<Subject> findByType(SubjectType type);
}
