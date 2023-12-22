package dev.wakandaacademy.clinica.paciente.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import dev.wakandaacademy.clinica.agendamento.domain.AgendamentoCliente;
import dev.wakandaacademy.clinica.agendamento.domain.AgendamentoClienteConsulta;
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
	private UUID idPaciente;
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
		this.idPaciente = UUID.randomUUID();
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

//	public void cadastraConsulta(AgendamentoClienteConsulta agendamentoClienteConsulta) {
//		if(consultas.isEmpty())consultas = new ArrayList<>();
//		consultas.add(new AgendamentoCliente(agendamentoClienteConsulta));
//	}

}
