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
}