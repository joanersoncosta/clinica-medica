package dev.wakandaacademy.clinica.paciente.application.api;

import java.util.UUID;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PacienteIdResponse {
	private UUID idPaciente;
}
