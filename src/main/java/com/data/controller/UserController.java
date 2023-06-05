package com.data.controller;

import com.data.entity.Page;
import com.data.entity.User;

import com.data.service.ServiceInterfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/getPagedUsers")
    Page<User> getAllUsers(@RequestParam("pageIndex") int pageIndex,
                           @RequestParam("elementsPerPage") int elementsPerPage){
      return  userService.getAllUsers(pageIndex,elementsPerPage);
    }
}
