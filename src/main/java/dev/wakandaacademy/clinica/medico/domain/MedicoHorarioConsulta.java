package dev.wakandaacademy.clinica.medico.domain;

import java.time.LocalDate;
import java.time.LocalTime;

import dev.wakandaacademy.clinica.horario.domain.HorarioPadrao;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class MedicoHorarioConsulta {
	private String paciente;
	private LocalDate dataConsulta;
	private LocalTime horario;
	
	public MedicoHorarioConsulta(HorarioPadrao horario, MedicoAgendamentoDetalhado medicoAgendamentoDetalhado) {
		this.paciente = medicoAgendamentoDetalhado.getPaciente();
		this.dataConsulta = medicoAgendamentoDetalhado.getDataConsulta();
		this.horario = horario.getHorario();
	}
	
	
}
