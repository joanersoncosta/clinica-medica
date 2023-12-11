package dev.wakandaacademy.clinica.especialidade.domain;

import java.util.UUID;

import org.springframework.data.mongodb.core.index.Indexed;

import dev.wakandaacademy.clinica.especialidade.application.api.EspecialidadeMedicaRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(of = "idMedico")
@Getter
public class EspecialidadeMedicos {
	@Indexed(unique = true)
	private UUID idMedico;
	private String nome;
	private String crm;
	private String sexo;

	public EspecialidadeMedicos(EspecialidadeMedicaRequest medico) {
		this.idMedico = medico.getIdMedico();
		this.nome = medico.getNome();
		this.crm = medico.getCrm();
		this.sexo = medico.getSexo();
	}
}
