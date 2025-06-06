package com.banco.internetbanking.repository;

import com.banco.internetbanking.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	 boolean existsByEmail(String email);

	Cliente findByEmail(String email);
	
}
