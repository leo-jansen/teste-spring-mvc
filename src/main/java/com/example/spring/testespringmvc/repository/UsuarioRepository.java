package com.example.spring.testespringmvc.repository;

import com.example.spring.testespringmvc.model.Usuario;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, String> {

  Usuario findByUsername(String username);

}
