package backend.controller;

import backend.model.UserFood;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import backend.services.UserFoodService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.security.core.Authentication;

@RestController 
@RequestMapping("/userMeals")
public class UserFoodController {
    private final UserFoodService service; // final doesnt allow swapping

    public UserFoodController(UserFoodService service)
    {
        this.service=service;
    }

    @GetMapping // this method answers GET
    public List<UserFood> getTodaysUserFood(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, Authentication authentication)
    //@RequestParam means take date from the url after ?
    //DateTimeFormat says the format the date is written in so spring knows how to read it
    // email is taken from the service through authenticate, not from the URL
    {
        String email = authentication.getName();
        return service.getMealsForDay(date, email);
    }
    

    @PostMapping //this method answers POST
    public UserFood addUserFood(@RequestBody UserFood food, Authentication authentication) 
    //@reguestbody mean the data is in the body of the request converts json into userfood
    {
        String email = authentication.getName();
        return service.addMeal(email, food);
    }

    @DeleteMapping("/{id}") // this method answers DELELTE
    public void deleteUserFood(@PathVariable int id, Authentication authentication)
    //Pathvariable takes the number from the URL path
    {
        String email = authentication.getName();
        service.deleteMeal(id, email);
    }

}
