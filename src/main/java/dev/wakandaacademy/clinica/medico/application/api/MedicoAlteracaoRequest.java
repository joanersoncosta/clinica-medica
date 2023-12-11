package dev.wakandaacademy.clinica.medico.application.api;

import java.time.LocalDate;

import lombok.Getter;

@Getter
public class MedicoAlteracaoRequest {
	private String nome;
	private String crm;
	private String telefone;
	private LocalDate dataNascimento;
}
