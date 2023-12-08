package dev.wakandaacademy.clinica.credencial.application.service;

import dev.wakandaacademy.clinica.credencial.domain.Credencial;
import dev.wakandaacademy.clinica.paciente.application.api.PacienteNovoRequest;

public interface CredencialService {
	Credencial salvaCredencial(PacienteNovoRequest paciente);
	Credencial buscaCredencialPorUsuario(String usuario);
}
