package dev.wakandaacademy.clinica.paciente.application.service;

import org.springframework.stereotype.Service;

import dev.wakandaacademy.clinica.paciente.application.api.PacienteIdResponse;
import dev.wakandaacademy.clinica.paciente.application.api.PacienteNovoRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class PacienteApplicatioService implements PacienteService {

	@Override
	public PacienteIdResponse criaNovoPaciente(PacienteNovoRequest pacienteRequest) {
		log.info("[inicia] PacienteApplicatioService - criaNovoPaciente");
		
		log.info("[finaliza] PacienteApplicatioService - criaNovoPaciente");
		return null;
	}

}
