package backend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import backend.model.User;

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
    public User authenticateUser(@RequestBody User user)
    {
        return service.authenticate(user);
    }
}
