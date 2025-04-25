package com.banco.internetbanking.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Usuario {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String email;
	private String senha;
	

}
