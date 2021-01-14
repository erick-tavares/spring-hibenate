package br.com.curso.springhibernate.repositories;

import br.com.curso.springhibernate.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
