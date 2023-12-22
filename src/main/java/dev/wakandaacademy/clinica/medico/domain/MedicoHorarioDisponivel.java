package dev.wakandaacademy.clinica.medico.domain;

import java.time.LocalTime;

import dev.wakandaacademy.clinica.horario.application.api.HorarioPadraoListResponse;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class MedicoHorarioDisponivel {
	private LocalTime horario;

	public MedicoHorarioDisponivel(HorarioPadraoListResponse horario) {
		this.horario = horario.getHorario();
	}
}
