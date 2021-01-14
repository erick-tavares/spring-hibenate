package br.com.curso.springhibernate.rest;

import br.com.curso.springhibernate.entity.Usuario;
import br.com.curso.springhibernate.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioRest {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> findAll(){
        List<Usuario> usuarioList = usuarioService.findAll();
        return ResponseEntity.ok().body(usuarioList);
    }

    @GetMapping (value = "/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id){
        Usuario usuario = usuarioService.findById(id);
        return ResponseEntity.ok().body(usuario);
    }

}
