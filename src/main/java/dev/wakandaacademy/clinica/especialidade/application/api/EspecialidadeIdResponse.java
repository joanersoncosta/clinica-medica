package dev.wakandaacademy.clinica.especialidade.application.api;

import java.util.UUID;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class EspecialidadeIdResponse {
	private UUID idEspecialidade;
}
