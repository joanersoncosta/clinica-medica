package dev.wakandaacademy.clinica.agendamento.appplication.api;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class EditaAgendamentoRequest {
	@NotNull
	private UUID idMedico;
	@NotNull
	private UUID idPaciente;
	@NotNull
	private UUID idHorario;
	@NotNull
	private String dataConsulta;
}
