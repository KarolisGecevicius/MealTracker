package backend.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import backend.model.User;
import backend.model.UserFood;
import backend.repository.UserFoodRepo;
import backend.repository.UserRepo;
import org.springframework.transaction.annotation.Transactional;


@Service // validations checks and calculations, uses repository to read and write data
public class UserFoodService
{
    private final UserFoodRepo userFoodRepo;
    private final UserRepo userRepo;

    //repository is needed to reach the database
    public UserFoodService(UserFoodRepo userFoodRepo, UserRepo userRepo) 
    {
        this.userFoodRepo = userFoodRepo;
        this.userRepo = userRepo;
    }

    private User getUserByEmail(String email)
    {
        User user = userRepo.findByEmail(email);
        if(user==null)
        {
            throw new IllegalArgumentException("No user with such email");
        }
        return user;
    }

    public List<UserFood> getMealsForDay( LocalDate date, String email)
    {
        User user = getUserByEmail(email);
        return userFoodRepo.findByUserIdAndDate(user.getId(), date);
    }

    @Transactional // runs the method as a whole unit if smth fails undo everything
    public UserFood addMeal(String email, UserFood meal)
    {
        User user = getUserByEmail(email);
        if(meal.getQuantity() <= 0) // checks if quantity is not 0
        {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        if(meal.getDate()==null) //check if a date is sent
        {
            meal.setDate(LocalDate.now());
        }
        meal.setUserId(user.getId());
        return userFoodRepo.save(meal);
    }    

    @Transactional 
    public void deleteMeal(int id, String email)
    {
        User user = getUserByEmail(email);
        UserFood meal = userFoodRepo.findById(id).orElseThrow(() -> new RuntimeException("Meal not found"));
        if(meal.getUserId()!=user.getId()) // check if the meal belongs to the correct user
        {
            throw new RuntimeException("Wrong meal");
        }
        userFoodRepo.delete(meal);
    }


}