package backend.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import backend.model.UserFood;
import backend.repository.UserFoodRepo;
import org.springframework.transaction.annotation.Transactional;


@Service 
public class UserFoodService
{
    private final UserFoodRepo userFoodRepo;

    public UserFoodService(UserFoodRepo userFoodRepo) 
    {
        this.userFoodRepo = userFoodRepo;
    }

    public List<UserFood> getMealsForDay( int userId,  LocalDate date)
    {
        return userFoodRepo.findByUserIdAndDate(userId, date);
    }

    @Transactional 
    public UserFood addMeal(UserFood meal)
    {
        if(meal.getQuantity() <= 0)
        {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        if(meal.getDate()==null)
        {
            meal.setDate(LocalDate.now());
        }
        return userFoodRepo.save(meal);
    }    

    @Transactional 
    public void deleteMeal(int id, int userId)
    {
        UserFood meal = userFoodRepo.findById(id).orElseThrow(() -> new RuntimeException("Meal not found"));
        if(meal.getUserId()!=userId)
        {
            throw new RuntimeException("Wrong meal");
        }
        userFoodRepo.delete(meal);
    }


}