package com.casa.mongospring.controller;

import com.casa.mongospring.dto.UserDTO;
import com.casa.mongospring.model.User;
import com.casa.mongospring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(method=RequestMethod.GET, value = "/user/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable String id) {
        return ResponseEntity.ok(userService.findUserById(id));
    }

    @RequestMapping(method=RequestMethod.POST, value = "/user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.created(
                org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                        .buildAndExpand(user.getId()).toUri()
        ).body(userService.createUser(user));
    }

    @RequestMapping(method=RequestMethod.DELETE, value = "/user/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method=RequestMethod.PUT, value = "/user/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable String id) {
        return ResponseEntity.ok(userService.updateUser(user, id));
    }
}
