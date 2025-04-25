package com.banco.internetbanking.model;

import jakarta.persistence.Entity;
import java.time.LocalDate;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContaAPrazo extends Conta {

    private LocalDate dataVencimento;
    private double juros;
}