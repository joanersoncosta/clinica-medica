package dev.wakandaacademy.clinica.especialidade.application.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class EspecialidadeRequest {
	@NotBlank(message = "Campo titulo não pode esté em branco")
	@Size(min = 3, max = 50)
	private String titlo;
	@NotBlank(message = "Campo descrição não pode esté em branco")
	@Size(min = 3, max = 250)
	private String descricao;
}
