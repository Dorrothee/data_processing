package back.lab8.repositories;

import back.lab8.entity.Watch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource(collectionResourceRel = "watches", path = "watches")
public interface WatchRepository extends JpaRepository<Watch, Integer> {
}
