package backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="meal_nutrition")
public class Food 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //automatically generates id
    private int id;
    private String name;
    private double calories;
    private double carbs;
    private double fat;
    private double protein;

    public Food()
    {

    }

    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name=name;
    }

    public double getCalories()
    {
        return calories;
    }
    
    public void setCalories(double calories)
    {
        this.calories=calories;
    }

    public double getCarbs()
    {
        return carbs;
    }
    
    public void setCarbs(double carbs)
    {
        this.carbs=carbs;
    }
    
    public double getFat()
    {
        return fat;
    }
    
    public void setFat(double fat)
    {
        this.fat=fat;
    }

    public double getProtein()
    {
        return protein;
    }
    
    public void setProtein(double protein)
    {
        this.protein=protein;
    }
}

