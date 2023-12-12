package dev.wakandaacademy.clinica.horario.infra;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import dev.wakandaacademy.clinica.handler.APIException;
import dev.wakandaacademy.clinica.horario.application.repository.HorarioPadraoRepository;
import dev.wakandaacademy.clinica.horario.domain.HorarioPadrao;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class HorarioPadraoInfraRepository implements HorarioPadraoRepository {
	private final HorarioPadraoSpringDataMongoRepository horarioPadraoSpringDataMongoRepository;
	
	@Override
	public void salvaHorarioPadrao(HorarioPadrao horarioPadrao) {
		try {
			log.info("[inicia] HorarioPadraoInfraRepository - salvaHorarioPadrao");
			horarioPadraoSpringDataMongoRepository.save(horarioPadrao);
			log.info("[finaliza] HorarioPadraoInfraRepository - salvaHorarioPadrao");
		} catch (DataIntegrityViolationException ex) {
			throw APIException.build(HttpStatus.BAD_REQUEST, "Horário Padrão já cadastrado!");
		}
	}
}
