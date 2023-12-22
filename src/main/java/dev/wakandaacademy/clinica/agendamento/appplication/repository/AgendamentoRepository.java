package dev.wakandaacademy.clinica.agendamento.appplication.repository;

import java.util.Optional;
import java.util.UUID;

import dev.wakandaacademy.clinica.agendamento.domain.Agendamento;

public interface AgendamentoRepository {
	Agendamento salvaAgendamento(Agendamento agendamento);
	Optional<Agendamento> buscaAgendamentoporIdPaciente(UUID idPaciente);
}
