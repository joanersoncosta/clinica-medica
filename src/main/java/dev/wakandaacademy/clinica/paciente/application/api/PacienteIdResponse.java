package dev.wakandaacademy.clinica.paciente.application.api;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PacienteIdResponse {
	private String idPaciente;
}
