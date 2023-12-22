package dev.wakandaacademy.clinica.horario.infra;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

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
			horarioPadraoSpringDataMongoRepository.save(horarioPadrao);
		log.info("[finaliza] HorarioPadraoInfraRepository - salvaHorarioPadrao");
	}

	@Override
	public List<HorarioPadrao> getHorarioPadrao() {
		log.info("[inicia] HorarioPadraoInfraRepository - getHorarioPadrao");
		List<HorarioPadrao> horarios = horarioPadraoSpringDataMongoRepository.findAll();
		log.info("[finaliza] HorarioPadraoInfraRepository - getHorarioPadrao");
		return horarios;
	}

	@Override
	public Optional<HorarioPadrao> buscaHorarioPorId(UUID idHorario) {
		log.info("[inicia] HorarioPadraoInfraRepository - buscaHorarioPorId");
		Optional<HorarioPadrao> horario = horarioPadraoSpringDataMongoRepository.findById(idHorario);
		log.info("[finaliza] HorarioPadraoInfraRepository - buscaHorarioPorId");
		return horario;
	}

	@Override
	public List<HorarioPadrao> buscaHorarios() {
		log.info("[inicia] HorarioPadraoInfraRepository - buscaHorarios");
		List<HorarioPadrao> horarios = horarioPadraoSpringDataMongoRepository.findAll();	
		log.info("[finaliza] HorarioPadraoInfraRepository - buscaHorarios");
		return horarios;
	}
}
