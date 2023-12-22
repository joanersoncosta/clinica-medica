package dev.wakandaacademy.clinica.agendamento.appplication.api;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class AgendamentoRequest {
	@NotNull
	private UUID idMedico;
	@NotNull
	private UUID idEspecialidade;
	@NotNull
	private String horario;
	@NotNull
	private UUID idPaciente;
	@NotNull
	private String dataConsulta;
}
