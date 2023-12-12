package dev.wakandaacademy.clinica.agendamento.appplication.service;

import org.springframework.stereotype.Service;

import dev.wakandaacademy.clinica.agendamento.appplication.api.AgendamentoIdResponse;
import dev.wakandaacademy.clinica.agendamento.appplication.api.AgendamentoRequest;
import dev.wakandaacademy.clinica.agendamento.appplication.repository.AgendamentoRepository;
import dev.wakandaacademy.clinica.agendamento.domain.Agendamento;
import dev.wakandaacademy.clinica.especialidade.application.service.EspecialidadeService;
import dev.wakandaacademy.clinica.especialidade.domain.Especialidade;
import dev.wakandaacademy.clinica.horario.application.service.HorarioPadraoService;
import dev.wakandaacademy.clinica.medico.application.service.MedicoService;
import dev.wakandaacademy.clinica.medico.domain.Medico;
import dev.wakandaacademy.clinica.paciente.application.service.PacienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class AgendamentoApplicationService implements AgendamentoService {
	private final MedicoService medicoService;
	private final PacienteService pacienteService;
	private final EspecialidadeService especialidadeService;
	private final HorarioPadraoService horarioService;
	private final AgendamentoRepository agendamentoRepository;

	@Override
	public AgendamentoIdResponse criaAgendamento(AgendamentoRequest agendamentoRequest) {
		log.info("[inicia] AgendamentoApplicationService - criaAgendamento");
		Medico medico = medicoService.detalhaMedicoPorId(agendamentoRequest.getIdMedico());
		pacienteService.detalhaPacientePorId(agendamentoRequest.getIdPaciente());
		Especialidade especialidade = especialidadeService.detalhaEspecialidadePorId(agendamentoRequest.getIdEspecialidade());
		horarioService.detalhaHorarioPorId(agendamentoRequest.getIdHorario());
		medico.pertenceEspecialidade(especialidade);
		Agendamento agendamento = agendamentoRepository.criaAgendamento(new Agendamento(agendamentoRequest));
		log.info("[finaliza] AgendamentoApplicationService - criaAgendamento");
		return AgendamentoIdResponse.builder().idAgendamento(agendamento.getIdAgendamento()).build();
	}

}
