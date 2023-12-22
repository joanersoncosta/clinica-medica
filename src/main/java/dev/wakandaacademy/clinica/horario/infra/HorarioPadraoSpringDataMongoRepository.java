package dev.wakandaacademy.clinica.horario.infra;

import java.time.LocalTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import dev.wakandaacademy.clinica.horario.domain.HorarioPadrao;

public interface HorarioPadraoSpringDataMongoRepository extends MongoRepository<HorarioPadrao, UUID>{
	Optional<HorarioPadrao> findByHorario(LocalTime horario);
}
