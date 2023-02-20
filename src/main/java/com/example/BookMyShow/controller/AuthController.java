package com.example.BookMyShow.controller;

import com.example.BookMyShow.config.ApiResponse;
import com.example.BookMyShow.model.User;
import com.example.BookMyShow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> RegisteUser(@RequestBody User user){
        User existingUser=this.userService.findUserByEmail(user.getEmail());
        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            return new ResponseEntity<>(new ApiResponse("There is already an email exists with your emailId",false),HttpStatus.OK);
        }
        boolean registerNewUser=this.userService.RegisterNewUser(user);
        if(registerNewUser)
            return new ResponseEntity<>(new ApiResponse("User Registered Successfully!!",true),HttpStatus.OK);
        else
            return new ResponseEntity<>(new ApiResponse("Registration Unsuccessfull or Check your Email format!!",false),HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@RequestBody User user){
        if(this.userService.UserExistsByEmailAndPassword(user.getEmail(), user.getPassword())){
            return new ResponseEntity<>(new ApiResponse("User LoggedIn Successfully!!",true),HttpStatus.OK);
        }
        return new ResponseEntity<>(new ApiResponse("Login Failed!!",false),HttpStatus.OK);
    }
}
