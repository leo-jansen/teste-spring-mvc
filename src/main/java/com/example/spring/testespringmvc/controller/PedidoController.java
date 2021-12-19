package com.example.spring.testespringmvc.controller;

import javax.validation.Valid;

import com.example.spring.testespringmvc.dto.PedidoTO;
import com.example.spring.testespringmvc.model.Usuario;
import com.example.spring.testespringmvc.service.PedidoService;
import com.example.spring.testespringmvc.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("pedido")
public class PedidoController {
  @Autowired
  private PedidoService pedidoService;

  @Autowired
  private UsuarioService usuarioService;

  @GetMapping("formulario")
  public String formulario(PedidoTO requisicao) {
    return "pedido/formulario";
  }

  @PostMapping("novo")
  public String novo(@Valid PedidoTO requisicao, BindingResult result) {
    if (result.hasErrors()) {
      return "pedido/formulario";
    }

    String username = SecurityContextHolder.getContext().getAuthentication().getName(); 
    Usuario usuario = usuarioService.buscarUsuario(username);
    pedidoService.salvar(requisicao.toPedido(usuario));
    return "redirect:/usuario";
  }
}
