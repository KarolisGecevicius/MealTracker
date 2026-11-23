package backend.repository;

import backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer>{
    boolean existsByEmail(String email);
    User findByEmail(String email); // finds user by the email
}