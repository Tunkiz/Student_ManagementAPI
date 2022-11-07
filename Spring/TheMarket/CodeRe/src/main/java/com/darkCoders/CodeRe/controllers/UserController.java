package com.darkCoders.CodeRe.controllers;

import com.darkCoders.CodeRe.models.User;
import com.darkCoders.CodeRe.models.dtos.UserDTO;
import com.darkCoders.CodeRe.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody final User user){
        User newUser = userService.addUser(user);
        return new ResponseEntity<>(UserDTO.from(newUser), HttpStatus.CREATED);
    }
}
