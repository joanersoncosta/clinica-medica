package dev.wakandaacademy.clinica.agendamento.domain;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import dev.wakandaacademy.clinica.agendamento.appplication.api.AgendamentoRequest;
import dev.wakandaacademy.clinica.agendamento.domain.enuns.StatusAgendamento;
import jakarta.validation.constraints.NotNull;
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
	private UUID idEspecialidade;
	@Indexed
	private UUID idMedico;
	@Indexed(unique = true)
	private UUID idHorario;
	@Indexed
	private UUID idPaciente;
	@NotNull
	private LocalDate dataConsulta;
	@Builder.Default
	private StatusAgendamento statusAgendamento = StatusAgendamento.ATIVO;

	public Agendamento(AgendamentoRequest agendamento) {
		this.idAgendamento = UUID.randomUUID();
		this.idEspecialidade = agendamento.getIdEspecialidade();
		this.idMedico = agendamento.getIdMedico();
		this.idHorario = agendamento.getIdHorario();
		this.idPaciente = agendamento.getIdPaciente();
		this.dataConsulta = agendamento.getDataConsulta();
		this.statusAgendamento = StatusAgendamento.ATIVO;	}

}
