package dev.wakandaacademy.clinica.horario.application.api;

import java.util.UUID;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class HorarioPadraoIdResponse {
	private UUID idHorarioPadrao;
}
