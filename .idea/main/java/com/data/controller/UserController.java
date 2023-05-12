package com.data.controller;

import com.data.entity.User;

import com.data.service.ServiceInterfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/user")
    List<User> getAllUsers(){
        System.out.println("Controller");
      return  userService.getAllUsers();
    }
}