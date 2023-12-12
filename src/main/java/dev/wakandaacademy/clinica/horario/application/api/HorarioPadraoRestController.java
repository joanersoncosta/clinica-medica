package dev.wakandaacademy.clinica.horario.application.api;

import org.springframework.web.bind.annotation.RestController;

import dev.wakandaacademy.clinica.horario.application.service.HorarioPadraoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequiredArgsConstructor
@Log4j2
public class HorarioPadraoRestController implements HorarioPadraoAPI {
	private final HorarioPadraoService horarioPadraoService;
	
	@Override
	public String criaHorario() {
		log.info("[inicia] HorarioPadraoRestController - criaHorario");
		String mensagemPadrao = "Horário Padrão cadastrado com sucesso!";
		horarioPadraoService.criahorarioPadrao();
		log.info("[finaliza] HorarioPadraoRestController - criaHorario");
		return mensagemPadrao;
	}

}
