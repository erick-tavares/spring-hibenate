package br.com.curso.springhibernate.service;

import br.com.curso.springhibernate.entity.Usuario;
import br.com.curso.springhibernate.repository.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioService.class);

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    public Usuario findById(Long id){
        Optional<Usuario> user = usuarioRepository.findById(id);

        if (user.isPresent()){
            return user.get();
        }
        LOGGER.info("O id {} não foi encontrado", id);
        throw new IllegalArgumentException();
    }

    public Usuario save(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

}
