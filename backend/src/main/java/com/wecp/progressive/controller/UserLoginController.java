package com.wecp.progressive.controller;

import com.wecp.progressive.dto.LoginRequest;
import com.wecp.progressive.dto.LoginResponse;
import com.wecp.progressive.dto.UserRegistrationDTO;
<<<<<<< HEAD
import com.wecp.progressive.entity.User;
import com.wecp.progressive.jwt.JwtUtil;
import com.wecp.progressive.service.impl.UserLoginServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/user")
public class UserLoginController {
    @Autowired
    UserLoginServiceImpl userLoginServiceImpl;
     @Autowired
     AuthenticationManager authenticationManager;
     @Autowired
     JwtUtil jwtUtil;
    public String postMethodName(@RequestBody String entity) {
        //TODO: process POST request
        
        return entity;
    }
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRegistrationDTO registrationDTO) throws Exception {
        try{
        userLoginServiceImpl.registerUser(registrationDTO);
      return new ResponseEntity<>(HttpStatus.CREATED);
    }
    catch(Exception e)
    {
        return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
    }
}

    public ResponseEntity<LoginResponse> loginUser(LoginRequest loginRequest) {
       Authentication authentication =authenticationManager.authenticate
       (
        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        String token=jwtUtil.generateToken(loginRequest.getUsername());
        User user=userLoginServiceImpl.getUserByUsername(loginRequest.getUsername());
        Integer studentId=null;
        Integer teacherId=null;
        if(user.getRole().equals("STUDENT")&&user.getStudent()!=null)
        {
            studentId=user.getStudent().getStudentId();
        }
        if(user.getRole().equals("TEACHER")&&user.getTeacher()!=null)
        {
            teacherId=user.getTeacher().getTeacherId();
        }
        LoginResponse ls=new LoginResponse(token, user.getRole(), user.getUserId(), studentId,teacherId);
        return new ResponseEntity<>(ls,HttpStatus.OK);

       }
    
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserDetails(@PathVariable int userId) {
         try
         {

        return new ResponseEntity<>(userLoginServiceImpl.getUserDetails(userId),HttpStatus.OK);
         }
        catch(Exception e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    
=======
import org.springframework.http.ResponseEntity;

public class UserLoginController {
    public ResponseEntity<?> registerUser(UserRegistrationDTO registrationDTO) {
        return null;
    }

    public ResponseEntity<LoginResponse> loginUser(LoginRequest loginRequest) {
        return null;
    }

    public ResponseEntity<?> getUserDetails(int userId) {
        return null;
>>>>>>> 1ad1d074529ce688389d9a48e3f657964c2622b8
    }
}
