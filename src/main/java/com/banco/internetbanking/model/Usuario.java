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
}
