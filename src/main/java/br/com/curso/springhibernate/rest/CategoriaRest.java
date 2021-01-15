package br.com.curso.springhibernate.rest;

import br.com.curso.springhibernate.entity.Categoria;
import br.com.curso.springhibernate.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaRest {

    @Autowired
    CategoriaService pedidoService;

    @GetMapping
    public ResponseEntity<List<Categoria>> findAll(){
        List<Categoria> categoriaList = pedidoService.findAll();
        return ResponseEntity.ok().body(categoriaList);
    }

    @GetMapping (value = "/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Long id){
        Categoria categoria = pedidoService.findById(id);
        return ResponseEntity.ok().body(categoria);
    }
}
