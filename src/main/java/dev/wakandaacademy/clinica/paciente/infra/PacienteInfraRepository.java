package dev.wakandaacademy.clinica.paciente.infra;


import org.springframework.stereotype.Repository;

import dev.wakandaacademy.clinica.paciente.application.respository.PacienteRepository;
import dev.wakandaacademy.clinica.paciente.domain.Paciente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class PacienteInfraRepository implements PacienteRepository {

	@Override
	public Paciente salvaPaciente(Paciente paciente) {
		log.info("[inicia] PacienteInfraRepository - salvaPaciente");
		log.info("[finaliza] PacienteInfraRepository - salvaPaciente");
		return null;
	}
}
