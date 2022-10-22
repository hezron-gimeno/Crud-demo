package com.hezron.CrudAPIS.resource;

import com.hezron.CrudAPIS.domain.User;
import com.hezron.CrudAPIS.repo.UserRepository;
import com.hezron.CrudAPIS.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("api")
public class UserResource {
//    GET POST PUT AND DELETE
    @Autowired
    UserService userService;

//    GET
@GetMapping()
    public ResponseEntity<?> getUsers(@RequestParam(name="page") int page, @RequestParam(name= "size") int size, @RequestParam(required = false, name="search") String search){
        try{
            page = page -1;
            List<User> userList = userService.viewUsers(size, page, search);
            return new ResponseEntity(userList, HttpStatus.OK);
        }catch (Exception e){
            log.error(".....", e);
            return new ResponseEntity("Error Occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    POST
@PostMapping()
     public ResponseEntity<?> createUser(@RequestBody User user){
    try{
        log.info("User request Received {}", user);
        User userResponse = userService.createUser(user);

        if (userResponse !=null){
            return new ResponseEntity(userResponse, HttpStatus.CREATED);
        }else{
            return new ResponseEntity("Error occurred", HttpStatus.BAD_REQUEST);
        }
    }catch (Exception e){
        log.error(".....", e);
        return new ResponseEntity("Error Occurred", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    }
}
