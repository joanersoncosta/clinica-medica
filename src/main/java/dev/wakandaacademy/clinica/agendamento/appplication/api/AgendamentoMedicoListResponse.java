package dev.wakandaacademy.clinica.agendamento.appplication.api;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import dev.wakandaacademy.clinica.agendamento.domain.Agendamento;
import lombok.Value;

@Value
public class AgendamentoMedicoListResponse {
	private UUID idPaciente;
	private String paciente;
	private LocalDate dataConsulta;
	private LocalTime horario;
	
	public AgendamentoMedicoListResponse(Agendamento agendamento) {
		this.idPaciente = agendamento.getIdPaciente();
		this.paciente = agendamento.getPaciente();
		this.dataConsulta = agendamento.getDataConsulta();
		this.horario = agendamento.getHorario();
	}
	
	public static List<AgendamentoMedicoListResponse> converte(List<Agendamento> agendamentos,
			AgendamentoDataRequest dataConsulta) {
		return agendamentos.stream()
				.filter(n -> n.getDataConsulta().equals(LocalDate.parse(dataConsulta.getDataConsulta())))
				.map(AgendamentoMedicoListResponse::new)
				.sorted((p1, p2) -> p1.getHorario().compareTo(p2.getHorario()))
				.collect(Collectors.toList());
	}

}
