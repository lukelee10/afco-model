package net.acesinc.afco.model.repo;

import java.util.Optional;
import net.acesinc.afco.model.special.signal.SpecialSignalFolder;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "special-signal-folder", path = "special-signal-folder")
public interface SpecialSignalFolderRepository extends MongoRepository<SpecialSignalFolder, String> {

    Optional<SpecialSignalFolder> findByFolder(String folder);
}
