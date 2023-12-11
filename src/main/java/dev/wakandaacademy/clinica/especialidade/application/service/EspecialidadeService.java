package dev.wakandaacademy.clinica.especialidade.application.service;

import dev.wakandaacademy.clinica.especialidade.application.api.EspecialidadeIdResponse;
import dev.wakandaacademy.clinica.especialidade.application.api.EspecialidadeRequest;
import jakarta.validation.Valid;

public interface EspecialidadeService {
	EspecialidadeIdResponse criarEspecialidade(EspecialidadeRequest especialidadeRequest);

}
