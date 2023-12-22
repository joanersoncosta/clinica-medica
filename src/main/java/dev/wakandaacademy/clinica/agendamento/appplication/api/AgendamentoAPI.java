package dev.wakandaacademy.clinica.agendamento.appplication.api;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.wakandaacademy.clinica.agendamento.domain.AgendamentoPaciente;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/agendamento")
public interface AgendamentoAPI {
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	AgendamentoIdResponse postAgendamento(@RequestBody @Valid AgendamentoRequest agendamento);

	@GetMapping(path = "/paciente/{IdPaciente}")
	@ResponseStatus(code = HttpStatus.OK)
	List<AgendamentoPaciente> buscaAgendamentosIdPaciente(@PathVariable(name = "IdPaciente") UUID IdPaciente);
}
