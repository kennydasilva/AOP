package com.banco.internetbanking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.internetbanking.model.Cliente;
import com.banco.internetbanking.repository.ClienteRepository;

@Service
public class ClientService {
	
	 @Autowired
	    private ClienteRepository clienteRepository;

	    public void cadastrarCliente(Cliente cliente) {
	    	
	        if (clienteRepository.existsByEmail(cliente.getEmail())) {
	            throw new RuntimeException("Email já cadastrado.");
	        }

	      
	        clienteRepository.save(cliente);
	    }

}
