package dev.wakandaacademy.clinica.especialidade.application.repository;

import java.util.List;

import dev.wakandaacademy.clinica.especialidade.domain.Especialidade;

public interface EspecialidadeRepository {
	Especialidade salvaEspecialidade(Especialidade especialidade);
	List<Especialidade> listaEspecialidade();

}
