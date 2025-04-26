package com.banco.internetbanking.repository;


import com.banco.internetbanking.model.LoggingAspect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoggingAspectRepository extends JpaRepository<LoggingAspect, Long>{

}
