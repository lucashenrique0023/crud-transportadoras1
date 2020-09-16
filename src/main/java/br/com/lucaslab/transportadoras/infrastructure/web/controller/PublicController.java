package br.com.lucaslab.transportadoras.infrastructure.web.controller;

import javax.validation.Valid;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.lucaslab.transportadoras.application.service.TransportadoraService;
import br.com.lucaslab.transportadoras.domain.transportadoras.Transportadora;

@Controller
@RequestMapping("/public")
public class PublicController {

	@Autowired
	private TransportadoraService transportadoraService;

	@GetMapping(path = "/transportadora/new")
	public String newTransportadora(Model model) {
		
		model.addAttribute("transportadora" , new Transportadora());
		HelperController.setEditMode(model, false);
		
		return "transportadora-cadastro";
	}
	
	@PostMapping(path = "/transportadora/save")
	public String saveTransportadora(@ModelAttribute("transportadora") @Valid Transportadora transportadora,
			Errors errors,
			Model model) {
		
		if (!errors.hasErrors()) {
			try {
				transportadoraService.saveTransportadora(transportadora);
				model.addAttribute("msg", "Transportadora cadastrada com sucesso!");
			} catch (ValidationException ex) {
				errors.rejectValue("email",  null, ex.getMessage());
			}
		}
		
		
		HelperController.setEditMode(model, false);	
		return "transportadora-cadastro";
	}
	
	

}
