package dev.wakandaacademy.clinica.agendamento.appplication.api;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import dev.wakandaacademy.clinica.agendamento.appplication.service.AgendamentoService;
import dev.wakandaacademy.clinica.agendamento.domain.AgendamentoPaciente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequiredArgsConstructor
@Log4j2
public class AgendamentoRestController implements AgendamentoAPI {
	private final AgendamentoService agendamentoService;

	@Override
	public AgendamentoIdResponse postAgendamento(AgendamentoRequest agendamento) {
		log.info("[inicia] AgendamentoRestController - postAgendamento");
		AgendamentoIdResponse idAgendamento = agendamentoService.criaAgendamento(agendamento);
		log.info("[finaliza] AgendamentoRestController - postAgendamento");
		return idAgendamento;
	}

	@Override
	public List<AgendamentoPaciente> buscaAgendamentosIdPaciente(UUID IdPaciente) {
		log.info("[inicia] AgendamentoRestController - buscaAgendamentosIdPaciente");
		List<AgendamentoPaciente> agendamentos = agendamentoService.buscaAgendamentosIdPaciente(IdPaciente);
		log.info("[finaliza] AgendamentoRestController - buscaAgendamentosIdPaciente");
		return agendamentos;
	}

}
