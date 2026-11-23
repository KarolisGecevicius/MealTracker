package backend.services;

import backend.model.User;
import backend.repository.UserRepo;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service 
public class AuthenticationService 
{
    private final BCryptPasswordEncoder passwordEncoder; // spring now passes the @bean method into this constructor
    private final UserRepo userRepo;    
    public AuthenticationService(UserRepo userRepo, BCryptPasswordEncoder passwordEncoder)
    {
        this.userRepo=userRepo;
        this.passwordEncoder=passwordEncoder;
    }
    //finds user by email and checks password
    @Transactional 
    public User authenticate(User user)
    {
        User curr = userRepo.findByEmail(user.getEmail());
        if(curr==null)
        {
            throw new IllegalArgumentException("Wrong email or password");
        }
        if(!passwordEncoder.matches(user.getHashPassword(), curr.getHashPassword()))
        {
            throw new IllegalArgumentException("Wrong email or password");
        }

        return curr;
    }    
}
