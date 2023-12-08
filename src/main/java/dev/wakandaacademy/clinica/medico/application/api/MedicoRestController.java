package dev.wakandaacademy.clinica.medico.application.api;

import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequiredArgsConstructor
@Log4j2
public class MedicoRestController implements MedicoAPI {

	@Override
	public MedicoIdResponse postNovoMedico(@Valid MedicoNovoRequest medicoNovoRequest) {
		log.info("[inicia] MedicoRestController - postNovoMedico");
		log.info("[finaliza] MedicoRestController - postNovoMedico");
		return null;
	}

}
