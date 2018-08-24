package net.itinajero.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import net.itinajero.app.model.Usuario;
import net.itinajero.app.service.IUsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private IUsuarioService serviceUsuario;
	
	@RequestMapping(value = "/crear", method = RequestMethod.GET)
	public String formUsuario(@ModelAttribute Usuario usuario) {
		return "usuario/formUsuario";
	}
	
	@PostMapping("/save")
	public String guardar(@ModelAttribute Usuario usuario, BindingResult result, RedirectAttributes attributes) {
		
		if (result.hasErrors()) {
			System.out.println("Existieron errores");
			return "docPdf/formUsuario";
		}
		usuario.setNombreCompleto(usuario.getNombre()+" "+usuario.getApellidoP()+" "+usuario.getMaternoM());
		
		serviceUsuario.insertar(usuario);
		attributes.addFlashAttribute("msg", "Registro Guardado");
		return "redirect:/usuario/lista";
	}
	
	@GetMapping("/lista")
	public String mostrarPdf(Model model) {
		model.addAttribute("usuario", serviceUsuario.buscarTodas());
		return "usuario/listarUsuario";
	}
	
	@GetMapping(value = "/edit/{idUsuario}")
	public String editar(@PathVariable("idUsuario") int idUsuario, Model model) {
		Usuario usuario = serviceUsuario.buscarPorId(idUsuario);
		model.addAttribute("usuario", usuario);
		return "usuario/formUsuario";
	}
	
	@GetMapping(value = "/delete/{idUsuario}")
	public String eliminar(@PathVariable("idUsuario") int idUsuario, RedirectAttributes attribute) {
		attribute.addFlashAttribute("msg", "El usuario fue eliminada");
		serviceUsuario.eliminar(idUsuario);
		return "redirect:/usuario/lista";
	}

} 
