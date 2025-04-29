package com.christhoper.curso.springboot.error.springboot_error.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.christhoper.curso.springboot.error.springboot_error.exceptions.UserNotFoundException;
import com.christhoper.curso.springboot.error.springboot_error.models.domain.User;
import com.christhoper.curso.springboot.error.springboot_error.services.UserService;


@RestController
@RequestMapping("/app")
public class AppController {

    private final HandlerExceptionController handlerExceptionController;

    @Autowired
    private UserService service;

    AppController(HandlerExceptionController handlerExceptionController) {
        this.handlerExceptionController = handlerExceptionController;
    }

    @GetMapping
    public String index(){
        //int value = 100 / 0;
        int value = Integer.parseInt("20x");
        System.out.println(value);
        return "ok 200";
    }

    @GetMapping("/show/{id}")
    public ResponseEntity<?> show(@PathVariable(name = "id") Long id) {
        //User user = service.findById(id).orElseThrow(() -> new UserNotFoundException("Error el usuario no existe XD!"));
        Optional<User> optionalUser = service.findById(id);
        if (optionalUser.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        //System.out.println(user.getLastname());
        return ResponseEntity.ok(optionalUser.orElseThrow());
    }
    
}
