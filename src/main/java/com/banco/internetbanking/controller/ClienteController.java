package com.banco.internetbanking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.banco.internetbanking.model.Cliente;
import com.banco.internetbanking.model.ContaAPrazo;
import com.banco.internetbanking.service.ClientService;
import com.banco.internetbanking.service.LoginService;

import org.springframework.ui.Model;


@Controller
public class ClienteController {

	@Autowired
    private ClientService clientService;
	
	@Autowired
    private LoginService loginService;

    @GetMapping("/AddCliente")
    public String mostrarFormulario(Model model) {
    	
        model.addAttribute("cliente", new Cliente());
        return "AddCliente";
    }

    @PostMapping("/AddCliente")
    public String processarCadastro(@ModelAttribute Cliente cliente, Model model) {
        try {
        	clientService.cadastrarCliente(cliente);
        	
            model.addAttribute("mensagem", "Cadastro realizado com sucesso!");
            
            return "redirect:/conta";
            
        } catch (Exception e) {
        	
            model.addAttribute("erro", e.getMessage());
            return "AddCliente";
        }
    
    }
    
    
    @GetMapping("/Login")
    public String mostrarLogin(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "Login";
    }
    
    @PostMapping("/Login")
    public String processarLogin(@RequestParam String email, @RequestParam String senha, Model model) {
        try {
            Cliente clienteLogado = loginService.autenticar(email, senha);
            
            model.addAttribute("mensagem", "Login realizado com sucesso!");
            
            return "redirect:/Dashboard";
        } catch (Exception e) {
        	
            model.addAttribute("erro", e.getMessage());
            return "Login";
        }
    }
    
    @GetMapping("/Dashboard")
    public String mostrardashbord(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "Dashboard";
    }

    
   
    
}
