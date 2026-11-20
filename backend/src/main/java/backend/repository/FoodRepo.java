package backend.repository;

import backend.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

//interface that saves finds and deletes entities, talks to postgreSQL
public interface FoodRepo extends JpaRepository<Food, Integer>{
    
}
