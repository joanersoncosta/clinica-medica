package dev.wakandaacademy.clinica.agendamento.appplication.service;

import org.springframework.stereotype.Service;

import dev.wakandaacademy.clinica.agendamento.appplication.api.AgendamentoIdResponse;
import dev.wakandaacademy.clinica.agendamento.appplication.api.AgendamentoRequest;
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

	@Override
	public AgendamentoIdResponse criaAgendamento(AgendamentoRequest agendamento) {
		log.info("[inicia] AgendamentoApplicationService - criaAgendamento");
		Medico medico = medicoService.detalhaMedicoPorId(agendamento.getIdMedico());
		pacienteService.detalhaPacientePorId(agendamento.getIdPaciente());
		Especialidade especialidade = especialidadeService.detalhaEspecialidadePorId(agendamento.getIdEspecialidade());
		horarioService.detalhaHorarioPorId(agendamento.getIdHorario());
		medico.pertenceEspecialidade(especialidade);
		
		log.info("[finaliza] AgendamentoApplicationService - criaAgendamento");
		return null;
	}

}
