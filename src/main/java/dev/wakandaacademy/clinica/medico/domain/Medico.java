package dev.wakandaacademy.clinica.medico.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

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
	private UUID idUsuario;
	@NotBlank
	private String nome;
	@Email
	@NotNull
	@Indexed(unique = true)
	private String email;
	@NotNull
	private int crm;
	@NotBlank
	private String telefone;
	@NotNull
	private String sexo;
	@NotNull
	private String dataNascimento;

	private LocalDateTime momentoDoDacastro;
	private LocalDateTime dataHoraDaultimaAlteracao;

	public Medico(@NotBlank String nome, @Email @NotNull String email, @NotBlank String telefone, @NotNull String sexo,
			@NotNull String dataNascimento, LocalDateTime momentoDoDacastro, LocalDateTime dataHoraDaultimaAlteracao) {
		this.idUsuario = UUID.randomUUID();
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.momentoDoDacastro = momentoDoDacastro;
		this.dataHoraDaultimaAlteracao = dataHoraDaultimaAlteracao;
	}

}
