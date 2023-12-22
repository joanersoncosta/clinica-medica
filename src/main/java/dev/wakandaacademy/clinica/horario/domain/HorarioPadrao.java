package dev.wakandaacademy.clinica.horario.domain;

import java.time.LocalTime;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Document(collection = "HorarioPadrao")
public class HorarioPadrao {
	
	@Id
	private UUID idHorarioPadrao;
	@Indexed
	private LocalTime horario;
	
	public HorarioPadrao(LocalTime horarioGerado) {
		this.idHorarioPadrao = UUID.randomUUID();
		this.horario = horarioGerado;
	}

}
