package com.wecp.progressive.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
<<<<<<< HEAD
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
=======
>>>>>>> 1ad1d074529ce688389d9a48e3f657964c2622b8
import org.springframework.stereotype.Service;

import com.wecp.progressive.dto.UserRegistrationDTO;
import com.wecp.progressive.entity.User;
import com.wecp.progressive.jwt.JwtUtil;
import com.wecp.progressive.repository.UserRepository;

@Service
public class UserLoginServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
<<<<<<< HEAD
    @Autowired
    private PasswordEncoder passwordEncoder;
=======

>>>>>>> 1ad1d074529ce688389d9a48e3f657964c2622b8
   public  User createUser(User user) {
     return userRepository.save(user);
    }

   public  User getUserByUsername(String username) {
    return userRepository.findByUsername(username);
    }

<<<<<<< HEAD
   public  void registerUser(UserRegistrationDTO userRegistrationDTO) throws Exception {
    if(userRepository.findByUsername(userRegistrationDTO.getUsername())!=null)
    {
      throw new Exception("user alredy there");
    }
    User user=new User();
    user.setUsername(userRegistrationDTO.getUsername());
    user.setRole(userRegistrationDTO.getRole());
    user.setPassword(passwordEncoder.encode(userRegistrationDTO.getPassword()));
  userRepository.save(user);
=======
   public void registerUser(UserRegistrationDTO userRegistrationDTO) {
>>>>>>> 1ad1d074529ce688389d9a48e3f657964c2622b8
       

    }

<<<<<<< HEAD
  public   User getUserDetails(int userId)  {
  if(userRepository.findById(userId).isEmpty())
  {
    throw new UsernameNotFoundException("User not found with ID: "+ userId);
  }
  return  userRepository.findById(userId).get();
    }
    public UserDetails loadUserByUsername(String username)
    {
       User user=userRepository.findByUsername(username);
       if(user==null)
       {
        throw new UsernameNotFoundException("user not found exception");
       }
       return org.springframework.security.core.userdetails.User
       .withUsername(user.getUsername())
       .password(user.getPassword())
       .roles(user.getRole())
       .build();
    }

=======
  public   User getUserDetails(int userId) {
return userRepository.findById(userId).get();
    }
    public UserDetails loadUserByUsername(String identifier)
    {
      return null;
    }
>>>>>>> 1ad1d074529ce688389d9a48e3f657964c2622b8
}
