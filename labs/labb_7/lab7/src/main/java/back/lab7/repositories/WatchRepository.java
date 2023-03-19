package back.lab7.repositories;

import back.lab7.entity.Watch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource(path="watches")
public interface WatchRepository extends JpaRepository<Watch, Integer> {
}
