package dev.wakandaacademy.clinica.agendamento.appplication.api;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import dev.wakandaacademy.clinica.agendamento.domain.Agendamento;
import dev.wakandaacademy.clinica.especialidade.application.api.EspecialidadeListResponse;
import dev.wakandaacademy.clinica.especialidade.application.api.EspecialidadeTitloRequest;
import lombok.Getter;

@Getter
public class AgendamentoNomePacienteListResponse {
	private UUID idPaciente;
	private String nome;

	public AgendamentoNomePacienteListResponse(Agendamento agendamento) {
		this.idPaciente = agendamento.getIdPaciente();
		this.nome = agendamento.getPaciente();
	}

	public static List<AgendamentoNomePacienteListResponse> converte(List<Agendamento> agendamentos, NomePacienteRequest nomePaciente ) {
		return agendamentos.stream()
                .filter(n -> n.getPaciente().toLowerCase().contains(nomePaciente.getNome().toLowerCase()))				
                .map(AgendamentoNomePacienteListResponse::new)
				.collect(Collectors.toList());
	}

}
