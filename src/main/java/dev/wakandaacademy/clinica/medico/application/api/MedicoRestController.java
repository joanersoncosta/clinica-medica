package dev.wakandaacademy.clinica.medico.application.api;

import java.util.List;

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

	@Override
	public List<MedicoListResponse> buscaMedicos() {
		log.info("[inicia] MedicoRestController - buscaMedicos");
		List<MedicoListResponse> medicoListResponse = medicoService.buscaMedicos();
		log.info("[finaliza] MedicoRestController - buscaMedicos");
		return medicoListResponse;
	}
}
