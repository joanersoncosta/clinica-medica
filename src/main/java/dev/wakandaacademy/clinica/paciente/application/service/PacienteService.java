package dev.wakandaacademy.clinica.paciente.application.service;

import java.util.UUID;

import dev.wakandaacademy.clinica.paciente.application.api.PacienteCriadoResponse;
import dev.wakandaacademy.clinica.paciente.application.api.PacienteIdResponse;
import dev.wakandaacademy.clinica.paciente.application.api.PacienteNovoRequest;
import dev.wakandaacademy.clinica.paciente.domain.Paciente;

public interface PacienteService {
	PacienteIdResponse criaNovoPaciente(PacienteNovoRequest pacienteRequest);
	PacienteCriadoResponse buscaPacientePorId(UUID idPaciente);
	Paciente buscaPacientePorEmail(String email);
	Paciente detalhaPacientePorId(UUID idPaciente);
}
