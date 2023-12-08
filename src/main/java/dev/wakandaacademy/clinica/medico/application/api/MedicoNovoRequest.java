package dev.wakandaacademy.clinica.medico.application.api;

import dev.wakandaacademy.clinica.credencial.domain.Perfil;
import dev.wakandaacademy.clinica.paciente.domain.enuns.Sexo;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class MedicoNovoRequest {
	@NotBlank
	private String nome;
	@NotNull
	@Size(min = 6, max = 10)
	private String senha;
	private Perfil perfil = Perfil.MEDICO;
	@Email
	@NotNull
	private String email;
	@NotNull
	private int crm;
	@NotBlank
	private String telefone;
	@NotNull
	private Sexo sexo;
	@NotNull
	private String dataNascimento;
}
