package net.itinajero.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.itinajero.app.model.DocumentoPdf;
import net.itinajero.app.repository.PdfRepository;
@Service
public class PdfServiceImpl implements IPdfService{

	@Autowired
	private PdfRepository pdfRepo;
	@Override
	public List<DocumentoPdf> buscarTodas() {		
		return pdfRepo.findAll();
	}
	@Override
	public void insertar(DocumentoPdf docPdf) {
		pdfRepo.save(docPdf);
		
	}
	@Override
	public DocumentoPdf buscarPorId(int idDocumento) {
		Optional<DocumentoPdf> optional=pdfRepo.findById(idDocumento);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	@Override
	public void eliminar(int idDocumento) {
		pdfRepo.deleteById(idDocumento);
		
	}

}
