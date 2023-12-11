package dev.wakandaacademy.clinica.medico.application.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import dev.wakandaacademy.clinica.medico.domain.Medico;

public interface MedicoRepository {
	Medico salvaMedico(Medico medico);
	List<Medico> buscaMedicos();
	Optional<Medico> buscaMeditoPorId(UUID idMedico);
}
