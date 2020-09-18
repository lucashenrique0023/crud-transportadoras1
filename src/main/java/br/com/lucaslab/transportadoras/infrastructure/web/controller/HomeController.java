package br.com.lucaslab.transportadoras.infrastructure.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import br.com.lucaslab.transportadoras.application.service.TransportadoraService;
import br.com.lucaslab.transportadoras.domain.transportadoras.Transportadora;
import br.com.lucaslab.transportadoras.domain.transportadoras.TransportadoraFilter;

@Controller
public class HomeController {
	
	@Autowired
	private TransportadoraService transportadoraService;

	@GetMapping(path = { "/" , "/home" })
	public String home(@ModelAttribute("transportadoraFilter") TransportadoraFilter filter,
			Model model) {
		
		List<Transportadora> transportadoras = transportadoraService.listarTransportadoras(filter);
		
		// TODO: Reutilizar lista transportadoras para filtrar ?
		
		List<Object[]> transportadorasUF = transportadoraService.listarTransportadorasPorCaracteristicas(filter, "estado");
		List<Object[]> transportadorasCidades = transportadoraService.listarTransportadorasPorCaracteristicas(filter, "cidades");
		List<Object[]> transportadorasModais = transportadoraService.listarTransportadorasPorCaracteristicas(filter, "modais");
		
		model.addAttribute("transportadoraFilter", filter);
		model.addAttribute("transportadoras", transportadoras);
		model.addAttribute("transportadorasUF", transportadorasUF);
		model.addAttribute("transportadorasCidades", transportadorasCidades);
		model.addAttribute("transportadorasModais", transportadorasModais);
		
		return "index";
	}
	
	@GetMapping(path = "cadastro")
	public String cadastro() {
		return "cadastro";
	}
}
