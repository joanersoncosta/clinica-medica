package dev.wakandaacademy.clinica.horario.application.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/horario")
public interface HorarioPadraoAPI {

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	String criaHorario();
	
	@GetMapping(value = "/lista")
	@ResponseStatus(code = HttpStatus.OK)
	List<HorarioPadraoListResponse> getListHorarioPadrao();
}
