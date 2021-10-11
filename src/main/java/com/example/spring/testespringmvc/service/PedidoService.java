package com.example.spring.testespringmvc.service;

import java.util.List;

import com.example.spring.testespringmvc.model.Pedido;
import com.example.spring.testespringmvc.model.StatusPedido;
import com.example.spring.testespringmvc.repository.PedidoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {
  @Autowired
  private PedidoRepository pedidoRepository;

  public void salvar(Pedido pedido) {
    pedidoRepository.save(pedido);
  }

  public Iterable<Pedido> buscarTodos() {
    return pedidoRepository.findAll();
  }

  public List<Pedido> buscarPorStatus(String status, String username) {
    return pedidoRepository.findByStatusAndUsername(StatusPedido.valueOf(status.toUpperCase()), username);
  }

  public List<Pedido> buscarTodosPorUsuario(String username) {
    return pedidoRepository.findAllByUsers(username);
  }

}
