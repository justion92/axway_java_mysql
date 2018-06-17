package oprea.constantin.repository;

import oprea.constantin.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface StudentJpaRepository extends JpaRepository<Student,Integer> {

    public Student findStudentById(int id);
}
