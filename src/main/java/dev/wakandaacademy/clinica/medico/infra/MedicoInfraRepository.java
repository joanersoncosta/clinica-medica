package dev.wakandaacademy.clinica.medico.infra;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import dev.wakandaacademy.clinica.handler.APIException;
import dev.wakandaacademy.clinica.medico.application.repository.MedicoRepository;
import dev.wakandaacademy.clinica.medico.domain.Medico;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class MedicoInfraRepository implements MedicoRepository {
	private final MedicoSpringDataMongoRepository medicoSpringDataMongoRepository;
	
	@Override
	public Medico salvaMedico(Medico medico) {
		try {
			log.info("[inicia] MedicoInfraRepository - salvaMedico");
			medicoSpringDataMongoRepository.save(medico);
			log.info("[finaliza] MedicoInfraRepository - salvaMedico");
		}catch (DataIntegrityViolationException ex) {
			throw APIException.build(HttpStatus.BAD_REQUEST, "Médico já cadastrado");
		}
		return medico;
	}

	@Override
	public List<Medico> buscaMedicos() {
			log.info("[inicia] MedicoInfraRepository - buscaMedicos");
			List<Medico> medicos = medicoSpringDataMongoRepository.findAll();
			log.info("[finaliza] MedicoInfraRepository - buscaMedicos");
		return medicos;
	}

	@Override
	public Optional<Medico> buscaMeditoPorId(UUID idMedico) {
		log.info("[inicia] MedicoInfraRepository - buscaMedicos");
		Optional<Medico> medico = medicoSpringDataMongoRepository.findById(idMedico);
		log.info("[finaliza] MedicoInfraRepository - buscaMedicos");
		return medico;
	}

	@Override
	public Optional<Medico> buscaMeditoPorEmail(String emailMedico) {
		log.info("[inicia] MedicoInfraRepository - buscaMeditoPorEmail");
		Optional<Medico> medico = medicoSpringDataMongoRepository.findByEmail(emailMedico);
		log.info("[finaliza] MedicoInfraRepository - buscaMeditoPorEmail");
		return medico;
	}

}
