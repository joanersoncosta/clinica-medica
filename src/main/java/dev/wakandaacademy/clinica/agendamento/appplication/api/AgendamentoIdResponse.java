package dev.wakandaacademy.clinica.agendamento.appplication.api;

import java.util.UUID;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class AgendamentoIdResponse {
	private UUID idEspecialidade;
}
