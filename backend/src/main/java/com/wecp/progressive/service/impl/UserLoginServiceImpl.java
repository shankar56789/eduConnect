package com.wecp.progressive.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.wecp.progressive.dto.UserRegistrationDTO;
import com.wecp.progressive.entity.Student;
import com.wecp.progressive.entity.Teacher;
import com.wecp.progressive.entity.User;
import com.wecp.progressive.jwt.JwtUtil;
import com.wecp.progressive.repository.StudentRepository;
import com.wecp.progressive.repository.TeacherRepository;
import com.wecp.progressive.repository.UserRepository;

@Service
public class UserLoginServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
   public  User createUser(User user) {
     return userRepository.save(user);
    }

   public  User getUserByUsername(String username) {
    return userRepository.findByUsername(username);
    }

   public  void registerUser(UserRegistrationDTO userRegistrationDTO) throws Exception {
    if(userRepository.findByUsername(userRegistrationDTO.getUsername())!=null)
    {
      throw new Exception("The user already exists.");
    }
    User user=new User();
    user.setUsername(userRegistrationDTO.getUsername());
    user.setRole(userRegistrationDTO.getRole());
    user.setPassword(passwordEncoder.encode(userRegistrationDTO.getPassword()));

    if("STUDENT".equalsIgnoreCase(userRegistrationDTO.getRole()))
    {
      Student student=new Student();
      student.setFullName(userRegistrationDTO.getFullName());
      student.setContactNumber(userRegistrationDTO.getContactNumber());
      student.setEmail(userRegistrationDTO.getEmail());
      student.setAddress(userRegistrationDTO.getAddress());
      student.setDateOfBirth(userRegistrationDTO.getDateOfBirth());
      Student savedstudent=studentRepository.save(student);
      user.setStudent(savedstudent);
    }
    if("TEACHER".equalsIgnoreCase(userRegistrationDTO.getRole()))
    {
      Teacher teacher=new Teacher();
      teacher.setFullName(userRegistrationDTO.getFullName());
      teacher.setContactNumber(userRegistrationDTO.getContactNumber());
      teacher.setEmail(userRegistrationDTO.getEmail());
      teacher.setSubject(userRegistrationDTO.getSubject());
      teacher.setYearsOfExperience(userRegistrationDTO.getYearsOfExperience());
      Teacher savedteacher=teacherRepository.save(teacher);
      user.setTeacher(savedteacher);
    }
    

  userRepository.save(user);
       

    }

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

}
