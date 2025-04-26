package com.banco.internetbanking.model;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class PerformanceAspect extends Aspect {

    private double tempoExecucao;
    private String metodoExecutado;
	public double getTempoExecucao() {
		return tempoExecucao;
	}
	public void setTempoExecucao(double tempoExecucao) {
		this.tempoExecucao = tempoExecucao;
	}
	public String getMetodoExecutado() {
		return metodoExecutado;
	}
	public void setMetodoExecutado(String metodoExecutado) {
		this.metodoExecutado = metodoExecutado;
	}
    
    
}