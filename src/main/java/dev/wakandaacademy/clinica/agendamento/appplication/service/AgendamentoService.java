package dev.wakandaacademy.clinica.agendamento.appplication.service;

import java.util.List;
import java.util.UUID;

import dev.wakandaacademy.clinica.agendamento.appplication.api.AgendamentoIdResponse;
import dev.wakandaacademy.clinica.agendamento.appplication.api.AgendamentoRequest;
import dev.wakandaacademy.clinica.agendamento.domain.Agendamento;
import dev.wakandaacademy.clinica.agendamento.domain.AgendamentoPaciente;

public interface AgendamentoService {
	AgendamentoIdResponse criaAgendamento(AgendamentoRequest agendamento);
	Agendamento buscaAgendamentoporIdPaciente(UUID idPaciente);
	List<AgendamentoPaciente> buscaAgendamentosIdPaciente(UUID idPaciente);
}
