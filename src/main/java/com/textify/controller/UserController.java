package com.textify.controller;

import com.textify.entity.User;
import com.textify.errorHandling.GenericResponse;
import com.textify.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/users")
    GenericResponse createUser(@RequestBody User user){
        userService.save(user);
        return new GenericResponse("User saved.");
    }
}
