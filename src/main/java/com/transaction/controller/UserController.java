package com.transaction.controller;

import com.transaction.entity.Page;
import com.transaction.entity.User;

import com.transaction.service.ServiceInterfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
