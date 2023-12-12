package dev.wakandaacademy.clinica.horario.application.api;

import java.time.LocalTime;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class HorarioPadraoRequest {
	@NotNull(message = "Campo horáio não pode ser nulo!")
	private LocalTime horario;
}
