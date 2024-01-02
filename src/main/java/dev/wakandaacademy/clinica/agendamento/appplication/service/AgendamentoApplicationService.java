package dev.wakandaacademy.clinica.agendamento.appplication.service;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import dev.wakandaacademy.clinica.agendamento.appplication.api.AgendamentoDataRequest;
import dev.wakandaacademy.clinica.agendamento.appplication.api.AgendamentoIdResponse;
import dev.wakandaacademy.clinica.agendamento.appplication.api.AgendamentoListResponse;
import dev.wakandaacademy.clinica.agendamento.appplication.api.AgendamentoMedico;
import dev.wakandaacademy.clinica.agendamento.appplication.api.AgendamentoMedicoListResponse;
import dev.wakandaacademy.clinica.agendamento.appplication.api.AgendamentoPacienteListResponse;
import dev.wakandaacademy.clinica.agendamento.appplication.api.AgendamentoRequest;
import dev.wakandaacademy.clinica.agendamento.appplication.api.AgendamentoResponse;
import dev.wakandaacademy.clinica.agendamento.appplication.api.EditaAgendamentoRequest;
import dev.wakandaacademy.clinica.agendamento.appplication.repository.AgendamentoRepository;
import dev.wakandaacademy.clinica.agendamento.domain.Agendamento;
import dev.wakandaacademy.clinica.agendamento.domain.AgendamentoClienteConsulta;
import dev.wakandaacademy.clinica.agendamento.domain.AgendamentoPaciente;
import dev.wakandaacademy.clinica.especialidade.application.service.EspecialidadeService;
import dev.wakandaacademy.clinica.especialidade.domain.Especialidade;
import dev.wakandaacademy.clinica.handler.APIException;
import dev.wakandaacademy.clinica.horario.application.service.HorarioPadraoService;
import dev.wakandaacademy.clinica.horario.domain.HorarioPadrao;
import dev.wakandaacademy.clinica.medico.application.repository.MedicoRepository;
import dev.wakandaacademy.clinica.medico.domain.Medico;
import dev.wakandaacademy.clinica.paciente.application.respository.PacienteRepository;
import dev.wakandaacademy.clinica.paciente.domain.Paciente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class AgendamentoApplicationService implements AgendamentoService {
	private final MedicoRepository medicoRepository;
	private final PacienteRepository pacienteRepository;
	private final HorarioPadraoService horarioService;
	private final EspecialidadeService especialidadeService;
	private final AgendamentoRepository agendamentoRepository;

	@Override
	public AgendamentoIdResponse criaAgendamento(AgendamentoRequest agendamentoRequest) {
		log.info("[inicia] AgendamentoApplicationService - criaAgendamento");
		Medico medico = medicoRepository.buscaMeditoPorId(agendamentoRequest.getIdMedico())
				.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Médico não encontrado!"));
		Paciente paciente = detalhaPaciente(agendamentoRequest.getIdPaciente());
		Especialidade especialidade = especialidadeService
				.detalhaEspecialidadePorId(agendamentoRequest.getIdEspecialidade());
		HorarioPadrao horario = horarioService.detalhaHorarioPorId(agendamentoRequest.getIdHorario());
		medico.pertenceEspecialidade(especialidade);
		verificaAgendamentoPaciente(paciente, horario, agendamentoRequest.getDataConsulta(), agendamentoRequest.getIdPaciente());
		verificaAgendamentoMedico(medico, horario, agendamentoRequest.getDataConsulta(), agendamentoRequest.getIdMedico());
		Agendamento	agendamento = agendamentoRepository.salvaAgendamento(new Agendamento(new AgendamentoClienteConsulta(agendamentoRequest, paciente, medico, especialidade, horario)));
		log.info("[finaliza] AgendamentoApplicationService - criaAgendamento");
		return AgendamentoIdResponse.builder().idAgendamento(agendamento.getIdAgendamento()).build();
	}
	
	@Override
	public AgendamentoResponse buscaAgendamentoPorId(UUID idAgendamento) {
		log.info("[inicia] AgendamentoApplicationService - buscaAgendamentoPorId");
		AgendamentoResponse agendamento = agendamentoRepository.buscaAgendamentoPorId(idAgendamento)
				.map(AgendamentoResponse::converteParaResponse)
				.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Agendamento não encontrado"));
		log.info("[finaliza] AgendamentoApplicationService - buscaAgendamentoPorId");
		return agendamento;
	}
	
	@Override
	public List<AgendamentoListResponse> buscaAgendamentos() {
		log.info("[inicia] AgendamentoApplicationService - buscaAgendamentos");
		List<Agendamento > agendamentos = agendamentoRepository.buscaAgendamentos();
		log.info("[finaliza] AgendamentoApplicationService - buscaAgendamentos");
		return AgendamentoListResponse.converte(agendamentos);
	}
	
	@Override
	public void deletaAgendamentoPorId(UUID idAgendamento, UUID idPaciente) {
		log.info("[inicia] AgendamentoApplicationService - deletaAgendamentoPorId");
		Paciente paciente = detalhaPaciente(idPaciente);
		Agendamento agendamento = detalhaAgendamento(idAgendamento);
		agendamento.pertencePaciente(paciente);
		agendamentoRepository.deletaAgendamento(agendamento);
		log.info("[finaliza] AgendamentoApplicationService - deletaAgendamentoPorId");
	}
	
	@Override
	public void reagendaCunsulta(EditaAgendamentoRequest agendamentoRequest, UUID idAgendamento, UUID idPaciente) {
		log.info("[inicia] AgendamentoApplicationService - reagendaCunsulta");
		Paciente paciente = detalhaPaciente(idPaciente);
		Medico medico = detalhaMedico(agendamentoRequest.getIdMedico());
		HorarioPadrao horario = horarioService.detalhaHorarioPorId(agendamentoRequest.getIdHorario());
		Agendamento agendamento = detalhaAgendamento(idAgendamento);
		agendamento.pertencePaciente(paciente);
		verificaAgendamentoPaciente(paciente, horario, agendamentoRequest.getDataConsulta(), agendamentoRequest.getIdPaciente());
		verificaAgendamentoMedico(medico, horario, agendamentoRequest.getDataConsulta(), agendamentoRequest.getIdMedico());
		agendamento.editaAgendamento(agendamentoRequest, horario.getHorario());
		agendamentoRepository.salvaAgendamento(agendamento);
		log.info("[finaliza] AgendamentoApplicationService - reagendaCunsulta");
	}
	
	private Medico detalhaMedico(UUID idMedico) {
		log.info("[inicia] AgendamentoApplicationService - detalhaMedico");
		Medico medico = medicoRepository.buscaMeditoPorId(idMedico)
				.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Médico não encontrado!"));
		log.info("[finaliza] AgendamentoApplicationService - detalhaMedico");
		return medico;
	}

	@Override
	public List<AgendamentoPaciente> buscaAgendamentosIdPaciente(UUID idPaciente) {
		log.info("[inicia] AgendamentoApplicationService - buscaAgendamentosIdPaciente");
		List<Agendamento> agendamentos = agendamentoRepository.buscaAgendamentosIdPaciente(idPaciente);
		log.info("[finaliza] AgendamentoApplicationService - buscaAgendamentosIdPaciente");
		return AgendamentoPaciente.converte(agendamentos);
	}

	@Override
	public List<AgendamentoMedico> buscaAgendamentosIdMedico(UUID idMedico) {
		log.info("[inicia] AgendamentoApplicationService - buscaAgendamentosIdMedico");
		List<Agendamento> agendamentos = agendamentoRepository.buscaAgendamentosIdMedico(idMedico);
		log.info("[finaliza] AgendamentoApplicationService - buscaAgendamentosIdMedico");
		return AgendamentoMedico.converte(agendamentos);	
	}
	
	private void verificaAgendamentoPaciente(Paciente paciente, HorarioPadrao horario, String dataConsulta, UUID idPaciente) {
		log.info("[inicia] AgendamentoApplicationService - verificaAgendamentoPaciente");
		List<AgendamentoPaciente> buscaAgendamentosPaciente = buscaAgendamentosIdPaciente(idPaciente);
		paciente.verificaAgendamentoPaciente(buscaAgendamentosPaciente, horario, dataConsulta);
		log.info("[finaliza] AgendamentoApplicationService - verificaAgendamentoPaciente");
	}
	
	private void verificaAgendamentoMedico(Medico medico, HorarioPadrao horario, String dataConsulta, UUID idMedico) {
		log.info("[inicia] AgendamentoApplicationService - verificaAgendamentoMedico");
		List<AgendamentoMedico> buscaAgendamentosMedico = buscaAgendamentosIdMedico(idMedico);
		medico.verificaAgendamentoMedico(buscaAgendamentosMedico, horario, dataConsulta);
		log.info("[finaliza] AgendamentoApplicationService - verificaAgendamentoMedico");
	}

	@Override
	public List<AgendamentoPacienteListResponse> buscaAgendamentosPacientePorData(AgendamentoDataRequest agendamentoDataRequest,
			UUID idPaciente) {
		log.info("[inicia] AgendamentoApplicationService - buscaAgendamentosPacientePorData");
		pacienteRepository.buscaPacientePorId(idPaciente)
			.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Paciente não encontrado"));
		List<Agendamento> agendamentos = agendamentoRepository.buscaAgendamentosIdPaciente(idPaciente);
		log.info("[finaliza] AgendamentoApplicationService - buscaAgendamentosPacientePorData");
		return AgendamentoPacienteListResponse.converte(agendamentos, agendamentoDataRequest);
	}
	
	@Override
	public List<AgendamentoMedicoListResponse> buscaAgendamentosMedicoPorData(AgendamentoDataRequest agendamento,
			UUID idMedico) {
		log.info("[inicia] AgendamentoApplicationService - buscaAgendamentosMedicoPorData");
		medicoRepository.buscaMeditoPorId(idMedico)
			.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Médico não encontrado"));

		List<Agendamento> agendamentos = agendamentoRepository.buscaAgendamentosIdMedico(idMedico);
		log.info("[finaliza] AgendamentoApplicationService - buscaAgendamentosMedicoPorData");
		return AgendamentoMedicoListResponse.converte(agendamentos, agendamento);
	}

	private Paciente detalhaPaciente(UUID idPaciente) {
		log.info("[inicia] AgendamentoApplicationService - detalhaPaciente");
		Paciente paciente = pacienteRepository.buscaPacientePorId(idPaciente)
				.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Paciente não encontrado!"));
		log.info("[finaliza] AgendamentoApplicationService - detalhaPaciente");
		return paciente;
	}

	public Agendamento detalhaAgendamento(UUID idAgendamento) {
		log.info("[inicia] AgendamentoApplicationService - detalhaAgendamento");
		Agendamento agendamento = agendamentoRepository.buscaAgendamentoPorId(idAgendamento)
				.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Agendamento não encontrado"));
		log.info("[finaliza] AgendamentoApplicationService - detalhaAgendamento");
		return agendamento;
	}

	@Override
	public void cancelaAgendamentoPorId(UUID idAgendamento, UUID idPaciente) {
		log.info("[inicia] AgendamentoApplicationService - cancelaAgendamentoPorId");
		Paciente paciente = detalhaPaciente(idPaciente);
		Agendamento agendamento = detalhaAgendamento(idAgendamento);
		agendamento.pertencePaciente(paciente);
		agendamento.cancelaAgendamento();
		agendamentoRepository.salvaAgendamento(agendamento);
		log.info("[finaliza] AgendamentoApplicationService - cancelaAgendamentoPorId");
	}

}
