package dev.wakandaacademy.clinica.paciente.infra;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import dev.wakandaacademy.clinica.paciente.domain.Paciente;

public interface PacienteSpringDBMongoRepository extends MongoRepository<Paciente, UUID>{
	Optional<Paciente> findByEmail(String email);
}
