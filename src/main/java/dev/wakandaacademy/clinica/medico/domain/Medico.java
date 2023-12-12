package dev.wakandaacademy.clinica.medico.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.HttpStatus;

import dev.wakandaacademy.clinica.especialidade.domain.Especialidade;
import dev.wakandaacademy.clinica.handler.APIException;
import dev.wakandaacademy.clinica.medico.application.api.MedicoAlteracaoRequest;
import dev.wakandaacademy.clinica.medico.application.api.MedicoNovoRequest;
import dev.wakandaacademy.clinica.paciente.domain.enuns.Sexo;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Document(collection = "Medico")
public class Medico {
	@Id
	private UUID idMedico;
	@NotBlank
	private String nome;
	@Email
	@NotBlank
	@Indexed(unique = true)
	private String email;
	@NotNull
	private String crm;
	@NotBlank
	private String telefone;
	private String sexo;
	@NotNull
	private LocalDate dataNascimento;
	private Set<MedicoEspecialidades> especialidades;

	private LocalDateTime momentoDoDacastro;
	private LocalDateTime dataHoraDaultimaAlteracao;

	public Medico(MedicoNovoRequest medicoNovoRequest) {
		this.idMedico = UUID.randomUUID();
		this.nome = medicoNovoRequest.getNome();
		this.email = medicoNovoRequest.getEmail();
		this.crm = medicoNovoRequest.getCrm();
		this.telefone = medicoNovoRequest.getTelefone();
		this.sexo = setSexo(medicoNovoRequest.getSexo());
		this.dataNascimento = medicoNovoRequest.getDataNascimento();
		this.momentoDoDacastro = LocalDateTime.now();
		this.especialidades = new HashSet<>();
	}

	public String setSexo(Sexo sexo) {
		if (sexo != null) {
			this.sexo = sexo.getSexo();
		}
		return this.sexo;
	}

	public void pertenceMedico(Medico medicoEmail) {
		if (!idMedico.equals(medicoEmail.getIdMedico())) {
			throw APIException.build(HttpStatus.UNAUTHORIZED, "Médico não é dono da requisição solicitada!");
		}
	}

	public void alteraDados(MedicoAlteracaoRequest postagemAlteracaoRequest) {
		this.nome = postagemAlteracaoRequest.getNome();
		this.crm = postagemAlteracaoRequest.getCrm();
		this.telefone = postagemAlteracaoRequest.getTelefone();
		this.dataNascimento = postagemAlteracaoRequest.getDataNascimento();
		this.dataHoraDaultimaAlteracao = LocalDateTime.now();
	}

	public void cadastraEspecialidade(MedicaEspecialidadeRequest medicaEspecialidadeRequest) {
		MedicoEspecialidades especialidade = new MedicoEspecialidades(medicaEspecialidadeRequest);
		if (this.especialidades.contains(especialidade)) {
			throw APIException.build(HttpStatus.BAD_REQUEST, "Especialidade já cadastrada para este Médico!");
		}
		this.especialidades.add(especialidade);
	}

	public void pertenceEspecialidade(Especialidade especialidade) {
		MedicoEspecialidades especialidadeMedico = MedicoEspecialidades.builder()
				.idEspecialidade(especialidade.getIdEspecialidade()).build();
		for (MedicoEspecialidades medico : especialidades) {
			medico.pertenceEspecialidade(especialidadeMedico);
		}
	}

}
