package dev.wakandaacademy.clinica.medico.application.service;

import org.springframework.stereotype.Service;

import dev.wakandaacademy.clinica.medico.application.api.MedicoIdResponse;
import dev.wakandaacademy.clinica.medico.application.api.MedicoNovoRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class MedicoApplicationService implements MedicoService {

	@Override
	public MedicoIdResponse postNovoMedico(MedicoNovoRequest medicoNovoRequest) {
		log.info("[inicia] MedicoApplicationService - postNovoMedico");
		log.info("[finaliza] MedicoApplicationService - postNovoMedico");
			return null;
	}

}
