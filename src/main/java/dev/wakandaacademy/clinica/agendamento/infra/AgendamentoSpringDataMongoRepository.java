package dev.wakandaacademy.clinica.agendamento.infra;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import dev.wakandaacademy.clinica.agendamento.domain.Agendamento;

public interface AgendamentoSpringDataMongoRepository extends MongoRepository<Agendamento, UUID>{
	Optional<Agendamento> findByIdPaciente(UUID idPaciente);
	List<Agendamento> findAllByIdPaciente(UUID idPaciente);
	List<Agendamento> findAllByIdMedico(UUID idMedico);
}
