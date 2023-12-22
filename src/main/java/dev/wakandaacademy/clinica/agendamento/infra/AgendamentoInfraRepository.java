package dev.wakandaacademy.clinica.agendamento.infra;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import dev.wakandaacademy.clinica.agendamento.appplication.repository.AgendamentoRepository;
import dev.wakandaacademy.clinica.agendamento.domain.Agendamento;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class AgendamentoInfraRepository implements AgendamentoRepository {
	private final AgendamentoSpringDataMongoRepository agendamentoSpringDataMongoRepository;

	@Override
	public Agendamento salvaAgendamento(Agendamento agendamento) {
		log.info("[inicia] AgendamentoInfraRepository - salvaAgendamento");
			agendamentoSpringDataMongoRepository.save(agendamento);
		log.info("[finaliza] AgendamentoInfraRepository - salvaAgendamento");
		return agendamento;
	}

	@Override
	public Optional<Agendamento> buscaAgendamentoporIdPaciente(UUID idPaciente) {
		log.info("[inicia] AgendamentoInfraRepository - criaAgendamento");
		Optional<Agendamento> agendamento = agendamentoSpringDataMongoRepository.findByIdPaciente(idPaciente);
		log.info("[finaliza] AgendamentoInfraRepository - criaAgendamento");
		return agendamento;
	}

}
