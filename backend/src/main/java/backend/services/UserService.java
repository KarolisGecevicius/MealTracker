package backend.services;

import java.util.regex.Pattern;

import backend.model.User;
import backend.repository.UserRepo;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

@Service 
public class UserService 
{
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
            "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");

    private final UserRepo userRepo;    

    public UserService(UserRepo userRepo)
    {
        this.userRepo=userRepo;
    }

    public static boolean isValid(String email) 
    {  
        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }

    @Transactional 
    public User add(User user)
    {
        if(!isValid(user.getEmail())) // checks if the email format is correct using regex
        {
            throw new IllegalArgumentException("Wrong email format");
        }
        if(userRepo.existsByEmail(user.getEmail()))
        {
            throw new RuntimeException("The email has already been registered");
        }
        return userRepo.save(user);
    }
}
