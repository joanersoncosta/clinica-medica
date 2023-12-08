package dev.wakandaacademy.clinica.medico.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/public/v1/medico")
public interface MedicoAPI {
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	MedicoIdResponse postNovoMedico(@RequestBody @Valid MedicoNovoRequest medicoNovoRequest);

}
