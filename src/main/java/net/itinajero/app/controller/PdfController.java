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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import net.itinajero.app.model.DocumentoPdf;
import net.itinajero.app.service.IDependenciaService;
import net.itinajero.app.service.IPdfService;
import net.itinajero.app.service.IUsuarioService;

@Controller
@RequestMapping("/pdf")
public class PdfController {

	@Autowired
	private IPdfService servicePdf;

	@Autowired
	private IUsuarioService serviceUsuario;
	
	@Autowired
	private IDependenciaService serviceDependencia;

	@RequestMapping(value = "/crear", method = RequestMethod.GET)
	public String formPdf(@ModelAttribute DocumentoPdf documentoPdf, Model model) {
		model.addAttribute("usuario", serviceUsuario.buscarTodas());
		model.addAttribute("dependencia", serviceDependencia.buscarTodas());
		documentoPdf.setFolio(servicePdf.UltimoFolio());
		return "docPdf/formPdf";
	}

	@PostMapping("/save")
	public String guardar(@ModelAttribute DocumentoPdf documentoPdf, BindingResult result,
			RedirectAttributes attributes, @RequestParam("file") MultipartFile file, HttpServletResponse response) {

		if (result.hasErrors()) {
			return "docPdf/formPdf";
		}
		if (!file.isEmpty()) {
			try {

				File destFile = new File(file.getOriginalFilename());
				FileUtils.copyInputStreamToFile(file.getInputStream(), destFile);
				// Blob blob=Hibernate.getLobCreator(sessionfactory.getCurrentSession ()).
				// CreateBlob(file.getInputStream());
				// Blob newContent = session.getLobHelper().createBlob(file.getInputStream(),
				// file.getSize());
				documentoPdf.setFilename(file.getOriginalFilename());
				documentoPdf.setContentType(file.getContentType());
				documentoPdf.setContent(destFile);
			} catch (Exception e) {
				// TODO: handle exception
			}
		} else {
			if (documentoPdf.getIdDucumento() == 0) {

			} else {

				DocumentoPdf doc = servicePdf.buscarPorId(documentoPdf.getIdDucumento());
				documentoPdf.setContent(doc.getContent());
				documentoPdf.setFilename(doc.getFilename());
				documentoPdf.setContentType(doc.getContentType());

			}

		}

		servicePdf.insertar(documentoPdf);
		attributes.addFlashAttribute("msg", "Registro Guardado");
		return "redirect:/pdf/lista";
	}

	@GetMapping("/lista")
	public String mostrarPdf(Model model, @ModelAttribute DocumentoPdf documentoPdf2) {
		model.addAttribute("documentoPdf", servicePdf.buscarTodas());
		model.addAttribute("usuario", serviceUsuario.buscarTodas());
		model.addAttribute("dependencia", serviceDependencia.buscarTodas());
		return "docPdf/listaPdf";
	}

	@RequestMapping(value = "/lista2", method = RequestMethod.POST)
	public String mostrarPdfPorUs(Model model, HttpServletRequest request) {
		model.addAttribute("documentoPdf",
				servicePdf.buscarporIdUsuarioEncargado(Integer.parseInt(request.getParameter("idEncargado"))));
		model.addAttribute("usuario", serviceUsuario.buscarTodas());
		model.addAttribute("usuarioconectado", request.getParameter("idEncargado"));
		model.addAttribute("dependencia", serviceDependencia.buscarTodas());
		return "docPdf/listaPdf";
	}

	@RequestMapping(value = "/lista3", method = RequestMethod.POST)
	public String mostrarPdfPorUsModifica(Model model, HttpServletRequest request) {
		model.addAttribute("documentoPdf",
				servicePdf.buscarporIdUsuarioModifica(Integer.parseInt(request.getParameter("idEncargado"))));
		model.addAttribute("usuario", serviceUsuario.buscarTodas());
		model.addAttribute("usuarioconectado", request.getParameter("idEncargado"));
		model.addAttribute("dependencia", serviceDependencia.buscarTodas());
		return "docPdf/listaPdf";
	}

	@GetMapping(value = "/edit/{idDucumento}")
	public String editar(@PathVariable("idDucumento") int idDucumento, Model model) {
		DocumentoPdf pdf = servicePdf.buscarPorId(idDucumento);
		model.addAttribute("documentoPdf", pdf);
		model.addAttribute("usuario", serviceUsuario.buscarTodas());
		model.addAttribute("dependencia", serviceDependencia.buscarTodas());
		return "docPdf/formPdf";
	}

	@GetMapping(value = "/delete/{id}")
	public String eliminar(@PathVariable("id") int idDocumento, RedirectAttributes attribute) {
		attribute.addFlashAttribute("msg", "La pelicula fue eliminada");
		servicePdf.eliminar(idDocumento);
		return "redirect:/pdf/lista";
	}

	@RequestMapping(value = "/searchByDateEmisio", method = RequestMethod.POST)
	public String buscarPorFechaEmision(@RequestParam("fechaBusqueda") Date fechaBusqueda,
			@RequestParam("fechaBusqueda2") Date fechaBusqueda2, Model model) {
		model.addAttribute("documentoPdf", servicePdf.buscarporFechaEmision(fechaBusqueda, fechaBusqueda2));
		model.addAttribute("usuario", serviceUsuario.buscarTodas());
		return "docPdf/listaPdf";
	}

	@RequestMapping(value = "/searchByDateResibido", method = RequestMethod.POST)
	public String buscarPorFechaRecibido(@RequestParam("fechaBusquedaR") Date fechaBusqueda,
			@RequestParam("fechaBusquedaR2") Date fechaBusqueda2, Model model) {
		model.addAttribute("documentoPdf", servicePdf.buscarporFechaRecibida(fechaBusqueda, fechaBusqueda2));
		model.addAttribute("usuario", serviceUsuario.buscarTodas());
		return "docPdf/listaPdf";
	}

	@RequestMapping(value = "/searchByFolio", method = RequestMethod.POST)
	public String buscarPorFolio(@RequestParam("folio") String folio, Model model) {
		System.out.println("Fecha busqueda: " + folio);
		model.addAttribute("documentoPdf", servicePdf.buscarporFolio(folio));
		model.addAttribute("usuario", serviceUsuario.buscarTodas());
		return "docPdf/listaPdf";
	}

	@RequestMapping("/download/{idDucumento}")
	public String download(@PathVariable("idDucumento") int idDocumento, HttpServletResponse response) {

		DocumentoPdf doc = servicePdf.buscarPorId(idDocumento);

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
