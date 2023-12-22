package dev.wakandaacademy.clinica.medico.domain;

import java.time.LocalDate;

import dev.wakandaacademy.clinica.agendamento.appplication.api.AgendamentoRequest;
import dev.wakandaacademy.clinica.paciente.domain.Paciente;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class MedicoAgendamentoDetalhado {
	private String paciente;
	private LocalDate dataConsulta;

	public MedicoAgendamentoDetalhado(AgendamentoRequest agendamentoRequest, Paciente paciente) {
		this.paciente = paciente.getNome();
		this.dataConsulta = LocalDate.parse(agendamentoRequest.getDataConsulta());
	}

}
