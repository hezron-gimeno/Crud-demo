package com.hezron.CrudAPIS.service;

import com.hezron.CrudAPIS.domain.User;
import com.hezron.CrudAPIS.repo.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserService {
//    CREATE VIEW UPDATE AND DELETE USERS

    @Autowired
    UserRepository userRepository;

//    create a user

    public User createUser(User user){
    try{
        userRepository.save(user);
        return user;
    }catch (Exception e){
     log.error("error occurs", e);
        return null;
    }

}

//update User
    public String updateUser(User user){
    try{
        log.info("received an update to save user {}", user.getUsername());
//        userRepository.save(user);
        return "success";

    }catch (Exception e){
        log.error("error occurred", e);

    }
        return null;


    }

//    view Users
    public List<User> viewUsers() {
    return userRepository.findAll();
    }

//    delete user
    public String deleteUser(User user){
    userRepository.delete(user);
    return "success";
    }

}
