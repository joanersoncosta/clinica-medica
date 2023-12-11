package dev.wakandaacademy.clinica.especialidade.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import dev.wakandaacademy.clinica.especialidade.application.api.EspecialidadeIdResponse;
import dev.wakandaacademy.clinica.especialidade.application.api.EspecialidadeListResponse;
import dev.wakandaacademy.clinica.especialidade.application.api.EspecialidadeRequest;
import dev.wakandaacademy.clinica.especialidade.application.api.EspecialidadeResponse;
import dev.wakandaacademy.clinica.especialidade.application.repository.EspecialidadeRepository;
import dev.wakandaacademy.clinica.especialidade.domain.Especialidade;
import dev.wakandaacademy.clinica.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class EspecialidadeApplicationService implements EspecialidadeService {
	private final EspecialidadeRepository especialidadeRepository;

	@Override
	public EspecialidadeIdResponse criarEspecialidade(EspecialidadeRequest especialidadeRequest) {
		log.info("[inicia] EspecialidadeApplicationService - criarEspecialidade");
		Especialidade especialidadeCriada = especialidadeRepository
				.salvaEspecialidade(new Especialidade(especialidadeRequest));
		log.info("[finaliza] EspecialidadeApplicationService - criarEspecialidade");
		return EspecialidadeIdResponse.builder().idEspecialidade(especialidadeCriada.getIdEspecialidade()).build();
	}

	@Override
	public List<EspecialidadeListResponse> listaEspecialidade() {
		log.info("[inicia] EspecialidadeApplicationService - criarEspecialidade");
		List<Especialidade> especialidades = especialidadeRepository.listaEspecialidade();
		log.info("[finaliza] EspecialidadeApplicationService - criarEspecialidade");
		return EspecialidadeListResponse.converte(especialidades);
	}

	@Override
	public EspecialidadeResponse buscaEspecialidadePorId(UUID idEspecialidade) {
		log.info("[inicia] EspecialidadeApplicationService - buscaEspecialidadePorId");
		EspecialidadeResponse especialidade = especialidadeRepository.buscaEspecialidadePorId(idEspecialidade)
				.map(EspecialidadeResponse::converteParaResponse)
				.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Especialidade não encontrada!"));
		log.info("[finaliza] EspecialidadeApplicationService - buscaEspecialidadePorId");
		return especialidade;
	}

	@Override
	public void deletaEspecialidadePorId(UUID idEspecialidade) {
		log.info("[inicia] EspecialidadeApplicationService - deletaEspecialidadePorId");
		Especialidade especialidade = especialidadeRepository.buscaEspecialidadePorId(idEspecialidade)
				.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Especialidade não encontrada!"));
		especialidadeRepository.deletaEspecialidadePorId(especialidade);
		log.info("[finaliza] EspecialidadeApplicationService - deletaEspecialidadePorId");
	}
}
