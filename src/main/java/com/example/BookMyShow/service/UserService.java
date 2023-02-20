package com.example.BookMyShow.service;

import com.example.BookMyShow.model.User;

import java.util.List;

public interface UserService {

    User createUser(User user);
    List<User> findAllUsers();
    User updateUser(User movie,int id);
    User findUserById(int id);
    void deleteUserById(int id);
    boolean RegisterNewUser(User user);
    User findUserByEmail(String email);
    //boolean LoginUser(User user);
    boolean UserExistsByEmailAndPassword(String email,String password);

}
