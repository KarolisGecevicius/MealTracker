package backend.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="userMeals")
public class UserFood 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //automatically generates id
    private int id;

    private int userId;
    private String name;
    private double calories;
    private double carbs;
    private double fat;
    private double protein;
    private LocalDate date;
    private double quantity;
    private String category;

    public UserFood()
    {

    }

    public int getUserID()
    {
        return userId;
    }

    public void setUserID(int userId)
    {
        this.userId=userId;
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

    public LocalDate getDate()
    {
        return date;
    }

    public void setDate(LocalDate date)
    {
        this.date=date;
    }

    public double getQuantity()
    {
        return quantity;
    }

    public void setQuantity(double quantity)
    {
        this.quantity=quantity;
    }

    public String getCategory()
    {
        return category;
    }

    public void setCategory(String category)
    {
        this.category=category;
    }
}

