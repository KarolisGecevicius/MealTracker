package backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="registered_users")
public class User 
{
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true) // only unique emails
    private String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // lets the password come in from json but never out
    private String hashPassword;

    public User()
    {

    }

    public int getId()
    {
        return id;
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
