package backend.controller;

import java.util.List;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import backend.model.User;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletRequest;

import backend.services.AuthenticationService;

@RestController 
@RequestMapping("/auth")
public class AuthenticationController      
{
    private final AuthenticationService service;

    public AuthenticationController(AuthenticationService service)
    {
        this.service=service;
    }

    @PostMapping(path="/login")
    //@RequestBody tells spring to take the body of the incoming HTTP request
    //and convert it into java object
    public User authenticateUser(@RequestBody User user, HttpServletRequest request, HttpServletResponse response)
    //HttpServletRequest request - incoming request, HttpServletResponse response - the outgoing response
    {
        User authenticatedUser = service.authenticate(user); // authenticates the user
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(authenticatedUser.getEmail(), null, List.of());
        // creates a verifieds users note, credentials is null because the password ir verfified by authenticate
        // authorities is empty as well because it checks if the user is logged in and I have no rules which depend on a role
        SecurityContext context = SecurityContextHolder.createEmptyContext(); // makes an empty box for the note
        context.setAuthentication(token); // puts the note into the box
        SecurityContextHolder.setContext(context); // hands the box to springSecurity so it knows whose logged in
        // during this request
        HttpSessionSecurityContextRepository repo = new HttpSessionSecurityContextRepository();
        // creates a tool that saves my login into a session
        repo.saveContext(context, request, response); // stores the box on the server and gives 
        // browsewr a cookie which is used to recognize the user
        return authenticatedUser;
    }

}
