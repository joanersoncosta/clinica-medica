package dev.wakandaacademy.clinica.especialidade.domain;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
	@Size(min = 3, max = 50)
	private String titlo;
	@NotBlank
	@Size(min = 3, max = 250)
	private String descricao;

	public Especialidade(String titlo, String descricao) {
		this.idEspecialidade = UUID.randomUUID();
		this.titlo = titlo;
		this.descricao = descricao;
	}

}
