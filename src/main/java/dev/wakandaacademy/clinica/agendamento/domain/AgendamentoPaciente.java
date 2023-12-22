package dev.wakandaacademy.clinica.agendamento.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;

import dev.wakandaacademy.clinica.handler.APIException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class AgendamentoPaciente {
	private UUID idMedico;
	private String medico;
	private String especialidade;
	private LocalDate dataConsulta;
	private LocalTime horario;

	public AgendamentoPaciente(Agendamento consulta) {
		this.idMedico = consulta.getIdMedico();
		this.medico = consulta.getMedico();
		this.especialidade = consulta.getEspecialidade();
		this.dataConsulta = consulta.getDataConsulta();
		this.horario = consulta.getHorario();
	}

	public static List<AgendamentoPaciente> converte(List<Agendamento> agendamentos) {
		return agendamentos.stream()
				.map(AgendamentoPaciente::new)
				.collect(Collectors.toList());
	}
	
}
