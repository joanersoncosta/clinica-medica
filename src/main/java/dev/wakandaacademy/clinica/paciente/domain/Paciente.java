package dev.wakandaacademy.clinica.paciente.domain;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

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
@Document(collection = "Usuario")
public class Paciente {
	@Id
	@MongoId(targetType = FieldType.STRING)
	private String idUsuario;
	@NotBlank
	private String nome;
	@Email
	@NotNull
	@Indexed(unique = true)
	private String email;
	@NotBlank
	private String telefone;
	@NotBlank
	private String sexo;
	@NotNull
	private LocalDate dataNascimento;
}
