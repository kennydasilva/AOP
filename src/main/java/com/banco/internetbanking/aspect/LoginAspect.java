package com.banco.internetbanking.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.banco.internetbanking.model.Cliente;
import com.banco.internetbanking.repository.ClienteRepository;

@Aspect
@Component
public class LoginAspect {

    @Autowired
    private ClienteRepository clienteRepository;

    @AfterThrowing(pointcut = "execution(* com.banco.internetbanking.service.LoginService.autenticar(..))", throwing = "ex")
    public void controlarTentativasFalhas(JoinPoint joinPoint, Throwable ex) {
    	
        Object[] args = joinPoint.getArgs();
        String email = (String) args[0];

        Cliente cliente = clienteRepository.findByEmail(email);
        
        if (cliente != null) {
        	
            int tentativas = cliente.getTentativasFalha() + 1;

            if (tentativas >= 5) {
            	
                cliente.setBloqueado(true);
                cliente.setTentativasFalha(0);
                
                System.out.println("Conta bloqueada por 5 tentativas inválidas: " + email);
            } else {
            	
                cliente.setTentativasFalha(tentativas);
                
                System.out.println("Tentativa falhada de login (" + tentativas + ") para: " + email);
            }

            clienteRepository.save(cliente);
        }
    }
    
    
    @AfterReturning(pointcut = "execution(* com.banco.internetbanking.service.LoginService.autenticar(..))", returning = "retorno")
    public void resetarTentativasAposLogin(JoinPoint joinPoint, Object retorno) {
        Cliente cliente = (Cliente) retorno;
        cliente.setTentativasFalha(0);
        clienteRepository.save(cliente);
    }
}
