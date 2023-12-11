package dev.wakandaacademy.clinica.medico.application.service;

import java.util.List;
import java.util.UUID;

import dev.wakandaacademy.clinica.medico.application.api.MedicoCriadoResponse;
import dev.wakandaacademy.clinica.medico.application.api.MedicoIdResponse;
import dev.wakandaacademy.clinica.medico.application.api.MedicoListResponse;
import dev.wakandaacademy.clinica.medico.application.api.MedicoNovoRequest;

public interface MedicoService {
	MedicoIdResponse postNovoMedico(MedicoNovoRequest medicoNovoRequest);
	List<MedicoListResponse> buscaMedicos();
	MedicoCriadoResponse buscaMedicoPorId(UUID idMedico);

}
