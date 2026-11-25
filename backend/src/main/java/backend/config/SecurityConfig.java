package backend.config;

import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;

@Configuration // notifies that this class contains setup instruction and tells 
// spring to read it when the app starts
@EnableWebSecurity // notifies that this class contains web security and tells spring to use it
public class SecurityConfig 
{
    @Bean // runs this method once, stores the return and hands the same return to any class 
    //that needs it, the object created by this method should be managed by spring
    public BCryptPasswordEncoder passwordEncoder() 
    {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }

    @Bean 
    //SecurityFilterChain defines the security rules for incoming http requests
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
    {
        HttpStatusReturningLogoutSuccessHandler handler = new HttpStatusReturningLogoutSuccessHandler();
        http // starts configuring http security settings
            .cors(customizer -> customizer // turns on cors in spring security
                .configurationSource(corsConfigurationSource()) // tells cors to get rules from 
                //the corsConfigurationSource method
            )
            .logout(customizer -> customizer
                .logoutSuccessHandler(handler)
                .deleteCookies("JSESSIONID")        
            )
            .csrf(csrf -> csrf.disable()) // temporary for login to get working REMOVE LATER!!!
            .authorizeHttpRequests(auth -> auth // define which http requests users are allowed to access
                .requestMatchers("/auth/login", "/register").permitAll() // allows everyone to access this endpoint
                .anyRequest().authenticated() // for any other endpoints user is required to be authenticated
            );
            
        return http.build(); // build takes all the configurations and creates a new securityFilterChain object
    }

    @Bean 
    //UrlBasedCorsConfiguration is a container that holds CORS rules and link them to URL paths 
    public UrlBasedCorsConfigurationSource corsConfigurationSource()
    {
            CorsConfiguration config = new CorsConfiguration(); // creates a blank rule book
            config.setAllowedOrigins(Arrays.asList("http://localhost:5173")); // sets which 
            // frontend is allowed to communicate with my backend
            config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS")); // sets which 
            // methods can be used by http
            config.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization")); // content-type 
            // tells what kind of data is in the body, authorization carries login info, like a token
            // allowed in order to pass a preflight check from the browser
            config.setAllowCredentials(true); // allows my frontend to send cookies or login info 
            // to my backend when they are on different origins
            UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource(); // creates 
            // an empty container that will hold config(the rulebook)
            source.registerCorsConfiguration("/**", config); // applies the rulebook to every URL
            // /** means every URL
            return source;
    }
}
