package dev.wakandaacademy.clinica.credencial.domain;

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
