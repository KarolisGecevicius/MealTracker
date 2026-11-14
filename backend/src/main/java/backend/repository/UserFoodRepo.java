package backend.repository;

import backend.model.UserFood;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserFoodRepo extends JpaRepository<UserFood, Integer>{
    
}
