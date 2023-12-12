package dev.wakandaacademy.clinica.agendamento.appplication.service;

import dev.wakandaacademy.clinica.agendamento.appplication.api.AgendamentoIdResponse;
import dev.wakandaacademy.clinica.agendamento.appplication.api.AgendamentoRequest;

public interface AgendamentoService {
	AgendamentoIdResponse criaAgendamento(AgendamentoRequest agendamento);

}
