package dev.wakandaacademy.clinica.medico.application.api;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import dev.wakandaacademy.clinica.medico.domain.Medico;
import lombok.Value;

@Value
public class MedicoListResponse {
	private final UUID idMedico;
	private final String nome;
	private final String crm;
	private final String telefone;
	private final String sexo;
	private final LocalDate dataNascimento;

	public MedicoListResponse(Medico medico) {
		this.idMedico = medico.getIdMedico();
		this.nome = medico.getNome();
		this.crm = medico.getCrm();
		this.telefone = medico.getTelefone();
		this.sexo = medico.getSexo();
		this.dataNascimento = medico.getDataNascimento();
	}

	public static List<MedicoListResponse> converte(List<Medico> medicos) {
		return medicos.stream().map(MedicoListResponse::new)
				.collect(Collectors.toList());
	}
}