package com.banco.internetbanking.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.banco.internetbanking.model.Cliente;
import com.banco.internetbanking.model.Conta;
import com.banco.internetbanking.model.ContaAOrdem;
import com.banco.internetbanking.model.ContaAPrazo;
import com.banco.internetbanking.repository.ClienteRepository;
import com.banco.internetbanking.repository.ContaRepository;
import com.banco.internetbanking.service.ContaService;



@Controller
public class ContaController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ContaRepository contaRepository;
	
	@Autowired
    private ContaService contaService;
	
	@GetMapping("/Addconta")
	public String mostrarFormularioConta(@RequestParam("email") String email, Model model) {
	    model.addAttribute("email", email);
	    model.addAttribute("conta", new ContaAPrazo());
	    return "Addconta";
	}

	
	 @PostMapping("/Addconta")
	    public String salvarConta(
	            @RequestParam("tipoConta") String tipoConta,
	            @RequestParam("saldo") BigDecimal saldo,
	            @RequestParam(value = "dataVencimento", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataVencimento,
	            @RequestParam(value = "juros", required = false) Double juros,
	            @RequestParam(value = "limiteCredito", required = false) BigDecimal limiteCredito,
	            @RequestParam(value = "email", required = true) String email
	            
	    ) {
		    
		 Cliente cliente=clienteRepository.findByEmail(email);
		 
		 List<Conta> conta1=contaRepository.findAll();
		 
		 int numero=1+conta1.size();
		 
		String numeroConta=String.valueOf(numero);
		 
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
	 
	 
	 @GetMapping("/deposito")
		public String mostrarFormulariodeposito(Model model) {
		   
		    model.addAttribute("conta", new ContaAPrazo());
		    
		    return "deposito";
		}
	 
	 @PostMapping("/deposito")
	 public String depositar(
	         String numeroConta,
	         BigDecimal valor,
	         Model model) {
	     try {
	         Conta conta = contaRepository.findByNumeroConta(numeroConta);
	         contaService.realizarDeposito(valor,conta.getId());

	         model.addAttribute("mensagem", "Depósito realizado com sucesso!");
	         
	         return "deposito";

	     } catch (Exception e) {
	         model.addAttribute("erro", e.getMessage());
	         return "deposito";
	     }
	 }
	 
	 
	 
	 @GetMapping("/levantar")
		public String mostrarFormulariolevantar(Model model) {
		   
		    model.addAttribute("conta", new ContaAPrazo());
		    
		    return "levantar";
		}
	 
	 @PostMapping("/levantar")
	 public String levantar(
			 
	         String numeroConta,
	         BigDecimal valor,
	         Model model) {
	     try {
	         Conta conta = contaRepository.findByNumeroConta(numeroConta);
	         
	         contaService.realizarLevantamento(valor,conta.getId());

	         model.addAttribute("mensagem", "Levantamento realizado com sucesso!");
	         
	         return "levantar";

	     } catch (Exception e) {
	         model.addAttribute("erro", e.getMessage());
	         return "levantar";
	     }
	 }
	 
	 
	 
	 @GetMapping("/transferir")
		public String mostrarFormularioTransferir(Model model) {
		   
		    model.addAttribute("conta", new ContaAPrazo());
		    
		    return "transferir";
		}
	 
	 @PostMapping("/transferir")
	 public String transferir(
			 
	         String numeroOrigem,
	         String numeroDestino,
	         BigDecimal valor,
	         Model model) {
	     try {
	         Conta contaOrigem = contaRepository.findByNumeroConta(numeroOrigem);
	         Conta contaDestino = contaRepository.findByNumeroConta(numeroDestino);
	         
	         contaService.realizarTransferencia(valor,contaOrigem.getId(),contaDestino.getId());

	         model.addAttribute("mensagem", "Transferencia realizada com sucesso!");
	         
	         return "transferir";

	     } catch (Exception e) {
	         model.addAttribute("erro", e.getMessage());
	         return "transferir";
	     }
	 }


	 	
	 	


}
