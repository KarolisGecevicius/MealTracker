package backend.model;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="registeredUsers")
public class Users 
{
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String hashPassword;

    public Users()
    {

    }

    public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email=email;
    }

    public String getHashPassword()
    {
        return hashPassword;
    }
    public void setHashPassword(String hashPassword)
    {
        this.hashPassword=hashPassword;
    }

}
