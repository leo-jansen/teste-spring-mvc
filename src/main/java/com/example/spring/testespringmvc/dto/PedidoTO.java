package com.example.spring.testespringmvc.dto;

import javax.validation.constraints.NotBlank;

import com.example.spring.testespringmvc.model.Pedido;
import com.example.spring.testespringmvc.model.StatusPedido;
import com.example.spring.testespringmvc.model.Usuario;

public class PedidoTO {
  @NotBlank
  private String nomeProduto;
  @NotBlank
  private String urlProduto;
  @NotBlank
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

  public Pedido toPedido(Usuario usuario) {
    return new Pedido(this.nomeProduto, this.urlImagem, this.urlProduto, this.descricao, StatusPedido.AGUARDANDO, usuario);
  }
}
