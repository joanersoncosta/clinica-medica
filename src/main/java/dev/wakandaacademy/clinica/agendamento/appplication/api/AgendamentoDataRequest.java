package dev.wakandaacademy.clinica.agendamento.appplication.api;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class AgendamentoDataRequest {
	@NotNull(message = "Campo data é obrigatório.")
	private String dataConsulta;
}
