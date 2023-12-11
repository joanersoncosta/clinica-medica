package dev.wakandaacademy.clinica.especialidade.application.api;

import java.util.UUID;

import dev.wakandaacademy.clinica.especialidade.domain.Especialidade;
import lombok.Value;

@Value
public class EspecialidadeResponse {
	private UUID idEspecialidade;
	private String titlo;
	private String descricao;

	public EspecialidadeResponse(Especialidade especialidade) {
		this.idEspecialidade = especialidade.getIdEspecialidade();
		this.titlo = especialidade.getTitlo();
		this.descricao = especialidade.getDescricao();
	}

	public static EspecialidadeResponse converteParaResponse(Especialidade especialidade) {
		return new EspecialidadeResponse(especialidade);
	}
}
