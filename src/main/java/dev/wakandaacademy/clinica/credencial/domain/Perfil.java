package dev.wakandaacademy.clinica.credencial.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Document(collection = "Perfil")
public enum Perfil {
	ADMIN("ADMIN"), PACIENTE("PACIENTE"), MEDICO("MEDICO");
	
	private String perfil;
	
	Perfil(String perfil) {
		this.perfil = perfil;
	}
	
	public String getPerfil() {
		return this.perfil;
	}
	
	public static Perfil verificaPerfil(String perfil){
		for (Perfil valorCorrespondente: Perfil.values()) {
			if(valorCorrespondente.getPerfil() == perfil) {
				return valorCorrespondente;
			}
		}
		throw new IllegalArgumentException("Valor invalido");
	}
}
