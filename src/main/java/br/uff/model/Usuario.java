package br.uff.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;
    @NotNull
    String matricula;
    @NotNull
    String nome;
    @NotNull
    String senha;
    @NotNull
    String email;
    Boolean aprovacaoPendente;

    public Usuario() {
    }

    public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Boolean getAprovacaoPendente() {
        return aprovacaoPendente;
    }

    public void setAprovacaoPendente(Boolean aprovacaoPendente) {
        this.aprovacaoPendente = aprovacaoPendente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
