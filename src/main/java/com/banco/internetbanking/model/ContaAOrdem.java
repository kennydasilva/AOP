package com.banco.internetbanking.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ContaAOrdem extends Conta {

    private BigDecimal limiteCredito;
    private int depositosAcimaDe3000;
    
    

	public int getDepositosAcimaDe3000() {
		return depositosAcimaDe3000;
	}

	public void setDepositosAcimaDe3000(int depositosAcimaDe3000) {
		this.depositosAcimaDe3000 = depositosAcimaDe3000;
	}

	public BigDecimal getLimiteCredito() {
		return limiteCredito;
	}

	public void setLimiteCredito(BigDecimal limiteCredito) {
		this.limiteCredito = limiteCredito;
	}

	
	
    
    
}