package dev.wakandaacademy.clinica.especialidade.application.api;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import dev.wakandaacademy.clinica.especialidade.domain.Especialidade;
import lombok.Value;

@Value
public class EspecialidadeListResponse {
	private UUID idEspecialidade;
	private String titlo;
	private String descricao;

	public EspecialidadeListResponse(Especialidade especialidade) {
		this.idEspecialidade = especialidade.getIdEspecialidade();
		this.titlo = especialidade.getTitlo();
		this.descricao = especialidade.getDescricao();
	}

	public static List<EspecialidadeListResponse> converte(List<Especialidade> especialidades) {
		return especialidades.stream().map(EspecialidadeListResponse::new).collect(Collectors.toList());
	}

	public static List<EspecialidadeListResponse> converte(List<Especialidade> especialidades,
			EspecialidadeTitloRequest especialidadeRequest) {
		return especialidades.stream()
                .filter(n -> n.getTitlo().toLowerCase().contains(especialidadeRequest.getTitlo().toLowerCase()))				.map(EspecialidadeListResponse::new)
				.collect(Collectors.toList());
	}
}
