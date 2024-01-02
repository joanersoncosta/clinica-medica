package dev.wakandaacademy.clinica.agendamento.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.HttpStatus;

import dev.wakandaacademy.clinica.agendamento.appplication.api.AgendamentoMedico;
import dev.wakandaacademy.clinica.agendamento.domain.enuns.StatusAgendamento;
import dev.wakandaacademy.clinica.handler.APIException;
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
	private LocalDateTime  dataMomentoCriacao;
	
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
		this.dataMomentoCriacao = LocalDateTime.now();
		validaDataAgendamento(consultas.getDataConsulta());
	}

	public void verificaAgendamentoMedico(List<AgendamentoMedico> agendamentosMedico) {
		for (AgendamentoMedico agenda : agendamentosMedico) {
			if (agenda.getDataConsulta().equals(dataConsulta) && agenda.getHorario().equals(horario)) {
				throw APIException.build(HttpStatus.BAD_REQUEST, "Médico já possui consulta para esse hórario!!");
			}
		}
	}

	public void pertencePaciente(Paciente paciente) {
		if (!idPaciente.equals(paciente.getIdPaciente())) {
			throw APIException.build(HttpStatus.UNAUTHORIZED, "Paciente não autorizado!");
		}
	}

	public void pertenceMedico(Paciente paciente) {
		if (!idPaciente.equals(paciente.getIdPaciente())) {
			throw APIException.build(HttpStatus.UNAUTHORIZED, "Médico não autorizado!");
		}
	}
	
	private void validaDataAgendamento(LocalDate dataConsulta) {
		if(dataConsulta.isBefore(dataMomentoCriacao.toLocalDate())) {
			throw APIException.build(HttpStatus.BAD_REQUEST, "A data selecionada está no passado. Por favor, escolha uma data futura");
		}
	}

}
