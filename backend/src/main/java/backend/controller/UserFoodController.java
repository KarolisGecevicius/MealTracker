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
@CrossOrigin(origins = "http://localhost:5173")
public class UserFoodController {
    private final UserFoodService service;

    public UserFoodController(UserFoodService service)
    {
        this.service=service;
    }

    @GetMapping
    public List<UserFood> getTodaysUserFood(@RequestParam int userId, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date)
    {
        return service.getMealsForDay(userId, date);
    }
    

    @PostMapping //spring knows this answers to post /usermeals
    public UserFood addUserFood(@RequestBody UserFood food) //@reguestbody so that spring converts the json react sends
    {
        return service.addMeal(food);
    }

    @DeleteMapping("/{id}")
    public void deleteUserFood(@PathVariable int id, @RequestParam int userId )
    {
        service.deleteMeal(id, userId);
    }

}
