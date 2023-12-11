package dev.wakandaacademy.clinica.medico.application.api;

import java.time.LocalDate;
import java.util.UUID;

import dev.wakandaacademy.clinica.medico.domain.Medico;
import lombok.Value;

@Value
public class MedicoCriadoResponse {
	private final UUID idMedico;
	private final String nome;
	private final String crm;
	private final String telefone;
	private final String sexo;
	private final LocalDate dataNascimento;

	public MedicoCriadoResponse(Medico medico) {
		this.idMedico = medico.getIdMedico();
		this.nome = medico.getNome();
		this.crm = medico.getCrm();
		this.telefone = medico.getTelefone();
		this.sexo = medico.getSexo();
		this.dataNascimento = medico.getDataNascimento();
	}

	public static MedicoCriadoResponse converteParaResponse(Medico medico) {
		return new MedicoCriadoResponse(medico);
	}
}
