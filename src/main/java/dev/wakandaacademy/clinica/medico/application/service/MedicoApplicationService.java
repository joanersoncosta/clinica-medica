package dev.wakandaacademy.clinica.medico.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.wakandaacademy.clinica.credencial.application.service.CredencialService;
import dev.wakandaacademy.clinica.medico.application.api.MedicoIdResponse;
import dev.wakandaacademy.clinica.medico.application.api.MedicoListResponse;
import dev.wakandaacademy.clinica.medico.application.api.MedicoNovoRequest;
import dev.wakandaacademy.clinica.medico.application.repository.MedicoRepository;
import dev.wakandaacademy.clinica.medico.domain.Medico;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class MedicoApplicationService implements MedicoService {
	private final CredencialService credencialService;
	private final MedicoRepository medicoRepository;

	@Override
	public MedicoIdResponse postNovoMedico(MedicoNovoRequest medicoNovoRequest) {
		log.info("[inicia] MedicoApplicationService - postNovoMedico");
		Medico medico = medicoRepository.salvaMedico(new Medico(medicoNovoRequest));
		credencialService.salvaCredencialMedico(medicoNovoRequest);
		log.info("[finaliza] MedicoApplicationService - postNovoMedico");
		return MedicoIdResponse.builder().idMedico(medico.getIdMedico()).build();
	}

	@Override
	public List<MedicoListResponse> buscaMedicos() {
		log.info("[inicia] MedicoApplicationService - buscaMedicos");
		List<Medico> medicos = medicoRepository.buscaMedicos();
		log.info("[finaliza] MedicoApplicationService - buscaMedicos");
		return MedicoListResponse.converte(medicos);
	}

}
