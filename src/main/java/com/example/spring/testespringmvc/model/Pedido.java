package com.example.spring.testespringmvc.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Pedido {
  private String nome;
  private BigDecimal valor;
  private LocalDate dataEntrega;
  private String urlImagem;
  private String urlProduto;
  private String descricao;

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
}
