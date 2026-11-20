package backend.services;

import java.util.regex.Pattern;

import backend.model.User;
import backend.repository.UserRepo;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service 
public class UserService 
{
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
            "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");

    private final BCryptPasswordEncoder passwordEncoder; // spring now passes the @bean method into this constructor
    private final UserRepo userRepo;    
    

    public UserService(UserRepo userRepo, BCryptPasswordEncoder passwordEncoder)
    {
        this.userRepo=userRepo;
        this.passwordEncoder=passwordEncoder;
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
        if(user.getHashPassword()==null || user.getHashPassword().length()<8)
        {
            throw new IllegalArgumentException("The password must have atleast 8 symbols");
        }
        user.setHashPassword(passwordEncoder.encode(user.getHashPassword()));
        return userRepo.save(user);
    }
}
