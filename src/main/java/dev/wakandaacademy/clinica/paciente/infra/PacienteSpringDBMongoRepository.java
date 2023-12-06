package dev.wakandaacademy.clinica.paciente.infra;

import org.springframework.data.mongodb.repository.MongoRepository;

import dev.wakandaacademy.clinica.paciente.domain.Paciente;

public interface PacienteSpringDBMongoRepository extends MongoRepository<Paciente, String>{

}
