package com.futurex.course.CourseApp.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.futurex.course.CourseApp.FirebaseService;
import com.futurex.course.CourseApp.model.User;

@RestController
public class UserController {

    @Autowired
    private FirebaseService firebaseService;

    @GetMapping("/getUser")
    public User getUser(@RequestHeader() String uid) throws InterruptedException, ExecutionException {
        return firebaseService.getUser(uid);
    }

    @PostMapping("/createUser")
    public String createUser(@RequestBody User user) throws InterruptedException, ExecutionException {
        firebaseService.createUser(user);
        return "Created User " + user.getUsername();
    }

    @PutMapping("/updateUser")
    public String updateUser(@RequestBody User user) throws InterruptedException, ExecutionException {
        return "Updated User" + user.getUsername();
    }

    @DeleteMapping("/deleteUser")
    public String deleteUser(@RequestHeader String name) {
        return "Deleted User " + name;
    }

}