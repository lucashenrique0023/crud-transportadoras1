package br.com.lucaslab.transportadoras.infrastructure.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.ui.Model;
import br.com.lucaslab.transportadoras.domain.transportadoras.Transportadora;
import br.com.lucaslab.transportadoras.domain.transportadoras.TransportadoraRepository;

@Controller
public class HomeController {
	
	@Autowired
	private TransportadoraRepository transportadoraRepository;

	@GetMapping(path = { "/" , "/home" })
	public String home(Model model) {
		
		List<Transportadora> transportadoras = transportadoraRepository.findAll();
		
		model.addAttribute("transportadoras", transportadoras);
		
		return "index";
	}
	
	@GetMapping(path = "cadastro")
	public String cadastro() {
		return "cadastro";
	}
}
