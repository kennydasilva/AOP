package com.banco.internetbanking.model;

import jakarta.persistence.*;
import lombok.*;
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
	
	private double saldo;
	private String numeroConta;

}
