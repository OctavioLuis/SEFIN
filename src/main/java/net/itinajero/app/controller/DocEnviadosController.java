package net.itinajero.app.controller;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.itinajero.app.model.DocumentoEnviado;
import net.itinajero.app.service.DocEnviadoService;
import net.itinajero.app.service.IUsuarioService;

@Controller
@RequestMapping("/docenviado")
public class DocEnviadosController {

	@Autowired
	private IUsuarioService serviceUsuario;

	@Autowired
	private DocEnviadoService serviceDocEnviado;

	@RequestMapping(value = "/crear", method = RequestMethod.GET)
	public String formDocEnviado(@ModelAttribute DocumentoEnviado documentoEnviado, Model model) {
		model.addAttribute("usuario", serviceUsuario.buscarTodas());
		documentoEnviado.setFolio(serviceDocEnviado.UltimoFolio());
		return "docEnviado/formDocEnviado";

	}

	@PostMapping("/save")
	public String guardar(@ModelAttribute DocumentoEnviado documentoEnviado, BindingResult result,
			RedirectAttributes attributes, @RequestParam("file") MultipartFile file, HttpServletResponse response) {

		if (result.hasErrors()) {
			return "docPdf/formPdf";
		}
		if (!file.isEmpty()) {
			try {

				File destFile = new File(file.getOriginalFilename());
				FileUtils.copyInputStreamToFile(file.getInputStream(), destFile);
				documentoEnviado.setFilename(file.getOriginalFilename());
				documentoEnviado.setContentType(file.getContentType());
				documentoEnviado.setContent(destFile);				
			} catch (Exception e) {
				// TODO: handle exception
			}
		} else {
			if (documentoEnviado.getIdDucumento() == 0) {
				
			} else {

				DocumentoEnviado doc = serviceDocEnviado.buscarPorId(documentoEnviado.getIdDucumento());
				documentoEnviado.setContent(doc.getContent());
				documentoEnviado.setFilename(doc.getFilename());
				documentoEnviado.setContentType(doc.getContentType());
				
			}

		}

		serviceDocEnviado.insertar(documentoEnviado);
		attributes.addFlashAttribute("msg", "Registro Guardado");
		return "redirect:/docenviado/lista";
	}

	@GetMapping("/lista")
	public String mostrarPdf(Model model, @ModelAttribute DocumentoEnviado documentoEnviado) {
		model.addAttribute("documentoEnviado", serviceDocEnviado.buscarTodas());
		model.addAttribute("usuario", serviceUsuario.buscarTodas());
		return "docEnviado/listaDocEnviado";
	}

	@RequestMapping(value = "/lista2", method = RequestMethod.POST)
	public String mostrarPdfPorUsEmitio(Model model, HttpServletRequest request) {
		model.addAttribute("documentoEnviado",
				serviceDocEnviado.buscarporIdUsuarioEmisor(Integer.parseInt(request.getParameter("quienElaboro"))));
		model.addAttribute("usuario", serviceUsuario.buscarTodas());
		model.addAttribute("usuarioconectado", request.getParameter("quienElaboro"));
		return "docEnviado/listaDocEnviado";
	}

	@RequestMapping(value = "/lista3", method = RequestMethod.POST)
	public String mostrarPdfPorUsModifica(Model model, HttpServletRequest request) {
		model.addAttribute("documentoEnviado",
				serviceDocEnviado.buscarporIdUsuarioElaboro(Integer.parseInt(request.getParameter("quienElaboro"))));
		model.addAttribute("usuario", serviceUsuario.buscarTodas());
		model.addAttribute("usuarioconectado", request.getParameter("quienElaboro"));
		return "docEnviado/listaDocEnviado";
	}

	@GetMapping(value = "/edit/{idDucumento}")
	public String editar(@PathVariable("idDucumento") int idDucumento, Model model) {
		DocumentoEnviado docEnviado = serviceDocEnviado.buscarPorId(idDucumento);
		model.addAttribute("documentoEnviado", docEnviado);
		model.addAttribute("usuario", serviceUsuario.buscarTodas());
		return "docEnviado/formDocEnviado";
	}

	@GetMapping(value = "/delete/{id}")
	public String eliminar(@PathVariable("id") int idDocumento, RedirectAttributes attribute) {
		attribute.addFlashAttribute("msg", "La pelicula fue eliminada");
		serviceDocEnviado.eliminar(idDocumento);
		return "redirect:/docenviado/lista";
	}

	@RequestMapping(value = "/searchByDateEmisio", method = RequestMethod.POST)
	public String buscarPorFechaEmision(@RequestParam("fechaBusqueda") Date fechaBusqueda,
			@RequestParam("fechaBusqueda2") Date fechaBusqueda2, Model model) {
		model.addAttribute("documentoEnviado", serviceDocEnviado.buscarporFechaEmision(fechaBusqueda, fechaBusqueda2));
		model.addAttribute("usuario", serviceUsuario.buscarTodas());
		return "docEnviado/listaDocEnviado";
	}

	@RequestMapping(value = "/searchByDateSalida", method = RequestMethod.POST)
	public String buscarPorFechaRecibido(@RequestParam("fechaBusquedaS") Date fechaBusqueda,
			@RequestParam("fechaBusquedaS2") Date fechaBusqueda2, Model model) {
		model.addAttribute("documentoEnviado", serviceDocEnviado.buscarporFechaSalida(fechaBusqueda, fechaBusqueda2));
		model.addAttribute("usuario", serviceUsuario.buscarTodas());
		return "docEnviado/listaDocEnviado";
	}

	@RequestMapping(value = "/searchByFolio", method = RequestMethod.POST)
	public String buscarPorFolio(@RequestParam("folio") String folio, Model model) {
		model.addAttribute("documentoEnviado", serviceDocEnviado.buscarporFolio(folio));
		model.addAttribute("usuario", serviceUsuario.buscarTodas());
		return "docEnviado/listaDocEnviado";
	}

	@RequestMapping("/download/{idDucumento}")
	public String download(@PathVariable("idDucumento") int idDocumento, HttpServletResponse response) {

		DocumentoEnviado doc = serviceDocEnviado.buscarPorId(idDocumento);

		try {
			response.setHeader("Content-Disposition", "inline;filename=\"" + doc.getFilename() + "\"");
			OutputStream out = response.getOutputStream();
			response.setContentType(doc.getContentType());
			FileUtils.copyFile(doc.getContent(), out);
			out.flush();
			out.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}
