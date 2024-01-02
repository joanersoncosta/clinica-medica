package dev.wakandaacademy.clinica.medico.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.HttpStatus;

import dev.wakandaacademy.clinica.agendamento.appplication.api.AgendamentoMedico;
import dev.wakandaacademy.clinica.agendamento.domain.AgendamentoPaciente;
import dev.wakandaacademy.clinica.especialidade.domain.Especialidade;
import dev.wakandaacademy.clinica.handler.APIException;
import dev.wakandaacademy.clinica.horario.application.api.HorarioPadraoListResponse;
import dev.wakandaacademy.clinica.horario.domain.HorarioPadrao;
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
	@Indexed
	private UUID idEspecialidade;
	@Email
	@NotBlank(message = "Campo Email é obrigatório!")
	@Indexed(unique = true)
	private String email;
	@NotBlank(message = "Campo Nome é obrigatório!")
	private String nome;
	@NotNull(message = "Campo crm é obrigatório!")
	@Indexed(unique = true)
	private String crm;
	@NotBlank(message = "Campo Telefone é obrigatório!")
	private String telefone;
	private String sexo;
	@NotNull
	private LocalDate dataNascimento;
	private List<MedicoHorarioDisponivel> horariosDisponiveis;
	private LocalDateTime momentoDoDacastro;
	private LocalDateTime dataHoraDaultimaAlteracao;

	public Medico(MedicoNovoRequest medicoNovoRequest, List<HorarioPadraoListResponse> listHorario) {
		this.idMedico = UUID.randomUUID();
		this.idEspecialidade = medicoNovoRequest.getIdEspecialidade();
		this.nome = medicoNovoRequest.getNome();
		this.email = medicoNovoRequest.getEmail();
		this.crm = medicoNovoRequest.getCrm();
		this.telefone = medicoNovoRequest.getTelefone();
		this.sexo = setSexo(medicoNovoRequest.getSexo());
		this.dataNascimento = medicoNovoRequest.getDataNascimento();
		this.horariosDisponiveis = new ArrayList<>();
		this.horariosDisponiveis = cadastraHorarioPadrao(listHorario);
		this.momentoDoDacastro = LocalDateTime.now();
	}

	public void alteraDados(MedicoAlteracaoRequest postagemAlteracaoRequest) {
		this.nome = postagemAlteracaoRequest.getNome();
		this.crm = postagemAlteracaoRequest.getCrm();
		this.telefone = postagemAlteracaoRequest.getTelefone();
		this.dataNascimento = postagemAlteracaoRequest.getDataNascimento();
		this.dataHoraDaultimaAlteracao = LocalDateTime.now();
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
	
	public void pertenceEspecialidade(Especialidade especialidade) {
		if (!idEspecialidade.equals(especialidade.getIdEspecialidade())) {
			throw APIException.build(HttpStatus.UNAUTHORIZED, "Médico não possui esta Especialidade!");
		}
	}
	
	private List<MedicoHorarioDisponivel> cadastraHorarioPadrao(List<HorarioPadraoListResponse> listHorario){
		for(HorarioPadraoListResponse h: listHorario) {
			this.horariosDisponiveis.add(new MedicoHorarioDisponivel(h));
		}
		return this.horariosDisponiveis;
	}

	public void verificaAgendamentoMedico(List<AgendamentoMedico> agendamentosMedico, HorarioPadrao horario, String dataConsulta) {
			LocalDate data = LocalDate.parse(dataConsulta);
			for (AgendamentoMedico agenda : agendamentosMedico) {
				if (agenda.getDataConsulta().equals(data) && agenda.getHorario().equals(horario.getHorario())) {
					throw APIException.build(HttpStatus.BAD_REQUEST, "Médico já possui consulta para esse hórario!!");
				}
			}
		}

}
