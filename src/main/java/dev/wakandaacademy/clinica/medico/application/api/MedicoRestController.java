package dev.wakandaacademy.clinica.medico.application.api;

import org.springframework.web.bind.annotation.RestController;

import dev.wakandaacademy.clinica.medico.application.service.MedicoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequiredArgsConstructor
@Log4j2
public class MedicoRestController implements MedicoAPI {
	private final MedicoService medicoService;
	
	@Override
	public MedicoIdResponse postNovoMedico(MedicoNovoRequest medicoNovoRequest) {
		log.info("[inicia] MedicoRestController - postNovoMedico");
		MedicoIdResponse medicoCriado = medicoService.postNovoMedico(medicoNovoRequest);
		log.info("[finaliza] MedicoRestController - postNovoMedico");
		return medicoCriado;
	}
}
