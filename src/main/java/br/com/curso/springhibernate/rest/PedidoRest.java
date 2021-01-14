package br.com.curso.springhibernate.rest;

import br.com.curso.springhibernate.entity.Pedido;
import br.com.curso.springhibernate.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoRest {

    @Autowired
    PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<Pedido>> findAll(){
        List<Pedido> pedidoList = pedidoService.findAll();
        return ResponseEntity.ok().body(pedidoList);
    }

    @GetMapping (value = "/{id}")
    public ResponseEntity<Pedido> findById(@PathVariable Long id){
        Pedido pedido = pedidoService.findById(id);
        return ResponseEntity.ok().body(pedido);
    }

}
