package dev.wakandaacademy.clinica.paciente.application.api;

import java.util.UUID;

import dev.wakandaacademy.clinica.paciente.domain.Paciente;
import lombok.Getter;

@Getter
public class PacienteCriadoResponse {
	private final UUID idPaciente;
	private final String nome;
	private final String telefone;
	private final String sexo;
	private final String dataNascimento;
	
	public PacienteCriadoResponse(Paciente paciente) {
		this.idPaciente = paciente.getIdPaciente();
		this.nome = paciente.getNome();
		this.telefone = paciente.getTelefone();
		this.sexo = paciente.getSexo();
		this.dataNascimento = paciente.getDataNascimento();
	}
	
	public static PacienteCriadoResponse convertePacienteParaResponse(Paciente paciente) {
		return new PacienteCriadoResponse(paciente);
	}
}
