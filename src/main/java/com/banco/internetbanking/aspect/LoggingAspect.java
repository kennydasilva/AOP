package com.banco.internetbanking.aspect;

import com.banco.internetbanking.service.ClientService;




import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.banco.internetbanking.service.ClientService.cadastrarCliente(..))")
    public void logAntesCadastro(JoinPoint joinPoint) {
        logger.info("Tentando cadastrar cliente: " + joinPoint.getArgs()[0]);
    }

    @AfterReturning("execution(* com.banco.internetbanking.service.ClientService.cadastrarCliente(..))")
    public void logSucessoCadastro(JoinPoint joinPoint) {
        logger.info("Cadastro realizado com sucesso para: " + joinPoint.getArgs()[0]);
    }

    @AfterThrowing(pointcut = "execution(* com.banco.internetbanking.service.ClientService.cadastrarCliente(..))", throwing = "ex")
    public void logErroCadastro(JoinPoint joinPoint, Exception ex) {
        logger.error("Erro ao cadastrar cliente: " + joinPoint.getArgs()[0] + ". Erro: " + ex.getMessage());
    }
}

