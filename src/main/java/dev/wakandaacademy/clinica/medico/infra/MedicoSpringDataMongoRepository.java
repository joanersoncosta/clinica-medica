package dev.wakandaacademy.clinica.medico.infra;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import dev.wakandaacademy.clinica.medico.domain.Medico;

public interface MedicoSpringDataMongoRepository extends MongoRepository<Medico, UUID>{

}
