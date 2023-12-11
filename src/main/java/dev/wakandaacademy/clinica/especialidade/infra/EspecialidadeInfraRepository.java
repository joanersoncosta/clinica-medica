package dev.wakandaacademy.clinica.especialidade.infra;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import dev.wakandaacademy.clinica.especialidade.application.repository.EspecialidadeRepository;
import dev.wakandaacademy.clinica.especialidade.domain.Especialidade;
import dev.wakandaacademy.clinica.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class EspecialidadeInfraRepository implements EspecialidadeRepository {
	private final EspecialidadeSpringDataMongoRepository especialidadeSpringDataMongoRepository;

	@Override
	public Especialidade salvaEspecialidade(Especialidade especialidade) {
		try {
			log.info("[inicia] EspecialidadeInfraRepository - salvaEspecialidade");
			especialidadeSpringDataMongoRepository.save(especialidade);
			log.info("[finaliza] EspecialidadeInfraRepository - salvaEspecialidade");
		} catch (DataIntegrityViolationException ex) {
			throw APIException.build(HttpStatus.BAD_REQUEST, "Especialidade já cadastrada");
		}
		return especialidade;
	}

	@Override
	public List<Especialidade> listaEspecialidade() {
		log.info("[inicia] EspecialidadeInfraRepository - listaEspecialidade");
		List<Especialidade> especialidades = especialidadeSpringDataMongoRepository.findAll();
		log.info("[finaliza] EspecialidadeInfraRepository - listaEspecialidade");
		return especialidades;
	}

}
