package dev.wakandaacademy.clinica.credencial.application.service;

import org.springframework.stereotype.Service;

import dev.wakandaacademy.clinica.credencial.application.repository.CredencialRepository;
import dev.wakandaacademy.clinica.credencial.domain.Credencial;
import dev.wakandaacademy.clinica.paciente.application.api.PacienteNovoRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class CredencialApplicationService implements CredencialService {
	private final CredencialRepository credencialRepository;

	@Override
	public Credencial salvaCredencial(PacienteNovoRequest paciente) {
		log.info("[inicia] CredencialApplicationService - salvaCredencial");
		Credencial credencial = credencialRepository.salvaCredencial(new Credencial(paciente.getEmail(), paciente.getSenha(), paciente.getPerfil()));
		log.info("[finaliza] CredencialApplicationService - salvaCredencial");
		return credencial;
	}

}
