package dev.wakandaacademy.clinica.paciente.application.service;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import dev.wakandaacademy.clinica.handler.APIException;
import dev.wakandaacademy.clinica.paciente.application.api.PacienteCriadoResponse;
import dev.wakandaacademy.clinica.paciente.application.api.PacienteIdResponse;
import dev.wakandaacademy.clinica.paciente.application.api.PacienteNovoRequest;
import dev.wakandaacademy.clinica.paciente.application.respository.PacienteRepository;
import dev.wakandaacademy.clinica.paciente.domain.Paciente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class PacienteApplicatioService implements PacienteService {
	private final PacienteRepository pacienteRepository;

	@Override
	public PacienteIdResponse criaNovoPaciente(PacienteNovoRequest pacienteRequest) {
		log.info("[inicia] PacienteApplicatioService - criaNovoPaciente");
		Paciente paciente = pacienteRepository.salvaPaciente(new Paciente(pacienteRequest));
		log.info("[finaliza] PacienteApplicatioService - criaNovoPaciente");
		return PacienteIdResponse.builder().idPaciente(paciente.getIdPaciente()).build();
	}

	@Override
	public PacienteCriadoResponse buscaPacientePorId(UUID idPaciente) {
		log.info("[inicia] PacienteApplicatioService - buscaPacientePorId");
		log.info("[idPaciente] {}", idPaciente);
		PacienteCriadoResponse pacienteResponse = pacienteRepository.buscaPacientePorId(idPaciente)
				.map(PacienteCriadoResponse::convertePacienteParaResponse)
				.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Paciente não encontrado!"));
		log.info("[finaliza] PacienteApplicatioService - buscaPacientePorId");
		return pacienteResponse;
	}

	@Override
	public Paciente buscaPacientePorEmail(String email) {
		log.info("[inicia] PacienteApplicatioService - buscaPacientePorEmail");
		log.info("[emailPaciente] {}", email);
		Paciente paciente = pacienteRepository.buscaPacientePorEmail(email).orElseThrow(() -> 
		APIException.build(HttpStatus.NOT_FOUND, "Paciente não encontrado!"));
		log.info("[finaliza] PacienteApplicatioService - buscaPacientePorEmail");
		return paciente;
	}
}
