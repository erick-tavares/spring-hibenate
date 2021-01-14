package br.com.curso.springhibernate.service;

import br.com.curso.springhibernate.entity.Pedido;
import br.com.curso.springhibernate.repository.PedidoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PedidoService.class);

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> findAll(){
        return pedidoRepository.findAll();
    }

    public Pedido findById(Long id){
        Optional<Pedido> pedido = pedidoRepository.findById(id);

        if (pedido.isPresent()){
            return pedido.get();
        }
        LOGGER.info("O id {} não foi encontrado", id);
        throw new IllegalArgumentException();
    }

}
