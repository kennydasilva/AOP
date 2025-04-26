package com.banco.internetbanking.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.banco.internetbanking.model.Cliente;
import com.banco.internetbanking.model.ContaAOrdem;
import com.banco.internetbanking.model.ContaAPrazo;
import com.banco.internetbanking.repository.ClienteRepository;
import com.banco.internetbanking.repository.ContaRepository;



@Controller
public class ContaController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ContaRepository contaRepository;
	
	@GetMapping("/conta/cadastro")
	public String mostrarFormularioCadastro(Model model) {
	    model.addAttribute("conta", new ContaAOrdem());
	    return "cadastroConta";
	}
	
	 @PostMapping("/conta/salvar")
	    public String salvarConta(
	            @RequestParam("tipoConta") String tipoConta,
	            @RequestParam("numeroConta") String numeroConta,
	            @RequestParam("saldo") double saldo,
	            @RequestParam(value = "dataVencimento", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataVencimento,
	            @RequestParam(value = "juros", required = false) Double juros,
	            @RequestParam(value = "limiteCredito", required = false) Double limiteCredito,
	            @RequestParam(value = "email", required = true) String email
	            
	    ) {
		    
		 Cliente cliente=clienteRepository.findByEmail(email);
		 
		 
	        if (tipoConta.equals("prazo")) {
	        	
	            ContaAPrazo conta = new ContaAPrazo();
	            
	            conta.setNumeroConta(numeroConta);
	            conta.setSaldo(saldo);
	            conta.setDataVencimento(dataVencimento);
	            conta.setJuros(juros);
	            conta.setCliente(cliente); 
	            
	            
	            contaRepository.save(conta);
	        } else if (tipoConta.equals("ordem")) {
	        	
	            ContaAOrdem conta = new ContaAOrdem();
	            conta.setNumeroConta(numeroConta);
	            conta.setSaldo(saldo);
	            conta.setLimiteCredito(limiteCredito);
	            conta.setCliente(cliente);
	            
	            contaRepository.save(conta);
	            
	        }

	        return "redirect:/Login";
	    }

}
