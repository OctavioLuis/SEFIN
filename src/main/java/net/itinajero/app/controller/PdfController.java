package net.itinajero.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.itinajero.app.model.DocumentoPdf;
import net.itinajero.app.service.IPdfService;

@Controller
public class PdfController {
	
	@Autowired
	private IPdfService servicePdf;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String formPdf(@ModelAttribute DocumentoPdf documentoPdf) {				
		return "docPdf/formPdf";
	}
	
	@PostMapping("/save")
	public String guardar(@ModelAttribute DocumentoPdf documentoPdf, BindingResult result, RedirectAttributes attributes) {
		
		if (result.hasErrors()) {
			System.out.println("Existieron errores");
			return "docPdf/formPdf";
		}
		
		servicePdf.insertar(documentoPdf);
		attributes.addFlashAttribute("msg", "Registro Guardado");
		return "redirect:/lista";
	}
	
	@GetMapping("/lista")
	public String mostrarPdf(Model model) {
		model.addAttribute("documentoPdf", servicePdf.buscarTodas());
		return "docPdf/listaPdf";
	}
	
	@GetMapping(value="/edit/{idDucumento}")
	public String editar(@PathVariable("idDucumento") int idDucumento, Model model) {
		DocumentoPdf pdf=servicePdf.buscarPorId(idDucumento);
		model.addAttribute("documentoPdf", pdf);
		return "docPdf/formPdf";
	}
	
	@GetMapping(value="/delete/{id}")
	public String eliminar(@PathVariable("id") int idDocumento, RedirectAttributes attribute) {
		attribute.addFlashAttribute("msg", "La pelicula fue eliminada");
		servicePdf.eliminar(idDocumento);
		return "redirect:/lista";
	}
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
}
