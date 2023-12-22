package dev.wakandaacademy.clinica.agendamento.domain;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class AgendamentoCliente {
	private String medico;
	private String especialidade;
	private LocalDate dataConsulta;
	private LocalTime horario;

	public AgendamentoCliente(AgendamentoClienteConsulta consulta) {
		this.medico = consulta.getMedico();
		this.especialidade = consulta.getEspecialidade();
		this.dataConsulta = consulta.getDataConsulta();
		this.horario = consulta.getHorario();
	}
}
