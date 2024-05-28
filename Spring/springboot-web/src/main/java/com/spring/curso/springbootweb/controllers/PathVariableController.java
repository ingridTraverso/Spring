package com.spring.curso.springbootweb.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.curso.springbootweb.controllers.models.User;
import com.spring.curso.springbootweb.controllers.models.dto.ParamDto;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    @Value("${config.username}")
    private String username;

   /* paso como argumento del metodo handler y no como atributo @Value("${config.message}")
    private String message;*/ 
    
    @Value("${config.listOfValues}")
    private String[] listOfValues;
    
    @Value("${config.code}")
    private Integer code;

    @GetMapping("/baz/{message}")
    public ParamDto baz(@PathVariable() String message) {

        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;
    }
    

@GetMapping("/mix/{product}/{id}")
public Map<String, Object> mixPathVar(@PathVariable String product, @PathVariable Long id){
    Map<String, Object> json = new HashMap<>();
    json.put("product", product);
    json.put("id", id);
    return json;
}


@PostMapping("/create")
public User create (@RequestBody User user){
    //hacer algo con el usuario en la bbdd
    return user;
}


@GetMapping("/values")
public Map<String, Object> values(@Value("${config.message}")String message){

    Map<String, Object> json = new HashMap<>();
    json.put("username", username);
    json.put("code", code);
    json.put("message", message);
    json.put("listOfValues", listOfValues);

    return json;
}
}
    

