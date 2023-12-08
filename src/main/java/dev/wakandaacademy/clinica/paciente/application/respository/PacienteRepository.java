package dev.wakandaacademy.clinica.paciente.application.respository;

import java.util.Optional;
import java.util.UUID;

import dev.wakandaacademy.clinica.paciente.domain.Paciente;

public interface PacienteRepository {
	Paciente salvaPaciente(Paciente paciente);
	Optional<Paciente> buscaPacientePorId(UUID idPaciente);
}
