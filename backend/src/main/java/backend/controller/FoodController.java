package backend.controller;

import backend.model.Food;
import backend.repository.FoodRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/foods")
public class FoodController {
    private final FoodRepo foodrepo;

    public FoodController(FoodRepo foodrepo)
    {
        this.foodrepo=foodrepo;
    }

    @GetMapping
    public List<Food> getFoods()
    {
        return foodrepo.findAll();
    }
    
}
