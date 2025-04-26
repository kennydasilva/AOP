package com.banco.internetbanking.repository;

import com.banco.internetbanking.model.SecurityAspect;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecurityAspectRepository extends JpaRepository<SecurityAspect, Long>{

}
