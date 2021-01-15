package br.com.curso.springhibernate.service;

import br.com.curso.springhibernate.entity.Produto;
import br.com.curso.springhibernate.repository.ProdutoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProdutoService.class);

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> findAll(){
        return produtoRepository.findAll();
    }

    public Produto findById(Long id){
        Optional<Produto> produto = produtoRepository.findById(id);

        if (produto.isPresent()){
            return produto.get();
        }
        LOGGER.info("O id {} não foi encontrado", id);
        throw new IllegalArgumentException();
    }

}
