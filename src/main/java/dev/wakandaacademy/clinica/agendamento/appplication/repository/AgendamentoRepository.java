package dev.wakandaacademy.clinica.agendamento.appplication.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import dev.wakandaacademy.clinica.agendamento.domain.Agendamento;

public interface AgendamentoRepository {
	Agendamento salvaAgendamento(Agendamento agendamento);
	Optional<Agendamento> buscaAgendamentoPorId(UUID idAgendamento);
	List<Agendamento> buscaAgendamentos();
	void deletaAgendamento(Agendamento agendamento);
	Optional<Agendamento> buscaAgendamentoporIdPaciente(UUID idPaciente);
	List<Agendamento> buscaAgendamentosIdPaciente(UUID idPaciente);
	List<Agendamento> buscaAgendamentosIdMedico(UUID idMedico);
}
