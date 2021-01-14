package br.com.curso.springhibernate.resources;

import br.com.curso.springhibernate.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResources {

    @GetMapping
    public ResponseEntity<User> findAll(){

        User user = new User("Erick", "erick@mail.com", "33383333", "12345");

        return ResponseEntity.ok().body(user);
    }

}
