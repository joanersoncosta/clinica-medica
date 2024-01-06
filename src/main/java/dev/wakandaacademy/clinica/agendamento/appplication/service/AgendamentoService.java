package dev.wakandaacademy.clinica.agendamento.appplication.service;

import java.util.List;
import java.util.UUID;

import dev.wakandaacademy.clinica.agendamento.appplication.api.AgendamentoDataRequest;
import dev.wakandaacademy.clinica.agendamento.appplication.api.AgendamentoIdResponse;
import dev.wakandaacademy.clinica.agendamento.appplication.api.AgendamentoListResponse;
import dev.wakandaacademy.clinica.agendamento.appplication.api.AgendamentoMedico;
import dev.wakandaacademy.clinica.agendamento.appplication.api.AgendamentoMedicoListResponse;
import dev.wakandaacademy.clinica.agendamento.appplication.api.AgendamentoNomePacienteListResponse;
import dev.wakandaacademy.clinica.agendamento.appplication.api.AgendamentoPacienteListResponse;
import dev.wakandaacademy.clinica.agendamento.appplication.api.AgendamentoRequest;
import dev.wakandaacademy.clinica.agendamento.appplication.api.AgendamentoResponse;
import dev.wakandaacademy.clinica.agendamento.appplication.api.EditaAgendamentoRequest;
import dev.wakandaacademy.clinica.agendamento.appplication.api.NomePacienteRequest;
import dev.wakandaacademy.clinica.agendamento.domain.AgendamentoPaciente;
import dev.wakandaacademy.clinica.especialidade.application.api.EspecialidadeTitloRequest;

public interface AgendamentoService {
	AgendamentoIdResponse criaAgendamento(AgendamentoRequest agendamento);
	AgendamentoResponse buscaAgendamentoPorId(UUID idAgendamento);
	List<AgendamentoListResponse> buscaAgendamentos();
	void deletaAgendamentoPorId(UUID idAgendamento, UUID idPaciente);
	void reagendaCunsulta(EditaAgendamentoRequest agendamentorequest, UUID idAgendamento, UUID idPaciente);
	List<AgendamentoPaciente> buscaAgendamentosIdPaciente(UUID idPaciente);
	List<AgendamentoMedico> buscaAgendamentosIdMedico(UUID idMedico);
	List<AgendamentoPacienteListResponse> buscaAgendamentosPacientePorData(AgendamentoDataRequest agendamento,
			UUID idPaciente);
	List<AgendamentoMedicoListResponse> buscaAgendamentosMedicoPorData(AgendamentoDataRequest agendamento,
			UUID idMedico);
	void cancelaAgendamentoPorId(UUID idAgendamento, UUID idPaciente);
	List<AgendamentoNomePacienteListResponse> listaAgendamentoPorNomePaciente(NomePacienteRequest nomePaciente);
}
