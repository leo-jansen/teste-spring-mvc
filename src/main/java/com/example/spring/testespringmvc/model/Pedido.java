package com.example.spring.testespringmvc.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Pedido {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String nome;
  private BigDecimal valor;
  @Column(name = "data_entrega")
  private LocalDate dataEntrega;
  @Column(name = "url_imagem")
  private String urlImagem;
  @Column(name = "url_produto")
  private String urlProduto;
  private String descricao;
  @Enumerated(EnumType.STRING)
  private StatusPedido status;
  @ManyToOne(fetch = FetchType.LAZY)
  private Usuario usuario;

  public Pedido() {
  }

  public Pedido(String nome, String urlImagem, String urlProduto, String descricao, StatusPedido status) {
    this.nome = nome;
    this.urlImagem = urlImagem;
    this.urlProduto = urlProduto;
    this.descricao = descricao;
    this.status = status;
  }

  public Pedido(String nome, BigDecimal valor, LocalDate data, String urlImagem, String urlProduto, String descricao) {
    this.nome = nome;
    this.valor = valor;
    this.dataEntrega = data;
    this.urlImagem = urlImagem;
    this.urlProduto = urlProduto;
    this.descricao = descricao;
  }

  public String getNome() {
    return nome;
  }

  public BigDecimal getValor() {
    return valor;
  }

  public LocalDate getDataEntrega() {
    return dataEntrega;
  }

  public String getUrlImagem() {
    return urlImagem;
  }

  public String getUrlProduto() {
    return urlProduto;
  }

  public String getDescricao() {
    return descricao;
  }

  public StatusPedido getStatus() {
    return status;
  }
}
