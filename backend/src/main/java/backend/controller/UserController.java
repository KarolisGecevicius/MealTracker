package backend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.model.User;
import backend.services.UserService;

@RestController 
@RequestMapping("/users")
public class UserController 
{
    private final UserService service;

    public UserController(UserService service)
    {
        this.service=service;
    }

    @PostMapping 
    public User addUser(@RequestBody User user)
    {
        return service.add(user);
    }

}
