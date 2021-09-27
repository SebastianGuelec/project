package com.textify.controller;

import com.textify.entity.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

public class LoginController {

    @RestController
    public class LoginController {

        @PostMapping("/api/v1/login")
        UserVM handleLogin(@CurrentUser User loggedInUser) {
            return new UserVM(loggedInUser);
        }

    }
}
