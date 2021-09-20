package com.example.spring.testespringmvc.dto;

import com.example.spring.testespringmvc.model.Pedido;

public class PedidoTO {
  private String nomeProduto;
  private String urlProduto;
  private String urlImagem;
  private String descricao;

  public String getNomeProduto() {
    return nomeProduto;
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

  public void setNomeProduto(String nomeProduto) {
    this.nomeProduto = nomeProduto;
  }

  public void setUrlImagem(String urlImagem) {
    this.urlImagem = urlImagem;
  }

  public void setUrlProduto(String urlProduto) {
    this.urlProduto = urlProduto;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public Pedido toPedido() {
    return new Pedido(this.nomeProduto, this.urlImagem, this.urlProduto, this.descricao);
  }
}
