package backend.controller;

import backend.model.UserFood;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import backend.services.UserFoodService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController 
@RequestMapping("/userMeals")
public class UserFoodController {
    private final UserFoodService service; // final doesnt allow swapping

    public UserFoodController(UserFoodService service)
    {
        this.service=service;
    }

    @GetMapping // this method answers GET
    public List<UserFood> getTodaysUserFood(@RequestParam int userId , @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date)
    //@RequestParam means take id from the url after ?, same for date
    //DateTimeFormat says the format the date is written in so spring knows how to read it
    {
        return service.getMealsForDay(userId, date);
    }
    

    @PostMapping //this method answers POST
    public UserFood addUserFood(@RequestBody UserFood food) 
    //@reguestbody mean the data is in the body of the request converts json into userfood
    {
        return service.addMeal(food);
    }

    @DeleteMapping("/{id}") // this method answers DELELTE
    public void deleteUserFood(@PathVariable int id, @RequestParam int userId )
    //Pathvariable takes the number from the URL path
    {
        service.deleteMeal(id, userId);
    }

}
