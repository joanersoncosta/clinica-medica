package dev.wakandaacademy.clinica.especialidade.application.api;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class EspecialidadeTitloRequest {
	@NotBlank(message = "Nome é obrigatório")
	private String titlo;
}
