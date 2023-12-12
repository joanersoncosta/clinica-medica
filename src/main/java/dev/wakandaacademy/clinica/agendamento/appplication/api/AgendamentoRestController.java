package dev.wakandaacademy.clinica.agendamento.appplication.api;

import org.springframework.web.bind.annotation.RestController;

import dev.wakandaacademy.clinica.agendamento.appplication.service.AgendamentoService;
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

}
