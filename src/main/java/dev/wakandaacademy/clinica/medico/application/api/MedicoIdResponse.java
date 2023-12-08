package dev.wakandaacademy.clinica.medico.application.api;

import java.util.UUID;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MedicoIdResponse {
	private UUID idMedico;
}
