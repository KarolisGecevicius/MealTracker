package backend.repository;

import backend.model.UserFood;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface UserFoodRepo extends JpaRepository<UserFood, Integer>
{
    List<UserFood> findByUserIdAndDate(int userId, LocalDate date);
}
