package com.banco.internetbanking.repository;

import com.banco.internetbanking.model.Conta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {

	Conta findByNumeroConta(String numerconta);

}
