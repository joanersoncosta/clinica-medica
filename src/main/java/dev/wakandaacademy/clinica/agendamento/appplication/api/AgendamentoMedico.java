package dev.wakandaacademy.clinica.agendamento.appplication.api;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import dev.wakandaacademy.clinica.agendamento.domain.Agendamento;
import lombok.Getter;

@Getter
public class AgendamentoMedico {
	private UUID idPaciente;
	private String paciente;
	private LocalDate dataConsulta;
	private LocalTime horario;

	public AgendamentoMedico(Agendamento consulta) {
		this.idPaciente = consulta.getIdPaciente();
		this.paciente = consulta.getPaciente();
		this.dataConsulta = consulta.getDataConsulta();
		this.horario = consulta.getHorario();
	}

	public static List<AgendamentoMedico> converte(List<Agendamento> agendamentos) {
		return agendamentos.stream()
				.map(AgendamentoMedico::new)
				.collect(Collectors.toList());
	}
}
