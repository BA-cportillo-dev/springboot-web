package com.christhoper.curso.springboot.webapp.springboot_web.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.christhoper.curso.springboot.webapp.springboot_web.models.User;


@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model){
        User user = new User("Christhoper", "Portillo");

        model.addAttribute("title", "Hola Mundo Spring Boot desde Model");
        model.addAttribute("user", user);
        return "details";
    }

    @GetMapping("/list")
    public String list(ModelMap model){
        List<User> users = Arrays.asList(
                new User("Pepa", "Pig"),
                new User("Lalo", "Perez", "lalo@correo.com"),
                new User("Juanita", "Roe", "juana@correo.com"),
                new User("Andres", "Doe"));

        model.addAttribute("users", users);
        model.addAttribute("title", "Listado de usuarios!");
        return "list";
    }
}
