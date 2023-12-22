package dev.wakandaacademy.clinica.agendamento.appplication.api;

import java.util.Date;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class AgendamentoDataRequest {
	private UUID idEspecialidade;
	private UUID idMedico;
	private UUID idHorario;
	@NotNull
	private Date dataConsulta;
}
