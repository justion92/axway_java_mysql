package oprea.constantin.repository;

import oprea.constantin.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User,Integer> {
    public User findUserByEmail(String email);
}
