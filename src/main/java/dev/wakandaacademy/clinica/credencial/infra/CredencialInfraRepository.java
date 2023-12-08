package dev.wakandaacademy.clinica.credencial.infra;

import org.springframework.stereotype.Repository;

import dev.wakandaacademy.clinica.credencial.application.repository.CredencialRepository;
import dev.wakandaacademy.clinica.credencial.domain.Credencial;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@RequiredArgsConstructor
@Log4j2
public class CredencialInfraRepository implements CredencialRepository {
	private final CredencialSpringMongoDBRepository credencialSpringMongoRepository;

	@Override
	public Credencial salvaCredencial(Credencial credencial) {
		log.info("[inicia] CredencialInfraRepository - salvaCredencial");
		credencialSpringMongoRepository.save(credencial);
		log.info("[finaliza] CredencialInfraRepository - salvaCredencial");
		return credencial;
	}
	
	@Override
	public Credencial buscaCredencialPorUsuario(String usuario) {
		log.info("[inicia] CredencialInfraRepository - buscaCredencialPorUsuario");
		Credencial credencial = credencialSpringMongoRepository.findByUsuario(usuario);
		log.info("[finaliza] CredencialInfraRepository - buscaCredencialPorUsuario");
		return credencial;
	}

}
