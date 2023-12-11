package dev.wakandaacademy.clinica.medico.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

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
	}
	
	public String setSexo(Sexo sexo) {
		if (sexo != null) {
			this.sexo = sexo.getSexo();
		}
		return this.sexo;
	}

}
