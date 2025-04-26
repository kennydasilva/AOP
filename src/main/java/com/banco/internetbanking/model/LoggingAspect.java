package com.banco.internetbanking.model;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class LoggingAspect extends Aspect {

    private String mensagemLog;

	public String getMensagemLog() {
		return mensagemLog;
	}

	public void setMensagemLog(String mensagemLog) {
		this.mensagemLog = mensagemLog;
	}
    
    
}
