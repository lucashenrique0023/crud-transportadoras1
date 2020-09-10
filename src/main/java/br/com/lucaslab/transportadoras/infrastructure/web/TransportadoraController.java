package br.com.lucaslab.transportadoras.infrastructure.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.lucaslab.transportadoras.application.service.TransportadoraService;
import br.com.lucaslab.transportadoras.domain.transportadoras.Transportadora;

@Controller
@RequestMapping("/transportadoras")
public class TransportadoraController {

	@Autowired
	private TransportadoraService transportadoraService;

	@PostMapping(path = "/save")
	public void save(@RequestBody Transportadora transportadora, HttpServletResponse response) {
		transportadoraService.saveTransportadora(transportadora);
	}

}
