package lab5.back.repositories;

import lab5.back.entity.Watch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WatchRepository extends JpaRepository<Watch, Integer> {

}