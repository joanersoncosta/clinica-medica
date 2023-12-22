package dev.wakandaacademy.clinica.medico.domain;

import java.util.UUID;

import dev.wakandaacademy.clinica.especialidade.domain.Especialidade;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(of = "idEspecialidade")
@Getter
public class MedicoEspecialidadeRequest {

	private UUID idEspecialidade;
	private String titlo;
	private String descricao;

	public MedicoEspecialidadeRequest(Especialidade especialidade) {
		this.idEspecialidade = especialidade.getIdEspecialidade();
		this.titlo = especialidade.getTitlo();
		this.descricao = especialidade.getDescricao();
	}

}
