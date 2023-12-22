package dev.wakandaacademy.clinica.agendamento.appplication.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/agendamento")
public interface AgendamentoAPI {
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	AgendamentoIdResponse postAgendamento(@RequestBody @Valid AgendamentoRequest agendamento);
}
