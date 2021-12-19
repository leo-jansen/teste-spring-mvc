package com.example.spring.testespringmvc.repository;

import java.util.List;

import com.example.spring.testespringmvc.model.Pedido;
import com.example.spring.testespringmvc.model.StatusPedido;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Integer> {
  @Query("SELECT p FROM Pedido p JOIN p.usuario u WHERE p.status = :status AND u.username = :username")
  List<Pedido> findByStatusAndUsername(@Param("status") StatusPedido status, @Param("username") String username);

  @Cacheable("pedidos")
  @Query("SELECT p FROM Pedido p JOIN p.usuario u WHERE p.status = :status")
  List<Pedido> findByStatus(@Param("status") StatusPedido status, Pageable page);

  @Query("SELECT p FROM Pedido p JOIN p.usuario u where u.username = :username")
  List<Pedido> findAllByUsers(@Param("username") String username);

}
