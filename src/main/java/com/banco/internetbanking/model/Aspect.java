package com.banco.internetbanking.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor

public abstract class Aspect extends BaseEntity{

    

    private String tipoAspecto;
    private LocalDateTime dataHora;
	public String getTipoAspecto() {
		return tipoAspecto;
	}
	public void setTipoAspecto(String tipoAspecto) {
		this.tipoAspecto = tipoAspecto;
	}
	public LocalDateTime getDataHora() {
		return dataHora;
	}
	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}
    
    
}