package com.example.spring.testespringmvc.controller;

import com.example.spring.testespringmvc.model.Pedido;
import com.example.spring.testespringmvc.service.PedidoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
  @Autowired
  private PedidoService pedidoService;

  @GetMapping("/home")
  public String home(Model model) {
    Iterable<Pedido> pedidos = pedidoService.buscarTodos();
    model.addAttribute("pedidos", pedidos);
    return "home";
  }
}
