package backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="meal_nutrition")
public class Food 
{
    @Id
    private int id;

    private String name;
    private double calories;
    private double carbs;
    private double fat;
    private double protein;

}
