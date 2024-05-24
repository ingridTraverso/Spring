package com.spring.curso.springbootweb.controllers;

//import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import com.spring.curso.springbootweb.controllers.models.User;
//import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model) {

        User user = new User("Ingrid", "Traverso");
        user.setEmail("ingrid@ingrid.com");
        model.addAttribute("tittle", "Hola Mundo Spring Boot");
        model.addAttribute("user", user);
        return "details";
    }


    @GetMapping("/list")
    public String list(ModelMap model) {
        List<User> users = Arrays.asList(new User("Pepa","Gonzalez"),
        new User("Lalo", "Rodriguez", "Lalo@gmail.com"),
        new User("Andrea", "Romero"),
        new User("Juan", "Nunez", "juan@hotmail.com"));


        model.addAttribute("users", users);
        model.addAttribute("tittle","Listado de Usuarios");
        return "list";
        
    }
    
   
}
