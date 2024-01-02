package dev.wakandaacademy.clinica.agendamento.appplication.api;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import dev.wakandaacademy.clinica.agendamento.domain.Agendamento;
import dev.wakandaacademy.clinica.agendamento.domain.enuns.StatusAgendamento;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class AgendamentoListResponse {
	private UUID idAgendamento;
	private UUID idPaciente;
	private UUID idMedico;
	private UUID idEspecialidade;
	private String paciente;
	private String medico;
	private String especialidade;
	private StatusAgendamento statusAgendamento;
	private LocalDate dataConsulta;
	private LocalTime horario;
	
	public AgendamentoListResponse(Agendamento agendamento) {
		this.idAgendamento = agendamento.getIdAgendamento();
		this.idPaciente = agendamento.getIdPaciente();
		this.idMedico = agendamento.getIdMedico();
		this.idEspecialidade = agendamento.getIdEspecialidade();
		this.paciente = agendamento.getPaciente();
		this.medico = agendamento.getMedico();
		this.especialidade = agendamento.getEspecialidade();
		this.statusAgendamento = agendamento.getStatusAgendamento();
		this.dataConsulta = agendamento.getDataConsulta();
		this.horario = agendamento.getHorario();
	}

	public static List<AgendamentoListResponse> converte(List<Agendamento> agendamentos) {
		return agendamentos.stream()
				.map(AgendamentoListResponse::new)
				.collect(Collectors.toList());
	}

}
