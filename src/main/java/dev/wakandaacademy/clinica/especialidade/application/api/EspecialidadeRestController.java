package dev.wakandaacademy.clinica.especialidade.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import dev.wakandaacademy.clinica.especialidade.application.service.EspecialidadeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequiredArgsConstructor
@Log4j2
public class EspecialidadeRestController implements EspecialidadeAPI {
	private final EspecialidadeService especialidadeService;

	@Override
	public EspecialidadeIdResponse criarEspecialidade(EspecialidadeRequest especialidadeRequest) {
		log.info("[inicia] EspecialidadeRestController - criarEspecialidade");
		EspecialidadeIdResponse especialidadeIdResponse = especialidadeService.criarEspecialidade(especialidadeRequest);
		log.info("[finaliza] EspecialidadeRestController - criarEspecialidade");
		return especialidadeIdResponse;
	}

	@Override
	public List<EspecialidadeListResponse> listaEspecialidade() {
		log.info("[inicia] EspecialidadeRestController - listaEspecialidade");
		List<EspecialidadeListResponse> especialidadeListResponse = especialidadeService.listaEspecialidade();
		log.info("[finaliza] EspecialidadeRestController - listaEspecialidade");
		return especialidadeListResponse;
	}

	@Override
	public EspecialidadeResponse buscaEspecialidadePorId(UUID idEspecialidade) {
		log.info("[inicia] EspecialidadeRestController - buscaEspecialidadePorId");
		EspecialidadeResponse especialidadeResponse = especialidadeService.buscaEspecialidadePorId(idEspecialidade);
		log.info("[finaliza] EspecialidadeRestController - buscaEspecialidadePorId");
		return especialidadeResponse;
	}

	@Override
	public void deletaEspecialidadePorId(UUID idEspecialidade) {
		log.info("[inicia] EspecialidadeRestController - deletaEspecialidadePorId");
		especialidadeService.deletaEspecialidadePorId(idEspecialidade);
		log.info("[finaliza] EspecialidadeRestController - deletaEspecialidadePorId");
	}

	@Override
	public void alteraEspecialidadePorId(UUID idEspecialidade, EspecialidadeAlteracaoRequest especialidadeRequest) {
		log.info("[inicia] EspecialidadeRestController - alteraEspecialidadePorId");
		especialidadeService.alteraEspecialidadePorId(idEspecialidade, especialidadeRequest);
		log.info("[finaliza] EspecialidadeRestController - alteraEspecialidadePorId");
	}
	
}
