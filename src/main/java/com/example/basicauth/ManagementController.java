package com.example.basicauth;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/users")

@PreAuthorize("HasAnyRole('ROLE_ADMIN','ROLE_ADMINTRAINEE')")
public class ManagementController {


    private static final List<User> USERS = Arrays.asList(
            new User(1, "Ahmed Mukhtar", "mukhtar1100@hotmail.com"),
            new User(2, "Abdinaasir Ahmed", "abdinaasir00@hotmail.com"),
            new User(3, "Anas Ahmed", "anas@hotmail.com")

    );


    @GetMapping

    @PreAuthorize(("hasAnyRole('ROLE_ADMIN','ROLE_ADMINTRAINEE')"))
    public List<User> getAllUsers(){
        return USERS;
    }


    @PostMapping
    @PreAuthorize("hasAuthority('student:write')")
    public void registerNewUser(@RequestBody User user){
        System.out.println(user);
    }


    @DeleteMapping(path = "{userId}")
    @PreAuthorize("hasAuthority('student:write')")
    public void deleteUser(@PathVariable("userId") Integer userId){
        System.out.println(userId);
    }

    @PutMapping(path = "{userId}")
    @PreAuthorize("hasAuthority('student:write')")

    public void updateUser(@PathVariable("userId") Integer userId, @RequestBody User user){
        System.out.println(userId);
    }
}
