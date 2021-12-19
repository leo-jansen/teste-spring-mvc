package com.example.spring.testespringmvc.controller;

import java.util.List;

import com.example.spring.testespringmvc.model.Pedido;
import com.example.spring.testespringmvc.model.StatusPedido;
import com.example.spring.testespringmvc.service.PedidoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {
  @Autowired
  private PedidoService pedidoService;

  @GetMapping
  public String home(Model model) {
    List<Pedido> pedidos = pedidoService.buscarPorStatus(StatusPedido.ENTREGUE);
    model.addAttribute("pedidos", pedidos);
    return "home";
  }
}
