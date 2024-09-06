package com.christhoper.curso.springboot.webapp.springboot_web.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.christhoper.curso.springboot.webapp.springboot_web.models.User;
import com.christhoper.curso.springboot.webapp.springboot_web.models.dto.UserDto;


@RestController
@RequestMapping("/api")
public class UserRestController {

    @RequestMapping(path = "/details", method = RequestMethod.GET)
    public UserDto details(){
        
        User user = new User("Christhoper", "Portillo");

        UserDto userDto = new UserDto();
        userDto.setUser(user);
        userDto.setTitle("Hola Mundo Spring Boot desde Model");

        return userDto;
    }

    @GetMapping("/list")
    public List<User> list(){
        User user = new User("Christhoper", "Portillo");
        User user2 = new User("Pepe", "Doe");
        User user3 = new User("Jhon", "Doe");

        List<User> users = Arrays.asList(user, user2, user3);
        /* List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user2);
        users.add(user3); */

        return users;
    }
    
    /* @RequestMapping(path = "/details", method = RequestMethod.GET)
    public Map<String, Object> details(){

        User user = new User("Christhoper", "Portillo");
        Map<String, Object> body = new HashMap<>();
        
        body.put("title", "Hola Mundo Spring Boot desde Model");
        body.put("user", user);
        return body;
    } */

}
