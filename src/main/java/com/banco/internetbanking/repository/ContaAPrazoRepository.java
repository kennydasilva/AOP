package com.banco.internetbanking.repository;

import com.banco.internetbanking.model.ContaAPrazo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ContaAPrazoRepository extends JpaRepository<ContaAPrazo, Long> {

}
