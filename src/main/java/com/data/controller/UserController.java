package com.data.controller;

import com.data.entity.User;

import com.data.service.ServiceInterfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/user")
    List<User> getAllUsers(){
      return  userService.getAllUsers();
    }
    @GetMapping("/deleteUser")
    HashMap<String, String> deleteUser(@RequestParam("user_id")int userId){
        HashMap<String, String> response = new HashMap<>();
        userService.deleteUser(userId);
        response.put("message","user deleted");
        return response;
    }
}
