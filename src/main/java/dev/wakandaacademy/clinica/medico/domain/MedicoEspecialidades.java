package dev.wakandaacademy.clinica.medico.domain;

import java.util.UUID;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(of = "idEspecialidade")
@Getter
public class MedicoEspecialidades {
	private UUID idEspecialidade;
	private String titlo;
	private String descricao;
	
}
