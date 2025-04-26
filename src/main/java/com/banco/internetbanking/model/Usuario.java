package com.banco.internetbanking.model;

import jakarta.persistence.*;
import lombok.*;


import jakarta.persistence.MappedSuperclass;


@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor

public abstract class Usuario extends BaseEntity {

    private String nome;
    private String email;
    private String senha;
    private boolean bloqueado;
    private int tentativasFalha;
    
    
    
	public boolean isBloqueado() {
		return bloqueado;
	}
	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}
	public int getTentativasFalha() {
		return tentativasFalha;
	}
	public void setTentativasFalha(int tentativasFalha) {
		this.tentativasFalha = tentativasFalha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
    
    
    
}
