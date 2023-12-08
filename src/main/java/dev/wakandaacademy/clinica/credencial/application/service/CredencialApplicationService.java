package dev.wakandaacademy.clinica.credencial.application.service;

import org.springframework.stereotype.Service;

import dev.wakandaacademy.clinica.credencial.domain.Credencial;
import dev.wakandaacademy.clinica.paciente.application.api.PacienteNovoRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class CredencialApplicationService implements CredencialService {

	@Override
	public Credencial salvaCredencial(PacienteNovoRequest paciente) {
		log.info("[inicia] CredencialApplicationService - salvaCredencial");
		log.info("[finaliza] CredencialApplicationService - salvaCredencial");
		return null;
	}

}
