package dev.wakandaacademy.clinica.agendamento.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import dev.wakandaacademy.clinica.agendamento.domain.enuns.StatusAgendamento;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Document(collection = "Agendamento")
public class Agendamento {

	@Id
	private UUID idAgendamento;
	@Indexed
	private UUID idPaciente;
	@Indexed
	private UUID idMedico;
	@Indexed
	private UUID idEspecialidade;
	private String paciente;
	private String medico;
	private String especialidade;
	private LocalDate dataConsulta;
	private LocalTime horario;
	@Builder.Default
	private StatusAgendamento statusAgendamento = StatusAgendamento.CONFIRMADO;

	public Agendamento(AgendamentoClienteConsulta consultas) {
		this.idAgendamento = UUID.randomUUID();
		this.idPaciente = consultas.getIdPaciente();
		this.idMedico = consultas.getIdMedico();
		this.idEspecialidade = consultas.getIdEspecialidade();
		this.paciente = consultas.getPaciente();
		this.medico = consultas.getMedico();
		this.especialidade = consultas.getEspecialidade();
		this.dataConsulta = consultas.getDataConsulta();
		this.horario = consultas.getHorario();
		this.statusAgendamento = StatusAgendamento.CONFIRMADO;
	}

}
