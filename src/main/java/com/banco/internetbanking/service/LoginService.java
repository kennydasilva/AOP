package com.banco.internetbanking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.internetbanking.model.Cliente;
import com.banco.internetbanking.repository.ClienteRepository;

@Service
public class LoginService {
	
	
	@Autowired
    private ClienteRepository clienteRepository;

    public Cliente autenticar(String email, String senha) {
    	
        Cliente cliente = clienteRepository.findByEmail(email);
        
        if (cliente == null || !cliente.getSenha().equals(senha)) {
        	
            throw new RuntimeException("Credenciais inválidas.");
        }

        if (cliente.isBloqueado()) {
        	
            throw new RuntimeException("Conta bloqueada. Contacte o suporte.");
        }

        return cliente;
    }

}
