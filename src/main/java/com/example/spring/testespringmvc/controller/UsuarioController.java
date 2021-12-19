package com.example.spring.testespringmvc.controller;

import java.security.Principal;
import java.util.List;

import com.example.spring.testespringmvc.model.Pedido;
import com.example.spring.testespringmvc.service.PedidoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("usuario")
public class UsuarioController {
  @Autowired
  private PedidoService pedidoService;

  @GetMapping
  public String home(Model model, Principal principal) {
    List<Pedido> pedidos = pedidoService.buscarTodosPorUsuario(principal.getName());
    model.addAttribute("pedidos", pedidos);
    return "usuario";
  }

  @GetMapping("/{status}")
  public String statusPedido(@PathVariable("status") String status, Model model) {
    String username = SecurityContextHolder.getContext().getAuthentication().getName();
    List<Pedido> pedidos = pedidoService.buscarPorStatusEUsuario(status, username);
    model.addAttribute("pedidos", pedidos);
    model.addAttribute("status", status);
    return "usuario";
  }

  @ExceptionHandler(IllegalArgumentException.class)
  public String onError() {
    return "redirect:/home";
  }
}
