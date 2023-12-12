package dev.wakandaacademy.clinica.horario.application.repository;

import java.util.List;

import dev.wakandaacademy.clinica.horario.domain.HorarioPadrao;

public interface HorarioPadraoRepository {
	void salvaHorarioPadrao(HorarioPadrao horarioPadrao);
	List<HorarioPadrao> getHorarioPadrao();
}
