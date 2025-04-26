package com.banco.internetbanking.repository;



import com.banco.internetbanking.model.PerformanceAspect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerformanceAspectRepository extends JpaRepository<PerformanceAspect, Long> {

}
