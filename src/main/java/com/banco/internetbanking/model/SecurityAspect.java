package com.banco.internetbanking.model;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class SecurityAspect extends Aspect {

    private String usuarioAutenticado;

	public String getUsuarioAutenticado() {
		return usuarioAutenticado;
	}

	public void setUsuarioAutenticado(String usuarioAutenticado) {
		this.usuarioAutenticado = usuarioAutenticado;
	}
    
    
}