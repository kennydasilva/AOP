package com.banco.internetbanking.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.internetbanking.model.Conta;
import com.banco.internetbanking.repository.ContaRepository;

import jakarta.transaction.Transactional;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    
    
    
    @Transactional
    public void realizarDeposito(BigDecimal valor, Long contaId) {
      

        Conta conta = contaRepository.findById(contaId)
            .orElseThrow(() -> new RuntimeException("Conta não encontrada"));

        conta.setSaldo(conta.getSaldo().add(valor)); 
        contaRepository.save(conta);
    }
    
    @Transactional
    public void realizarLevantamento(BigDecimal valor, Long contaId) {
       
        Conta conta = contaRepository.findById(contaId)
            .orElseThrow(() -> new RuntimeException("Conta não encontrada"));

       

        conta.setSaldo(conta.getSaldo().subtract(valor)); 
        contaRepository.save(conta);
    }
    
    
    @Transactional
    public void realizarTransferencia(BigDecimal valor, Long contaOrigemId, Long contaDestinoId) {
       

        Conta contaOrigem = contaRepository.findById(contaOrigemId)
            .orElseThrow(() -> new RuntimeException("Conta origem não encontrada"));
        Conta contaDestino = contaRepository.findById(contaDestinoId)
            .orElseThrow(() -> new RuntimeException("Conta destino não encontrada"));

       

        
        contaOrigem.setSaldo(contaOrigem.getSaldo().subtract(valor));
        contaDestino.setSaldo(contaDestino.getSaldo().add(valor));

        contaRepository.save(contaOrigem);
        contaRepository.save(contaDestino);
    }

}
