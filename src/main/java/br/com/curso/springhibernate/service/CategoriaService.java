package br.com.curso.springhibernate.service;

import br.com.curso.springhibernate.entity.Categoria;
import br.com.curso.springhibernate.repository.CategoriaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoriaService.class);

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> findAll(){
        return categoriaRepository.findAll();
    }

    public Categoria findById(Long id){
        Optional<Categoria> categoria = categoriaRepository.findById(id);

        if (categoria.isPresent()){
            return categoria.get();
        }
        LOGGER.info("O id {} não foi encontrado", id);
        throw new IllegalArgumentException();
    }

}
