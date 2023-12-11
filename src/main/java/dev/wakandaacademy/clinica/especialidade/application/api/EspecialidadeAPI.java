package dev.wakandaacademy.clinica.especialidade.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/especialidade")
public interface EspecialidadeAPI {
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	EspecialidadeIdResponse criarEspecialidade(@RequestBody @Valid EspecialidadeRequest especialidadeRequest);

	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	List<EspecialidadeListResponse> listaEspecialidade();

	@GetMapping(value = "/{idEspecialidade}")
	@ResponseStatus(code = HttpStatus.OK)
	EspecialidadeResponse buscaEspecialidadePorId(@PathVariable(value = "idEspecialidade") UUID idEspecialidade);

	@DeleteMapping(value = "/{idEspecialidade}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	void deletaEspecialidadePorId(@PathVariable(value = "idEspecialidade") UUID idEspecialidade);

	@PatchMapping(value = "/{idEspecialidade}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	void alteraEspecialidadePorId(@PathVariable(value = "idEspecialidade") UUID idEspecialidade, @RequestBody @Valid EspecialidadeAlteracaoRequest especialidadeRequest);
}
