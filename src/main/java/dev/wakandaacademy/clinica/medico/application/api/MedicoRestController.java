package dev.wakandaacademy.clinica.medico.application.api;

import java.util.List;
import java.util.UUID;

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

	@Override
	public MedicoCriadoResponse buscaMedicoPorId(UUID idMedico) {
		log.info("[inicia] MedicoRestController - buscaMedicoPorId");
		MedicoCriadoResponse medicoResponse = medicoService.buscaMedicoPorId(idMedico);
		log.info("[finaliza] MedicoRestController - buscaMedicoPorId");
		return medicoResponse;
	}

	@Override
	public void patchAlteraMedico(UUID idMedico, String email, MedicoAlteracaoRequest postagemAlteracaoRequest) {
		log.info("[inicia] MedicoRestController - patchAlteraMedico");
		medicoService.alteraDadosMedico(idMedico, email, postagemAlteracaoRequest);
		log.info("[finaliza] MedicoRestController - patchAlteraMedico");
	}

	@Override
	public void deletaMedicoPorId(UUID idMedico, String email) {
		log.info("[inicia] MedicoRestController - deletaMedico");
		medicoService.deletaMedicoPorId(idMedico, email);
		log.info("[finaliza] MedicoRestController - deletaMedico");
	}
	
	@Override
	public void cadastraEspecialidadeMedico(UUID idMedico, UUID idEspecialidade, String email) {
		log.info("[inicia] MedicoRestController - cadastraEspecialidadeMedico");
		medicoService.cadastraEspecialidadeMedico(idMedico, idEspecialidade, email);
		log.info("[finaliza] MedicoRestController - cadastraEspecialidadeMedico");
	}

}
