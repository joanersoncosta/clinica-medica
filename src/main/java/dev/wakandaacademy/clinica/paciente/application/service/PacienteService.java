package dev.wakandaacademy.clinica.paciente.application.service;

import java.util.UUID;

import dev.wakandaacademy.clinica.paciente.application.api.PacienteCriadoResponse;
import dev.wakandaacademy.clinica.paciente.application.api.PacienteIdResponse;
import dev.wakandaacademy.clinica.paciente.application.api.PacienteNovoRequest;

public interface PacienteService {
	PacienteIdResponse criaNovoPaciente(PacienteNovoRequest pacienteRequest);
	PacienteCriadoResponse buscaPacientePorId(UUID idPaciente);
}
