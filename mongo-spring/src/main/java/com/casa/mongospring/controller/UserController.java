package com.casa.mongospring.controller;

import com.casa.mongospring.dto.UserDTO;
import com.casa.mongospring.model.User;
import com.casa.mongospring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping(method=RequestMethod.GET, value = "/user")
    public ResponseEntity<List<UserDTO>> getUser() {
        List<User> users = userService.findAllUsers();
        return ResponseEntity.ok(userService.convertToDTO(users));
    }
}
