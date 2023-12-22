package dev.wakandaacademy.clinica.medico.domain;

import java.util.UUID;

import org.springframework.http.HttpStatus;

import dev.wakandaacademy.clinica.handler.APIException;
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
public class MedicoEspecialidades {

	private UUID idEspecialidade;
	private String titlo;
	private String descricao;

	public MedicoEspecialidades(MedicoEspecialidadeRequest especialidade) {
		this.idEspecialidade = especialidade.getIdEspecialidade();
		this.titlo = especialidade.getTitlo();
		this.descricao = especialidade.getDescricao();
	}

	public void pertenceEspecialidade(MedicoEspecialidades especialidade) {
		if (this.idEspecialidade.equals(especialidade.getIdEspecialidade())) {
			throw APIException.build(HttpStatus.BAD_REQUEST, "Médico não possui esta Especialidad!");
		}
	}
}
