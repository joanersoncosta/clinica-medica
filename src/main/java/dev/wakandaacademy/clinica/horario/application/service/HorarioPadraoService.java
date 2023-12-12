package dev.wakandaacademy.clinica.horario.application.service;

import java.util.List;

import dev.wakandaacademy.clinica.horario.application.api.HorarioPadraoListResponse;

public interface HorarioPadraoService {
	void criahorarioPadrao();
	List<HorarioPadraoListResponse> getHorarioPadrao();
}
