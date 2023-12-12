package dev.wakandaacademy.clinica.agendamento.appplication.api;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class AgendamentoRequest {
	private UUID idEspecialidade;
	private UUID idMedico;
	private UUID idHorario;
	private UUID idPaciente;
	@NotNull
	private LocalDate dataConsulta;
}
