package dev.wakandaacademy.clinica.paciente.infra;

import java.util.Optional;
import java.util.UUID;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import dev.wakandaacademy.clinica.handler.APIException;
import dev.wakandaacademy.clinica.paciente.application.respository.PacienteRepository;
import dev.wakandaacademy.clinica.paciente.domain.Paciente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class PacienteInfraRepository implements PacienteRepository {
	private final PacienteSpringDBMongoRepository pacienteSpringDBMongoRepository;

	@Override
	public Paciente salvaPaciente(Paciente paciente) {
		try {

			log.info("[inicia] PacienteInfraRepository - salvaPaciente");
			pacienteSpringDBMongoRepository.save(paciente);
			log.info("[finaliza] PacienteInfraRepository - salvaPaciente");
		} catch (DataIntegrityViolationException ex) {
			throw APIException.build(HttpStatus.BAD_REQUEST, "Paciente já cadastrado.");
		}
		return paciente;
	}

	@Override
	public Optional<Paciente> buscaPacientePorId(UUID idPaciente) {
		log.info("[inicia] PacienteInfraRepository - buscaPacientePorId");
		Optional<Paciente> paciente = pacienteSpringDBMongoRepository.findById(idPaciente);
		log.info("[finaliza] PacienteInfraRepository - buscaPacientePorId");
		return paciente;
	}

	@Override
	public Optional<Paciente> buscaPacientePorEmail(String email) {
		log.info("[inicia] PacienteInfraRepository - buscaPacientePorEmail");
		Optional<Paciente> paciente = pacienteSpringDBMongoRepository.findByEmail(email);
		log.info("[finaliza] PacienteInfraRepository - buscaPacientePorEmail");
		return paciente;
	}
}
