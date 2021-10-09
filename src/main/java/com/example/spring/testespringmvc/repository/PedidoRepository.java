package com.example.spring.testespringmvc.repository;

import java.util.List;

import com.example.spring.testespringmvc.model.Pedido;
import com.example.spring.testespringmvc.model.StatusPedido;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Integer> {

  List<Pedido> findByStatus(StatusPedido status);

  @Query("SELECT p FROM Pedido p JOIN p.usuario u where u.username = :username")
  List<Pedido> findAllByUsers(@Param("username") String username);

}
