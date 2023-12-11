package dev.wakandaacademy.clinica.especialidade.domain;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import dev.wakandaacademy.clinica.especialidade.application.api.EspecialidadeRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Document(collection = "Especialidade")
public class Especialidade {

	@Id
	private UUID idEspecialidade;
	private String titlo;
	private String descricao;

	public Especialidade(EspecialidadeRequest especialidadeRequest) {
		this.idEspecialidade = UUID.randomUUID();
		this.titlo = especialidadeRequest.getTitlo();
		this.descricao = especialidadeRequest.getDescricao();
	}

}
