package dev.wakandaacademy.clinica.horario.application.service;

import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

import dev.wakandaacademy.clinica.horario.application.api.HorarioPadraoListResponse;
import dev.wakandaacademy.clinica.horario.domain.HorarioPadrao;

public interface HorarioPadraoService {
	void criahorarioPadrao();
	List<HorarioPadraoListResponse> getHorarioPadrao();
	HorarioPadrao detalhaHorarioPorId(UUID idHorario);
	HorarioPadrao detalhaHorarioPorHorario(LocalTime horario);
}
