package com.banco.internetbanking.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor


public class Admin extends Usuario {

    private String nivelDeAcesso;

	public String getNivelDeAcesso() {
		return nivelDeAcesso;
	}

	public void setNivelDeAcesso(String nivelDeAcesso) {
		this.nivelDeAcesso = nivelDeAcesso;
	}
    
    
}