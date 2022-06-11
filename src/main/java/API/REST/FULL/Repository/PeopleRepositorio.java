package API.REST.FULL.Repository;

import API.REST.FULL.Models.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepositorio extends JpaRepository<People,Integer> {
}
