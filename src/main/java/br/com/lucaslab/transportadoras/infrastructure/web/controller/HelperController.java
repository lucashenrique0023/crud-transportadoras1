package br.com.lucaslab.transportadoras.infrastructure.web.controller;

import org.springframework.ui.Model;

public class HelperController {

	public static void setEditMode(Model model, Boolean isEdit) {
		model.addAttribute("editMode", isEdit);
	}

}
