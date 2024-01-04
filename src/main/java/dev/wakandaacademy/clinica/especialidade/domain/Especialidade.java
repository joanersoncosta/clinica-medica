package dev.wakandaacademy.clinica.especialidade.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import dev.wakandaacademy.clinica.especialidade.application.api.EspecialidadeAlteracaoRequest;
import dev.wakandaacademy.clinica.especialidade.application.api.EspecialidadeRequest;
import jakarta.validation.constraints.NotBlank;
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
	@NotBlank
	@Indexed(unique = true)
	private String titlo;
	private String descricao;
	private LocalDateTime momentoDoDacastro;
	private LocalDateTime dataHoraDaultimaAlteracao;

	public Especialidade(EspecialidadeRequest especialidadeRequest) {
		this.idEspecialidade = UUID.randomUUID();
		this.titlo = especialidadeRequest.getTitlo();
		this.descricao = especialidadeRequest.getDescricao();
		this.momentoDoDacastro = LocalDateTime.now();
	}

	public void altera(EspecialidadeAlteracaoRequest especialidadeRequest) {
		this.titlo = especialidadeRequest.getTitlo();
		this.descricao = especialidadeRequest.getDescricao();
		this.dataHoraDaultimaAlteracao = LocalDateTime.now();
	}

}
