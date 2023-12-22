package dev.wakandaacademy.clinica.agendamento.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import dev.wakandaacademy.clinica.agendamento.appplication.api.AgendamentoRequest;
import dev.wakandaacademy.clinica.especialidade.domain.Especialidade;
import dev.wakandaacademy.clinica.horario.domain.HorarioPadrao;
import dev.wakandaacademy.clinica.medico.domain.Medico;
import dev.wakandaacademy.clinica.paciente.domain.Paciente;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class AgendamentoClienteConsulta {
	private UUID idPaciente;
	private UUID idMedico;
	private UUID idEspecialidade;
	private String paciente;
	private String medico;
	private String especialidade;
	private LocalDate dataConsulta;
	private LocalTime horario;
	
	public AgendamentoClienteConsulta(AgendamentoRequest agendamentoRequest, Paciente paciente, Medico medico, Especialidade especialidade, HorarioPadrao horario) {
		this.idPaciente = agendamentoRequest.getIdPaciente();
		this.idMedico = agendamentoRequest.getIdMedico();
		this.idEspecialidade = agendamentoRequest.getIdEspecialidade();
		this.paciente = paciente.getNome();
		this.medico = medico.getNome();
		this.especialidade = especialidade.getTitlo();
		this.dataConsulta = LocalDate.parse(agendamentoRequest.getDataConsulta());
		this.horario = horario.getHorario();
	}
	
}
