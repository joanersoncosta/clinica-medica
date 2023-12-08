package dev.wakandaacademy.clinica.medico.application.service;

import dev.wakandaacademy.clinica.medico.application.api.MedicoIdResponse;
import dev.wakandaacademy.clinica.medico.application.api.MedicoNovoRequest;

public interface MedicoService {
	MedicoIdResponse postNovoMedico(MedicoNovoRequest medicoNovoRequest);

}
