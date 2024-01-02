package dev.wakandaacademy.clinica.agendamento.appplication.service;

import java.util.List;
import java.util.UUID;

import dev.wakandaacademy.clinica.agendamento.appplication.api.AgendamentoDataRequest;
import dev.wakandaacademy.clinica.agendamento.appplication.api.AgendamentoIdResponse;
import dev.wakandaacademy.clinica.agendamento.appplication.api.AgendamentoListResponse;
import dev.wakandaacademy.clinica.agendamento.appplication.api.AgendamentoMedico;
import dev.wakandaacademy.clinica.agendamento.appplication.api.AgendamentoMedicoListResponse;
import dev.wakandaacademy.clinica.agendamento.appplication.api.AgendamentoPacienteListResponse;
import dev.wakandaacademy.clinica.agendamento.appplication.api.AgendamentoRequest;
import dev.wakandaacademy.clinica.agendamento.appplication.api.AgendamentoResponse;
import dev.wakandaacademy.clinica.agendamento.domain.Agendamento;
import dev.wakandaacademy.clinica.agendamento.domain.AgendamentoPaciente;

public interface AgendamentoService {
	AgendamentoIdResponse criaAgendamento(AgendamentoRequest agendamento);
	AgendamentoResponse buscaAgendamentoPorId(UUID idAgendamento);
	List<AgendamentoListResponse> buscaAgendamentos();
	void deletaAgendamentoPorId(UUID idAgendamento, UUID idPaciente);
	Agendamento buscaAgendamentoporIdPaciente(UUID idPaciente);
	List<AgendamentoPaciente> buscaAgendamentosIdPaciente(UUID idPaciente);
	List<AgendamentoMedico> buscaAgendamentosIdMedico(UUID idMedico);
	List<AgendamentoPacienteListResponse> buscaAgendamentosPacientePorData(AgendamentoDataRequest agendamento,
			UUID idPaciente);
	List<AgendamentoMedicoListResponse> buscaAgendamentosMedicoPorData(AgendamentoDataRequest agendamento,
			UUID idMedico);
	void cancelaAgendamentoPorId(UUID idAgendamento, UUID idPaciente);
}
