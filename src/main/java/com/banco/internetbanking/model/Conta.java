package com.banco.internetbanking.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@NoArgsConstructor
@AllArgsConstructor

public abstract class Conta extends BaseEntity {
	
	
	
	@ManyToOne
	@JoinColumn(name ="client_id")
	private Cliente cliente;
	
	
	@OneToMany(mappedBy = "contaOrigem")
	private List<Transacao> transacoesOrigem;
	
	@OneToMany(mappedBy = "contaDestino")
	private List<Transacao> transacoesDestino;
	
	private BigDecimal saldo;
	private String numeroConta;
	private boolean bloqueado;
	
	
	
	public boolean isBloqueado() {
		return bloqueado;
	}
	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<Transacao> getTransacoesOrigem() {
		return transacoesOrigem;
	}
	public void setTransacoesOrigem(List<Transacao> transacoesOrigem) {
		this.transacoesOrigem = transacoesOrigem;
	}
	public List<Transacao> getTransacoesDestino() {
		return transacoesDestino;
	}
	public void setTransacoesDestino(List<Transacao> transacoesDestino) {
		this.transacoesDestino = transacoesDestino;
	}
	
	public String getNumeroConta() {
		return numeroConta;
	}
	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}
	public BigDecimal getSaldo() {
		return saldo;
	}
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	
	
	

}
