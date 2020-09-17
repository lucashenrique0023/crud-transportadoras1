package br.com.lucaslab.transportadoras.infrastructure.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;

import br.com.lucaslab.transportadoras.application.service.TransportadoraService;
import br.com.lucaslab.transportadoras.domain.transportadoras.Transportadora;
import br.com.lucaslab.transportadoras.domain.transportadoras.TransportadoraFilter;
import br.com.lucaslab.transportadoras.domain.transportadoras.TransportadoraRepository;

@Controller
public class HomeController {
	
	@Autowired
	private TransportadoraRepository transportadoraRepository;
	
	@Autowired
	private TransportadoraService transportadoraService;

	@GetMapping(path = { "/" , "/home" })
	public String home(@ModelAttribute("transportadoraFilter") TransportadoraFilter filter,
			Model model) {
		
		List<Transportadora> transportadoras = transportadoraService.listarTransportadoras(filter);
		List<Object[]> transportadorasUF = transportadoraRepository.findTransportadorasUF();
		List<Object[]> transportadorasCidades = transportadoraRepository.findTransportadorasCidades();
		List<Object[]> transportadorasModais = transportadoraRepository.findTransportadorasModais();
		
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
