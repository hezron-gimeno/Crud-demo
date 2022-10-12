package com.hezron.CrudAPIS.resource;

import com.hezron.CrudAPIS.domain.User;
import com.hezron.CrudAPIS.repo.UserRepository;
import com.hezron.CrudAPIS.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
public class UserResource {
//    GET POST PUT AND DELETE
    @Autowired
    UserService userService;
@GetMapping
    public ResponseEntity<?> getUsers(){
        try{
            List<User> userList = userService.viewUsers();
            return new ResponseEntity<>(userList, HttpStatus.OK);
        }catch (Exception e){
            log.error(".....", e);
            return new ResponseEntity<>("Error Occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
