package com.example.BookMyShow.repository;

import com.example.BookMyShow.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

   boolean existsByEmailAndPassword(String email, String password);

   User findByEmail(String email);
}
