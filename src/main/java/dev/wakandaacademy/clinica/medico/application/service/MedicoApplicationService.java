package dev.wakandaacademy.clinica.medico.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import dev.wakandaacademy.clinica.credencial.application.service.CredencialService;
import dev.wakandaacademy.clinica.especialidade.application.service.EspecialidadeService;
import dev.wakandaacademy.clinica.especialidade.domain.Especialidade;
import dev.wakandaacademy.clinica.handler.APIException;
import dev.wakandaacademy.clinica.medico.application.api.MedicoAlteracaoRequest;
import dev.wakandaacademy.clinica.medico.application.api.MedicoCriadoResponse;
import dev.wakandaacademy.clinica.medico.application.api.MedicoIdResponse;
import dev.wakandaacademy.clinica.medico.application.api.MedicoListResponse;
import dev.wakandaacademy.clinica.medico.application.api.MedicoNovoRequest;
import dev.wakandaacademy.clinica.medico.application.repository.MedicoRepository;
import dev.wakandaacademy.clinica.medico.domain.MedicaEspecialidadeRequest;
import dev.wakandaacademy.clinica.medico.domain.Medico;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class MedicoApplicationService implements MedicoService {
	private final CredencialService credencialService;
	private final EspecialidadeService especialidadeService;
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

	@Override
	public MedicoCriadoResponse buscaMedicoPorId(UUID idMedico) {
		log.info("[inicia] MedicoApplicationService - buscaMedicoPorId");
		log.info("[idMedico] {idMedico}", idMedico);
		MedicoCriadoResponse medicoResponse = medicoRepository.buscaMeditoPorId(idMedico)
				.map(MedicoCriadoResponse::converteParaResponse)
				.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Médico não encontrado!"));
		log.info("[finaliza] MedicoApplicationService - buscaMedicoPorId");
		return medicoResponse;
	}

	@Override
	public void alteraDadosMedico(UUID idMedico, String emailMedico, MedicoAlteracaoRequest postagemAlteracaoRequest) {
		log.info("[inicia] MedicoApplicationService - alteraDadosMedico");
		log.info("[idMedico] {}", idMedico);
		log.info("[emailMedico] {}", emailMedico);
		Medico medico = medicoRepository.buscaMeditoPorId(idMedico)
				.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Médico não encontrado!"));
		Medico medicoEmail = detalhaMedicoPorEmail(emailMedico);
		medico.pertenceMedico(medicoEmail);
		medico.alteraDados(postagemAlteracaoRequest);
		medicoRepository.salvaMedico(medico);
		log.info("[finaliza] MedicoApplicationService - alteraDadosMedico");
	}

	@Override
	public Medico detalhaMedicoPorEmail(String emailMedico) {
		log.info("[inicia] MedicoApplicationService - detalhaMedicoPorEmail");
		log.info("[emailMedico] {}", emailMedico);
		Medico medico = medicoRepository.buscaMeditoPorEmail(emailMedico)
				.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Médico não encontrado!"));
		
		log.info("[finaliza] MedicoApplicationService - detalhaMedicoPorEmail");
		return medico;
	}

	@Override
	public void deletaMedicoPorId(UUID idMedico, String emailMedico) {
		log.info("[inicia] MedicoApplicationService - alteraDadosMedico");
		log.info("[idMedico] {}", idMedico);
		log.info("[emailMedico] {}", emailMedico);
		Medico medico = medicoRepository.buscaMeditoPorId(idMedico)
				.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Médico não encontrado!"));
		Medico medicoEmail = detalhaMedicoPorEmail(emailMedico);
		medico.pertenceMedico(medicoEmail);
		medicoRepository.deletaMedicoPorId(medico);
		log.info("[finaliza] MedicoApplicationService - alteraDadosMedico");
	}

	@Override
	public void cadastraEspecialidadeMedico(UUID idMedico, UUID idEspecialidade, String emailMedico) {
		log.info("[inicia] MedicoApplicationService - cadastraEspecialidadeMedico");
		log.info("[idMedico] {} [idEspecialidade] {}", idMedico, idEspecialidade);
		log.info("[emailMedico] {}", idEspecialidade);
		Especialidade especialidade = especialidadeService.detalhaEspecialidadePorId(idEspecialidade);
		Medico medico = medicoRepository.buscaMeditoPorId(idMedico)
				.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Médico não encontrado!"));
		Medico medicoEmail = detalhaMedicoPorEmail(emailMedico);
		medico.pertenceMedico(medicoEmail);
		medico.cadastraEspecialidade(new MedicaEspecialidadeRequest(especialidade));
		medicoRepository.salvaMedico(medico);
		especialidadeService.atualizaEspecialidadeMedico(especialidade, medico);
		log.info("[finaliza] MedicoApplicationService - cadastraEspecialidadeMedico");
		
	}

	@Override
	public Medico detalhaMedicoPorId(UUID idMedico) {
		log.info("[inicia] MedicoApplicationService - detalhaMedicoPorId");
		log.info("[idMedico] {idMedico}", idMedico);
		Medico medico = medicoRepository.buscaMeditoPorId(idMedico)
				.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Médico não encontrado!"));
		log.info("[finaliza] MedicoApplicationService - detalhaMedicoPorId");
		return medico;
	}
}
