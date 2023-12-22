package dev.wakandaacademy.clinica.agendamento.appplication.service;

import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import dev.wakandaacademy.clinica.agendamento.appplication.api.AgendamentoIdResponse;
import dev.wakandaacademy.clinica.agendamento.appplication.api.AgendamentoRequest;
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
		Paciente paciente = pacienteRepository.buscaPacientePorId(agendamentoRequest.getIdPaciente())
				.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Paciente não encontrado!"));
		Especialidade especialidade = especialidadeService
				.detalhaEspecialidadePorId(agendamentoRequest.getIdEspecialidade());
		HorarioPadrao horario = horarioService.detalhaHorarioPorHorario(LocalTime.parse(agendamentoRequest.getHorario()));
		
		medico.pertenceEspecialidade(especialidade);
		
		Agendamento	agendamento = agendamentoRepository.salvaAgendamento(new Agendamento(new AgendamentoClienteConsulta(agendamentoRequest, paciente, medico, especialidade, horario)));
		pacienteRepository.salvaPaciente(paciente);

		medicoRepository.salvaMedico(medico);
		log.info("[finaliza] AgendamentoApplicationService - criaAgendamento");
		return AgendamentoIdResponse.builder().idAgendamento(agendamento.getIdAgendamento()).build();
	}
	
	@Override
	public Agendamento buscaAgendamentoporIdPaciente(UUID idPaciente) {
		log.info("[inicia] AgendamentoApplicationService - buscaAgendamentoporIdPaciente");
		Agendamento agendamento = agendamentoRepository.buscaAgendamentoporIdPaciente(idPaciente)
				.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Paciente não possui agendamento!"));
		log.info("[finaliza] AgendamentoApplicationService - buscaAgendamentoporIdPaciente");
		return agendamento;
	}

	@Override
	public List<AgendamentoPaciente> buscaAgendamentosIdPaciente(UUID idPaciente) {
		log.info("[inicia] AgendamentoApplicationService - buscaAgendamentosIdPaciente");
		List<Agendamento> agendamentos = agendamentoRepository.buscaAgendamentosIdPaciente(idPaciente);
		log.info("[finaliza] AgendamentoApplicationService - buscaAgendamentosIdPaciente");
		return AgendamentoPaciente.converte(agendamentos);
	}

}
