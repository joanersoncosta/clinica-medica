package dev.wakandaacademy.clinica.agendamento.appplication.api;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import dev.wakandaacademy.clinica.agendamento.domain.Agendamento;
import dev.wakandaacademy.clinica.agendamento.domain.enuns.StatusAgendamento;
import lombok.Value;

@Value
public class AgendamentoPacienteListResponse {
	private UUID idMedico;
	private String medico;
	private String especialidade;
	private StatusAgendamento statusAgendamento;
	private LocalDate dataConsulta;
	private LocalTime horario;

	public AgendamentoPacienteListResponse(Agendamento consulta) {
		this.idMedico = consulta.getIdMedico();
		this.medico = consulta.getMedico();
		this.especialidade = consulta.getEspecialidade();
		this.statusAgendamento = consulta.getStatusAgendamento();
		this.dataConsulta = consulta.getDataConsulta();
		this.horario = consulta.getHorario();
	}

	public static List<AgendamentoPacienteListResponse> converte(List<Agendamento> agendamentos,
			AgendamentoDataRequest dataConsulta) {
		return agendamentos.stream()
				.filter(n -> n.getDataConsulta().equals(LocalDate.parse(dataConsulta.getDataConsulta())))
				.map(AgendamentoPacienteListResponse::new)
				.sorted((p1, p2) -> p1.getHorario().compareTo(p2.getHorario()))
				.collect(Collectors.toList());
	}
	
}
