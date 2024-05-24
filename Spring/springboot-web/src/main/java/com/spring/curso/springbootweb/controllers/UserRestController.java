package com.spring.curso.springbootweb.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
//import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.curso.springbootweb.controllers.models.User;
import com.spring.curso.springbootweb.controllers.models.dto.UserDto;

@RestController
@RequestMapping("/api")
public class UserRestController {

    //DTO
    @GetMapping(path="/details")
    public UserDto details() {

        User user = new User("Ingrid", "Traverso");

        UserDto userDto = new UserDto();
        userDto.setUser(user);
       
       // userDto.setName(user.getName().concat(" ").concat(user.getLastname()));
        userDto.setTittle("Hola Mundo Spring Boot");
          
        return userDto;
    }

    //Map
 /*    @GetMapping(path="/details")
    public Map<String, Object> details() {
        User user = new User("Ingrid", "Traverso");
        Map<String, Object> body =new HashMap<>();

        body.put("tittle", "Hola Mundo Spring Boot");
        body.put("user", user);
        return body;
    }*/
   @GetMapping("/list")
    public List<User> list(){
        User user = new User("Pepe", "Argento");
        User user2 = new User("Roman", "Riquelme");
        User user3 = new User("Rocio", "Riquelme");
    
      
        List<User> users = Arrays.asList(user, user2, user3);
        /*  List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user2);
        users.add(user3);
        */
        return users;
    }
}
