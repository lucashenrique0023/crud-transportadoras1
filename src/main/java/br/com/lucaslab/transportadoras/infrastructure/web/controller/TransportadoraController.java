package br.com.lucaslab.transportadoras.infrastructure.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.lucaslab.transportadoras.application.service.TransportadoraService;
import br.com.lucaslab.transportadoras.domain.transportadoras.Transportadora;
import br.com.lucaslab.transportadoras.domain.transportadoras.TransportadoraRepository;

@Controller
@RequestMapping(path = "transportadora")
public class TransportadoraController {

	@Autowired
	private TransportadoraRepository transportadoraRepository;
	
	@Autowired
	private TransportadoraService transportadoraService;
	
	@GetMapping(path = "/edit")
	public String edit(Model model,
			@RequestParam("transportadoraId") Integer transportadoraId) {
		
		Transportadora transportadora = transportadoraRepository.findById(transportadoraId).orElseThrow();
		
		model.addAttribute("transportadora", transportadora);
		HelperController.setEditMode(model, true);
		
		return "transportadora-cadastro";	
	}
	
	@PostMapping(path = "/save")
	public String save(@ModelAttribute("transportadora") Transportadora transportadora,
			Model model) {
		
		transportadoraService.saveTransportadora(transportadora);
		model.addAttribute("msg", "Transportadora gravada com sucesso!");
		HelperController.setEditMode(model, true);
		
		return "transportadora-cadastro";
	}

}
