package net.itinajero.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.itinajero.app.model.Dependencia;
import net.itinajero.app.model.Usuario;
import net.itinajero.app.service.IDependenciaService;

@Controller
@RequestMapping("/dependencia")
public class DependenciaController {

	@Autowired
	private IDependenciaService serviceDependencia;

	@RequestMapping(value = "/crear", method = RequestMethod.GET)
	public String formDependencia(@ModelAttribute Dependencia dependencia) {
		return "dependencia/formDependencia";
	}

	@PostMapping("/save")
	public String guardar(@ModelAttribute Dependencia dependencia, BindingResult result,
			RedirectAttributes attributes) {

		if (result.hasErrors()) {
			return "docPdf/formUsuario";
		}

		serviceDependencia.insertar(dependencia);
		attributes.addFlashAttribute("msg", "Registro Guardado");
		return "redirect:/dependencia/lista";
	}

	@GetMapping("/lista")
	public String mostrarPdf(Model model) {
		model.addAttribute("dependencia", serviceDependencia.buscarTodas());
		return "dependencia/listarDependencia";
	}
	
	@GetMapping(value = "/edit/{idDependencia}")
	public String editar(@PathVariable("idDependencia") int idDependencia, Model model) {
		Dependencia dependencia = serviceDependencia.buscarPorId(idDependencia);
		model.addAttribute("dependencia", dependencia);
		return "dependencia/formDependencia";
	}
	
	@GetMapping(value = "/delete/{idDependencia}")
	public String eliminar(@PathVariable("idDependencia") int idDependencia, RedirectAttributes attribute) {
		attribute.addFlashAttribute("msg", "la dependencia fue eliminada");
		serviceDependencia.eliminar(idDependencia);
		return "redirect:/dependencia/lista";
	}
	
	@RequestMapping(value = "search", method = RequestMethod.GET)
	@ResponseBody
	public List<Dependencia> search(HttpServletRequest request) {
		System.out.println("resuterm : "+request.getParameter("term"));		
		return serviceDependencia.search(request.getParameter("term"));
	}
}
