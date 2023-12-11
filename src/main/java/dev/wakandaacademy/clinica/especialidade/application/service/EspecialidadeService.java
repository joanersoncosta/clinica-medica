package dev.wakandaacademy.clinica.especialidade.application.service;

import java.util.List;
import java.util.UUID;

import dev.wakandaacademy.clinica.especialidade.application.api.EspecialidadeIdResponse;
import dev.wakandaacademy.clinica.especialidade.application.api.EspecialidadeListResponse;
import dev.wakandaacademy.clinica.especialidade.application.api.EspecialidadeRequest;
import dev.wakandaacademy.clinica.especialidade.application.api.EspecialidadeResponse;

public interface EspecialidadeService {
	EspecialidadeIdResponse criarEspecialidade(EspecialidadeRequest especialidadeRequest);
	List<EspecialidadeListResponse> listaEspecialidade();
	EspecialidadeResponse buscaEspecialidadePorId(UUID idEspecialidade);
	void deletaEspecialidadePorId(UUID idEspecialidade);
}
