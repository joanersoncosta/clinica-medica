package dev.wakandaacademy.clinica.paciente.application.api;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequiredArgsConstructor
@Log4j2
public class PacienteRestController implements PacienteAPI {

	@Override
	public PacienteIdResponse postNovoPaciente(PacienteNovoRequest pacienteRequest) {
		log.info("[inicia] PacienteRestController - postNovoPaciente");
		log.info("[finaliza] PacienteRestController - postNovoPaciente");
		return null;
	}
}
