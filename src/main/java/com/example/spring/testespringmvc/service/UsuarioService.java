package com.example.spring.testespringmvc.service;

import com.example.spring.testespringmvc.model.Usuario;
import com.example.spring.testespringmvc.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
  @Autowired
  private UsuarioRepository usuarioRepository;

  public Usuario buscarUsuario(String username) {
    return usuarioRepository.findByUsername(username);
  }
}
