package com.banco.internetbanking.repository;


import com.banco.internetbanking.model.ExceptionAspect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExceptionAspectRepository extends JpaRepository<ExceptionAspect, Long> {

}
