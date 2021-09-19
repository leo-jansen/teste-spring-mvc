package com.example.spring.testespringmvc.repository;

import com.example.spring.testespringmvc.model.Pedido;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Integer> {

}
