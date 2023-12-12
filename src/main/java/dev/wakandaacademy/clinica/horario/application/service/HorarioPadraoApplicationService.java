package dev.wakandaacademy.clinica.horario.application.service;

import java.time.LocalTime;
import java.util.List;

import org.springframework.stereotype.Service;

import dev.wakandaacademy.clinica.horario.application.api.HorarioPadraoListResponse;
import dev.wakandaacademy.clinica.horario.application.repository.HorarioPadraoRepository;
import dev.wakandaacademy.clinica.horario.domain.HorarioPadrao;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class HorarioPadraoApplicationService implements HorarioPadraoService {
	private final HorarioPadraoRepository horarioPadraoRepository;

	@Override
	public void criahorarioPadrao() {
		log.info("[inicia] HorarioPadraoApplicationService - criahorarioPadrao");
		geraHorarioPeriodoManha();
		geraHorarioPeriodoTarde();
		log.info("[finaliza] HorarioPadraoApplicationService - criahorarioPadrao");
	}

	private void geraHorarioPeriodoManha() {
		log.info("[inicia] HorarioPadraoApplicationService - geraHorarioPeriodoManha");
		LocalTime horario = LocalTime.parse("08:00:00");
		var anterior = horario;
		LocalTime proximo = null;
		for (int i = 1; i <= 9; i++) {
			if (i == 1) {
				proximo = anterior;
			}
			horarioPadraoRepository.salvaHorarioPadrao(new HorarioPadrao(proximo));
			proximo = proximo.plusMinutes(30);
		}
		log.info("[finaliza] HorarioPadraoApplicationService - geraHorarioPeriodoManha");
	}
	
	private void geraHorarioPeriodoTarde() {
		log.info("[inicia] HorarioPadraoApplicationService - geraHorarioPeriodoTarde");
		LocalTime horario = LocalTime.parse("14:00:00");
		var anterior = horario;
		LocalTime proximo = null;
		for (int i = 1; i <= 7; i++) {
			if (i == 1) {
				proximo = anterior;
			}
			horarioPadraoRepository.salvaHorarioPadrao(new HorarioPadrao(proximo));
			proximo = proximo.plusMinutes(30);
		}
		log.info("[finaliza] HorarioPadraoApplicationService - geraHorarioPeriodoTarde");
	}

	@Override
	public List<HorarioPadraoListResponse> getHorarioPadrao() {
		log.info("[inicia] HorarioPadraoApplicationService - getListHorarioPadrao");
		List<HorarioPadrao> horarios = horarioPadraoRepository.getHorarioPadrao();
		log.info("[finaliza] HorarioPadraoApplicationService - getListHorarioPadrao");
		return HorarioPadraoListResponse.converte(horarios);
	}
}
