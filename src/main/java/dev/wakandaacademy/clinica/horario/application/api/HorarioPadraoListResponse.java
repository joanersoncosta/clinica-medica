package dev.wakandaacademy.clinica.horario.application.api;

import java.time.LocalTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import dev.wakandaacademy.clinica.horario.domain.HorarioPadrao;
import lombok.Getter;

@Getter
public class HorarioPadraoListResponse {

	private UUID idHorarioPadrao;
	private LocalTime horario;

	public HorarioPadraoListResponse(HorarioPadrao horario) {
		this.idHorarioPadrao = horario.getIdHorarioPadrao();
		this.horario = horario.getHorario();
	}

	public static List<HorarioPadraoListResponse> converte(List<HorarioPadrao> horarios) {
		return horarios.stream().map(HorarioPadraoListResponse::new).collect(Collectors.toList());
	}

}
