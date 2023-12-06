package dev.wakandaacademy.clinica.paciente.application.service;

import org.springframework.stereotype.Service;

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

}
