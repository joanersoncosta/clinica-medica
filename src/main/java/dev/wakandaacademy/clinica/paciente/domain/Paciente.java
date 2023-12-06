package dev.wakandaacademy.clinica.paciente.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import dev.wakandaacademy.clinica.paciente.application.api.PacienteNovoRequest;
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
@Document(collection = "Paciente")
public class Paciente {
	@Id
	@MongoId(targetType = FieldType.STRING)
	private String idPaciente;
	@NotBlank
	private String nome;
	@Email
	@NotNull
	@Indexed(unique = true)
	private String email;
	@NotBlank
	private String telefone;
	@NotNull
	private String sexo;
	@NotNull
	private String dataNascimento;

	private LocalDateTime momentoDoDacastro;
	private LocalDateTime dataHoraDaultimaAlteracao;

	public Paciente(PacienteNovoRequest pacienteRequest) {
		this.nome = pacienteRequest.getNome();
		this.email = pacienteRequest.getEmail();
		this.telefone = pacienteRequest.getTelefone();
		this.sexo = setSexo(pacienteRequest.getSexo());
		this.dataNascimento = pacienteRequest.getDataNascimento();
		this.momentoDoDacastro = LocalDateTime.now();
	}
	
	public String setSexo(Sexo sexo) {
		if (sexo != null) {
			this.sexo = sexo.getSexo();
		}
		return this.sexo;
	}

}
