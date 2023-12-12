package dev.wakandaacademy.clinica.agendamento.domain;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import dev.wakandaacademy.clinica.horario.domain.HorarioPadrao;
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
	private Set<MedicoAgendamentoHorario> horariosConsulta;

	public Agendamento(UUID idEspecialidade, UUID idMedico, UUID idHorario, UUID idPaciente, LocalDate dataConsulta) {
		this.idAgendamento = UUID.randomUUID();
		this.idEspecialidade = idEspecialidade;
		this.idMedico = idMedico;
		this.idHorario = idHorario;
		this.idPaciente = idPaciente;
		this.dataConsulta = dataConsulta;
		horariosConsulta = new HashSet<>();
	}

}
