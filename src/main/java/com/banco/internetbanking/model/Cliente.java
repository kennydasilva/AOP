package com.banco.internetbanking.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente extends Usuario {
	
	private String enderenco;
	private String telefone;
	
	@OneToMany(mappedBy = "cliente",cascade=CascadeType.ALL)
	private List<Conta> contas;

}
