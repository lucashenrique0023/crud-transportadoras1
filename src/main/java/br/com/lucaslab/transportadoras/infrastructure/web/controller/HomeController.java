package br.com.lucaslab.transportadoras.infrastructure.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import br.com.lucaslab.transportadoras.application.service.TransportadoraService;
import br.com.lucaslab.transportadoras.domain.transportadoras.ContadorTransportadora;
import br.com.lucaslab.transportadoras.domain.transportadoras.RetornoFiltroTransportadora;
import br.com.lucaslab.transportadoras.domain.transportadoras.Transportadora;
import br.com.lucaslab.transportadoras.domain.transportadoras.TransportadoraFilter;

@Controller
public class HomeController {
	
	@Autowired
	private TransportadoraService transportadoraService;
	
	@Autowired
	private List<ContadorTransportadora> contadorTransportadora;

	@GetMapping(path = { "/" , "/home" })
	public String home(@ModelAttribute("transportadoraFilter") TransportadoraFilter filter,
			Model model) {
		
		List<Transportadora> transportadoras = transportadoraService.listarTransportadoras(filter);
		
		contadorTransportadora.forEach((ContadorTransportadora i) -> {
			RetornoFiltroTransportadora retorno = i.processar(transportadoras);
			model.addAttribute(retorno.getNome(), retorno.getItens());
		}); 
		
		model.addAttribute("transportadoras", transportadoras);
		
		return "index";
	}
	
	@GetMapping(path = "cadastro")
	public String cadastro() {
		return "cadastro";
	}
}
