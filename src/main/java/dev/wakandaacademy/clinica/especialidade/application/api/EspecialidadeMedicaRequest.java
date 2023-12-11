package dev.wakandaacademy.clinica.especialidade.application.api;

import java.util.UUID;

import dev.wakandaacademy.clinica.medico.domain.Medico;
import lombok.Getter;

@Getter
public class EspecialidadeMedicaRequest{
	private UUID idMedico;
	private String nome;
	private String crm;
	private String sexo;

	public EspecialidadeMedicaRequest(Medico medico) {
		this.idMedico = medico.getIdMedico();
		this.nome = medico.getNome();
		this.crm = medico.getCrm();
		this.sexo = medico.getSexo();
	}
}
