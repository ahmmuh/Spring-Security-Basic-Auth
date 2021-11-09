package com.example.basicauth;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

   private static final List<User> USERS = Arrays.asList(
           new User(1, "Ahmed Mukhtar", "mukhtar1100@hotmail.com"),
           new User(2, "Abdinaasir Ahmed", "abdinaasir00@hotmail.com"),
           new User(3, "Anas Ahmed", "anas@hotmail.com")


   );

   @GetMapping( path = "{userId}")
    public User getUser(@PathVariable("userId") Integer userId){
    return USERS.stream()
            .filter(user -> userId.equals(user.getId()))
            .findFirst()
            .orElseThrow(() -> new IllegalStateException("User " + userId + "not exists"));
   }
}
