package dev.wakandaacademy.clinica.agendamento.appplication.api;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import dev.wakandaacademy.clinica.agendamento.appplication.service.AgendamentoService;
import dev.wakandaacademy.clinica.agendamento.domain.AgendamentoPaciente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequiredArgsConstructor
@Log4j2
public class AgendamentoRestController implements AgendamentoAPI {
	private final AgendamentoService agendamentoService;

	@Override
	public AgendamentoIdResponse postAgendamento(AgendamentoRequest agendamento) {
		log.info("[inicia] AgendamentoRestController - postAgendamento");
		AgendamentoIdResponse idAgendamento = agendamentoService.criaAgendamento(agendamento);
		log.info("[finaliza] AgendamentoRestController - postAgendamento");
		return idAgendamento;
	}
	
	@Override
	public AgendamentoResponse buscaAgendamentoPorId(UUID idAgendamento) {
		log.info("[inicia] AgendamentoRestController - buscaAgendamentoPorId");
		AgendamentoResponse agendamento = agendamentoService.buscaAgendamentoPorId(idAgendamento);
		log.info("[finaliza] AgendamentoRestController - buscaAgendamentoPorId");
		return agendamento;
	}
	
	@Override
	public List<AgendamentoListResponse> buscaAgendamentos() {
		log.info("[inicia] AgendamentoRestController - buscaAgendamentos");
		List<AgendamentoListResponse> agendamentos = agendamentoService.buscaAgendamentos();
		log.info("[finaliza] AgendamentoRestController - buscaAgendamentos");
		return agendamentos;
	}
	
	@Override
	public void deletaAgendamentoPorId(UUID IdAgendamento, UUID IdPaciente) {
		log.info("[inicia] AgendamentoRestController - deletaAgendamentoPorId");
		agendamentoService.deletaAgendamentoPorId(IdAgendamento, IdPaciente);
		log.info("[finaliza] AgendamentoRestController - deletaAgendamentoPorId");
	}
	
	@Override
	public void reagendaCunsulta(EditaAgendamentoRequest agendamentorequest, UUID idAgendamento, UUID IdPaciente) {
		log.info("[inicia] AgendamentoRestController - reagendaCunsulta");
		agendamentoService.reagendaCunsulta(agendamentorequest, idAgendamento, IdPaciente);
		log.info("[finaliza] AgendamentoRestController - reagendaCunsulta");
	}

	@Override
	public List<AgendamentoPaciente> buscaAgendamentosIdPaciente(UUID IdPaciente) {
		log.info("[inicia] AgendamentoRestController - buscaAgendamentosIdPaciente");
		List<AgendamentoPaciente> agendamentos = agendamentoService.buscaAgendamentosIdPaciente(IdPaciente);
		log.info("[finaliza] AgendamentoRestController - buscaAgendamentosIdPaciente");
		return agendamentos;
	}

	@Override
	public List<AgendamentoMedico> buscaAgendamentosIdMedico(UUID IdMedico) {
		log.info("[inicia] AgendamentoRestController - buscaAgendamentosIdMedico");
		List<AgendamentoMedico> agendamentos = agendamentoService.buscaAgendamentosIdMedico(IdMedico);
		log.info("[finaliza] AgendamentoRestController - buscaAgendamentosIdMedico");
		return agendamentos;
	}

	@Override
	public List<AgendamentoPacienteListResponse> buscaAgendamentosPacientePorData(AgendamentoDataRequest agendamento,
			UUID IdPaciente) {		
		log.info("[inicia] AgendamentoRestController - buscaAgendamentosPacientePorData");
		List<AgendamentoPacienteListResponse> agendamentos = agendamentoService.buscaAgendamentosPacientePorData(agendamento, IdPaciente);
		log.info("[finaliza] AgendamentoRestController - buscaAgendamentosPacientePorData");
		return agendamentos;
	}

	@Override
	public List<AgendamentoMedicoListResponse> buscaAgendamentosMedicoPorData(AgendamentoDataRequest agendamento,
			UUID IdMedico) {
		log.info("[inicia] AgendamentoRestController - buscaAgendamentosMedicoPorData");
		List<AgendamentoMedicoListResponse> agendamentos = agendamentoService.buscaAgendamentosMedicoPorData(agendamento, IdMedico);
		log.info("[finaliza] AgendamentoRestController - buscaAgendamentosMedicoPorData");
		return agendamentos;
	}

	@Override
	public void cancelaAgendamentoPorId(UUID idAgendamento, UUID IdPaciente) {
		log.info("[inicia] AgendamentoRestController - cancelaAgendamentoPorId");
		agendamentoService.cancelaAgendamentoPorId(idAgendamento, IdPaciente);
		log.info("[finaliza] AgendamentoRestController - cancelaAgendamentoPorId");
	}

}
