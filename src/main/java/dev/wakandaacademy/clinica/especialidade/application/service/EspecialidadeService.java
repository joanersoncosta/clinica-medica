package dev.wakandaacademy.clinica.especialidade.application.service;

import java.util.List;
import java.util.UUID;

import dev.wakandaacademy.clinica.especialidade.application.api.EspecialidadeAlteracaoRequest;
import dev.wakandaacademy.clinica.especialidade.application.api.EspecialidadeIdResponse;
import dev.wakandaacademy.clinica.especialidade.application.api.EspecialidadeListResponse;
import dev.wakandaacademy.clinica.especialidade.application.api.EspecialidadeRequest;
import dev.wakandaacademy.clinica.especialidade.application.api.EspecialidadeResponse;
import dev.wakandaacademy.clinica.especialidade.domain.Especialidade;
import dev.wakandaacademy.clinica.medico.domain.Medico;

public interface EspecialidadeService {
	EspecialidadeIdResponse criarEspecialidade(EspecialidadeRequest especialidadeRequest);
	List<EspecialidadeListResponse> listaEspecialidade();
	EspecialidadeResponse buscaEspecialidadePorId(UUID idEspecialidade);
	Especialidade detalhaEspecialidadePorId(UUID idEspecialidade);
	void deletaEspecialidadePorId(UUID idEspecialidade);
	void alteraEspecialidadePorId(UUID idEspecialidade, EspecialidadeAlteracaoRequest especialidadeRequest);
	void atualizaEspecialidadeMedico(Especialidade especialidade, Medico medico);
}
