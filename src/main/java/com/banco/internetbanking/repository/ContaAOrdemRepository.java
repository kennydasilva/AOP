package com.banco.internetbanking.repository;

import com.banco.internetbanking.model.ContaAOrdem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaAOrdemRepository extends JpaRepository<ContaAOrdem,Long> {

}
