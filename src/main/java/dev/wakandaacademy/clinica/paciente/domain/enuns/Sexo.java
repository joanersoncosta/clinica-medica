package dev.wakandaacademy.clinica.paciente.domain.enuns;

public enum Sexo {
	FEMININO("FEMININO"), MASCULINO("MASCULINO");
	
	private String sexo;
	
	Sexo(String  sexo){
		this.sexo = sexo;
	}
	
	public String getSexo() {
		return this.sexo;
	}
	
}
