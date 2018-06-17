package oprea.constantin.repository;

import oprea.constantin.entities.Curs;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CursJpaRepository extends JpaRepository<Curs,Integer> {

    public Curs findCursById(int id);
}
