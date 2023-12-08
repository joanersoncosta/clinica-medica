package dev.wakandaacademy.clinica.paciente.application.api;

import dev.wakandaacademy.clinica.paciente.domain.enuns.Sexo;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class PacienteNovoRequest {
	@NotBlank
	private String nome;
	@NotNull
	@Size(min = 6, max = 10)
	private String senha;
	@Email
	@NotNull
	private String email;
	@NotBlank
	private String telefone;
	@NotNull
	private Sexo sexo;
	@NotNull
	private String dataNascimento;
}