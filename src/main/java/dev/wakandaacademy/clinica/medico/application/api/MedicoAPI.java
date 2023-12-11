package dev.wakandaacademy.clinica.medico.application.api;

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

import jakarta.validation.Valid;

@RestController
@RequestMapping("/public/v1/medico")
public interface MedicoAPI {
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	MedicoIdResponse postNovoMedico(@RequestBody @Valid MedicoNovoRequest medicoNovoRequest);
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	List<MedicoListResponse> buscaMedicos();
	
	@GetMapping(value = "/{idMedico}")
	@ResponseStatus(code = HttpStatus.OK)
	MedicoCriadoResponse buscaMedicoPorId(@PathVariable(value = "idMedico") UUID idMedico);

}
