package dev.wakandaacademy.clinica.especialidade.application.service;

import java.util.List;

import dev.wakandaacademy.clinica.especialidade.application.api.EspecialidadeIdResponse;
import dev.wakandaacademy.clinica.especialidade.application.api.EspecialidadeListResponse;
import dev.wakandaacademy.clinica.especialidade.application.api.EspecialidadeRequest;

public interface EspecialidadeService {
	EspecialidadeIdResponse criarEspecialidade(EspecialidadeRequest especialidadeRequest);
	List<EspecialidadeListResponse> listaEspecialidade();

}
