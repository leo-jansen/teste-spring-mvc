package com.example.spring.testespringmvc.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.example.spring.testespringmvc.model.Pedido;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
  @GetMapping("/home")
  public String home(Model model) {
    Pedido pedido = new Pedido("Redmi Note 8", new BigDecimal("1500"), LocalDate.now(),
        "https://m.media-amazon.com/images/I/51wgmCYDFML._AC_SX569_.jpg",
        "https://www.amazon.com.br/Celular-Xiaomi-Vers%C3%A3o-Global-Space/dp/B07Y9ZHLXW/ref=sr_1_5?__mk_pt_BR=%C3%85M%C3%85%C5%BD%C3%95%C3%91&dchild=1&keywords=redmi+note+8&qid=1632019881&sr=8-5&ufe=app_do%3Aamzn1.fos.25548f35-0de7-44b3-b28e-0f56f3f96147",
        "teste descrição");
    List<Pedido> pedidos = Arrays.asList(pedido);
    model.addAttribute("pedidos", pedidos);
    return "home";
  }
}
