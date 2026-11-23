package backend.controller;

import backend.model.Food;
import backend.repository.FoodRepo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// controllers is the connection to the frontend, defines the urls, receives http requests
// passess the data to the service and returns as an http response
// only the controller is responsible for commmunication with the frontend
@RestController
@RequestMapping("/foods")
public class FoodController {
    private final FoodRepo foodrepo;

    public FoodController(FoodRepo foodrepo)
    {
        this.foodrepo=foodrepo;
    }

    @
    GetMapping
    public List<Food> getFoods()
    {
        return foodrepo.findAll();
    }
}
