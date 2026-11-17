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

    //repository is needed to reach the database
    public UserFoodService(UserFoodRepo userFoodRepo) 
    {
        this.userFoodRepo = userFoodRepo;
    }

    public List<UserFood> getMealsForDay( int userId,  LocalDate date)
    {
        return userFoodRepo.findByUserIdAndDate(userId, date);
    }

    @Transactional // runs the method as a whole unit if smth fails undo everything
    public UserFood addMeal(UserFood meal)
    {
        if(meal.getQuantity() <= 0) // checks if quantity is not 0
        {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        if(meal.getDate()==null) //check if a date is sent
        {
            meal.setDate(LocalDate.now());
        }
        return userFoodRepo.save(meal);
    }    

    @Transactional 
    public void deleteMeal(int id, int userId)
    {
        UserFood meal = userFoodRepo.findById(id).orElseThrow(() -> new RuntimeException("Meal not found"));
        if(meal.getUserId()!=userId) // check if the meal belongs to the correct user
        {
            throw new RuntimeException("Wrong meal");
        }
        userFoodRepo.delete(meal);
    }


}