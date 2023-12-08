package dev.wakandaacademy.clinica.credencial.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Document(collection = "Credencial")
public class Credencial {
	@Id
	@Getter
	private String usuario;
	@NotNull
	@Size(min = 6)
	@Getter(value = AccessLevel.PRIVATE)
	private String senha;
	private String perfil;

	public Credencial(String email, String senha, Perfil perfil) {
		this.usuario = email;
		this.senha = new BCryptPasswordEncoder().encode(senha);
		this.perfil = setSexo(perfil);
	}
	
	public String setSexo(Perfil perfil) {
		if (perfil != null) {
			this.perfil = perfil.getPerfil();
		}
		return this.perfil;
	}
}
