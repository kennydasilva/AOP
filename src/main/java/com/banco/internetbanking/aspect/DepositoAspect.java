package com.banco.internetbanking.aspect;

import java.math.BigDecimal;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.banco.internetbanking.model.Conta;
import com.banco.internetbanking.model.ContaAOrdem;
import com.banco.internetbanking.repository.ContaRepository;

@Aspect
@Component
public class DepositoAspect {

    @Autowired
    private ContaRepository contaRepository;

    @Before("execution(* com.banco.internetbanking.service.ContaService.depositar(..)) && args(contaId, valor)")
    public void verificarLimiteDeCredito(String numerodaConta, BigDecimal valor) throws Exception {
        
    	Conta conta=contaRepository.findByNumeroConta(numerodaConta);
    	
    	ContaAOrdem contaOrdem = (ContaAOrdem) contaRepository.findById(conta.getId())
                .orElseThrow(() -> new Exception("Conta não encontrada"));

        if (contaOrdem.getSaldo().compareTo(valor) > 3000) {
            int depositosAcimaDe3000 = contaOrdem.getDepositosAcimaDe3000();

            
            if (depositosAcimaDe3000 >= 5) {
                
            	
                contaOrdem.setLimiteCredito(new BigDecimal("30000"));
                contaRepository.save(contaOrdem);
            }
        }
    }
}
