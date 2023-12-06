package dev.wakandaacademy.clinica.paciente.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/public/v1/paciente")
public interface PacienteAPI {
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	PacienteIdResponse postNovoPaciente(@RequestBody @Valid PacienteNovoRequest pacienteRequest);

	@GetMapping(value = "/{idPaciente}")
	@ResponseStatus(code = HttpStatus.OK)
	PacienteCriadoResponse buscaPacientePorId(@PathVariable(value = "idPaciente") String idPaciente);

}
