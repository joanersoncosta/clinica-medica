package dev.wakandaacademy.clinica.credencial.infra;

import org.springframework.data.mongodb.repository.MongoRepository;

import dev.wakandaacademy.clinica.credencial.domain.Credencial;

public interface CredencialSpringMongoDBRepository extends MongoRepository<Credencial, String>{
	Credencial findByUsuario(String usuario);

}
