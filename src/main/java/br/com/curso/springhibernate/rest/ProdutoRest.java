package br.com.curso.springhibernate.rest;

import br.com.curso.springhibernate.entity.Produto;
import br.com.curso.springhibernate.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoRest {

    @Autowired
    ProdutoService produtosService;

    @GetMapping
    public ResponseEntity<List<Produto>> findAll(){
        List<Produto> produtoList = produtosService.findAll();
        return ResponseEntity.ok().body(produtoList);
    }

    @GetMapping (value = "/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Long id){
        Produto produto = produtosService.findById(id);
        return ResponseEntity.ok().body(produto);
    }

}
