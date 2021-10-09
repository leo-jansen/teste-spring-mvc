package com.example.spring.testespringmvc.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Usuario {
  @Id
  private String username;
  private String password;
  private Boolean enabled;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario", fetch = FetchType.LAZY)
  private List<Pedido> pedidos;

  public Usuario() {
  }

  public Usuario(String username, String password, Boolean enabled) {
    this.username = username;
    this.password = password;
    this.enabled = enabled;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public Boolean getEnabled() {
    return enabled;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }
}
