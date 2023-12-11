package dev.wakandaacademy.clinica.especialidade.infra;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import dev.wakandaacademy.clinica.especialidade.domain.Especialidade;

public interface EspecialidadeSpringDataMongoRepository extends MongoRepository<Especialidade, UUID> {

}
