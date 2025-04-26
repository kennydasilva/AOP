package com.banco.internetbanking.aspect;

import java.math.BigDecimal;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.banco.internetbanking.model.Conta;
import com.banco.internetbanking.repository.ContaRepository;

@Aspect
@Component
public class TransacaoAspect {

    @Autowired
    private ContaRepository contaRepository;
    
    @Around("@annotation(org.springframework.transaction.annotation.Transactional) && execution(* com.seuprojeto.service.ContaService.*(..))")
    public Object gerenciarTransacao(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = null;
        
        Object[] args = joinPoint.getArgs();
        
        if (args != null && args.length > 0) {
           
            BigDecimal valor = (BigDecimal) args[0]; 

            if (valor.compareTo(BigDecimal.ZERO) <= 0) {
                throw new IllegalArgumentException("O valor deve ser maior que zero.");
            }

            
            if (args[1] instanceof Long && valor != null) {
                Long contaId = (Long) args[1]; 

                
                Conta conta = contaRepository.findById(contaId)
                    .orElseThrow(() -> new RuntimeException("Conta não encontrada"));
                
                if (valor.compareTo(conta.getSaldo()) > 0) {
                    throw new IllegalArgumentException("Saldo insuficiente para a operação.");
                }
            }
        }

        try {
            result = joinPoint.proceed();
        } catch (Exception e) {
            throw e;
        }
        
        return result;
    }
}
