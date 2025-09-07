/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.acesinc.afco.model.repo;

import net.acesinc.afco.model.file.AudioDataFile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * This class really only exists to allow people to POST audio files which probably won't happen in production. But if you don't
 * post to this endpoint and use the "file" endpoint from the DataFileRepo, it will ignore the extra fields.
 * @author andrewserff
 */
@RepositoryRestResource(collectionResourceRel = "file-audio", path = "file-audio")
public interface AudioDataFileRepo extends MongoRepository<AudioDataFile, String> {}
