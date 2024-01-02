package dev.wakandaacademy.clinica.agendamento.appplication.api;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
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

	@GetMapping(path = "/medico/{IdMedico}")
	@ResponseStatus(code = HttpStatus.OK)
	List<AgendamentoMedico> buscaAgendamentosIdMedico(@PathVariable(name = "IdMedico") UUID IdMedico);

	@GetMapping(path = "/paciente/{IdPaciente}/data")
	@ResponseStatus(code = HttpStatus.OK)
	List<AgendamentoPacienteListResponse> buscaAgendamentosPacientePorData(@RequestBody @Valid AgendamentoDataRequest agendamento, @PathVariable(name = "IdPaciente") UUID IdPaciente);

	@DeleteMapping(path = "/{idAgendamento}/paciente/{IdPaciente}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void deletaAgendamentoPorId(@PathVariable(name = "idAgendamento") UUID idAgendamento, @PathVariable(name = "IdPaciente") UUID IdPaciente);

}
