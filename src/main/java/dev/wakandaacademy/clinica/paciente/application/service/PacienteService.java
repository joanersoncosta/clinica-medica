package dev.wakandaacademy.clinica.paciente.application.service;

import dev.wakandaacademy.clinica.paciente.application.api.PacienteIdResponse;
import dev.wakandaacademy.clinica.paciente.application.api.PacienteNovoRequest;

public interface PacienteService {
	PacienteIdResponse criaNovoPaciente(PacienteNovoRequest pacienteRequest);
}
