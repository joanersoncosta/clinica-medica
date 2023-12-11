package dev.wakandaacademy.clinica.especialidade.domain;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.HttpStatus;

import dev.wakandaacademy.clinica.especialidade.application.api.EspecialidadeAlteracaoRequest;
import dev.wakandaacademy.clinica.especialidade.application.api.EspecialidadeMedicaRequest;
import dev.wakandaacademy.clinica.especialidade.application.api.EspecialidadeRequest;
import dev.wakandaacademy.clinica.handler.APIException;
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
	@Indexed(unique = true)
	private String titlo;
	private String descricao;
	private Set<EspecialidadeMedicos> especialidadeMedicos;

	private LocalDateTime momentoDoDacastro;
	private LocalDateTime dataHoraDaultimaAlteracao;

	public Especialidade(EspecialidadeRequest especialidadeRequest) {
		this.idEspecialidade = UUID.randomUUID();
		this.titlo = especialidadeRequest.getTitlo();
		this.descricao = especialidadeRequest.getDescricao();
		this.momentoDoDacastro = LocalDateTime.now();
		this.especialidadeMedicos = new HashSet<>();
	}

	public void altera(EspecialidadeAlteracaoRequest especialidadeRequest) {
		this.titlo = especialidadeRequest.getTitlo();
		this.descricao = especialidadeRequest.getDescricao();
		this.dataHoraDaultimaAlteracao = LocalDateTime.now();
	}

	public void atualizaEspecialidadeMedico(EspecialidadeMedicaRequest especialidadeMedicaRequest) {
		EspecialidadeMedicos especialidadeMedico = new EspecialidadeMedicos(especialidadeMedicaRequest);
		if (!this.especialidadeMedicos.contains(especialidadeMedico)) {
			this.especialidadeMedicos.add(especialidadeMedico);
		}
	}
}
