package dev.wakandaacademy.clinica.horario.application.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import dev.wakandaacademy.clinica.horario.domain.HorarioPadrao;

public interface HorarioPadraoRepository {
	void salvaHorarioPadrao(HorarioPadrao horarioPadrao);
	List<HorarioPadrao> getHorarioPadrao();
	Optional<HorarioPadrao> buscaHorarioPorId(UUID idHorario);
	List<HorarioPadrao> buscaHorarios();
}
