package com.example.BookMyShow.service.impl;

import com.example.BookMyShow.exception.ResourceNotFoundException;
import com.example.BookMyShow.model.User;
import com.example.BookMyShow.repository.UserRepo;
import com.example.BookMyShow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public User createUser(User user) {
        User user1=this.userRepo.save(user);
        return user1;
    }

    @Override
    public List<User> findAllUsers() {
        return this.userRepo.findAll();
    }

    @Override
    public User updateUser(User user, int id) {
        User user1=this.userRepo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("User","userId",id));
        if(user.getName()!=null)
            user1.setName(user.getName());
        if(user.getEmail()!=null)
            user1.setEmail(user.getEmail());
        if(user.getPassword()!=null)
            user1.setPassword(user.getPassword());
        if(user.getPhone_number()!=null)
            user1.setPhone_number(user.getPhone_number());
        return this.userRepo.save(user1);
    }

    @Override
    public User findUserById(int id) {
        User user=this.userRepo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("User","UserId",id));
        return user;
    }

    @Override
    public void deleteUserById(int id) {
        User user=this.userRepo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("User","UserId",id));
        this.userRepo.delete(user);
    }



    @Override
    public boolean RegisterNewUser(User user) {
        boolean isRegister=false;
        if(user!=null) {
            String regex = "^(.+)@(.+)$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(user.getEmail());
            if (matcher.matches()) {
                isRegister = true;
                User saveUser = this.userRepo.save(user);
            }
        }
        return isRegister;
    }

    @Override
    public User findUserByEmail(String email) {
        return this.userRepo.findByEmail(email);
    }

    @Override
    public boolean UserExistsByEmailAndPassword(String email,String password){
        return this.userRepo.existsByEmailAndPassword(email,password);
    }

}
