package dev.wakandaacademy.clinica.paciente.application.api;

import org.springframework.web.bind.annotation.RestController;

import dev.wakandaacademy.clinica.paciente.application.service.PacienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequiredArgsConstructor
@Log4j2
public class PacienteRestController implements PacienteAPI {
	private final PacienteService pacienteService;
	@Override
	public PacienteIdResponse postNovoPaciente(PacienteNovoRequest pacienteRequest) {
		log.info("[inicia] PacienteRestController - postNovoPaciente");
		PacienteIdResponse pacienteId = pacienteService.criaNovoPaciente(pacienteRequest);
		log.info("[finaliza] PacienteRestController - postNovoPaciente");
		return pacienteId;
	}
}
