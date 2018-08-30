package net.itinajero.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.itinajero.app.model.DocumentoPdf;
import net.itinajero.app.service.IUsuarioService;

@Controller
public class HomeController {
	@Autowired
	private IUsuarioService serviceUsuario;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getHome(@ModelAttribute DocumentoPdf documentoPdf, Model model) {
		model.addAttribute("usuario", serviceUsuario.buscarTodas());		
		return "inicio";
	}

}
