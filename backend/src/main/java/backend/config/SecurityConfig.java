package backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration // notifies that this class contains setup instruction and tells spring to read it when the app starts
public class SecurityConfig 
{
    @Bean // runs this method once, stores the return and hands the same return to any class that needs it 
    public BCryptPasswordEncoder passwordEncoder()
    {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }
}
