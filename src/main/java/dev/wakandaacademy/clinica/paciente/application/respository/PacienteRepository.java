package dev.wakandaacademy.clinica.paciente.application.respository;

import dev.wakandaacademy.clinica.paciente.domain.Paciente;

public interface PacienteRepository {
	Paciente salvaPaciente(Paciente paciente);
}
