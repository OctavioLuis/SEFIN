package net.itinajero.app.service;

import java.util.Date;
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
	@Override
	public List<DocumentoPdf> buscarporFechaEmision(Date fecha, Date fecha2) {
		// TODO Auto-generated method stub
		return pdfRepo.findByFecha(fecha, fecha2 );
	}
	@Override
	public List<DocumentoPdf> buscarporFolio(String folio) {
		// TODO Auto-generated method stub
		return pdfRepo.findByFolio(folio);
	}
	@Override
	public List<DocumentoPdf> buscarporFechaRecibida(Date fecha, Date fecha2) {
		// TODO Auto-generated method stub
		return pdfRepo.findByFechaRecibido(fecha, fecha2);
	}
	@Override
	public List<DocumentoPdf> buscarporIdUsuarioEncargado(int idUsuario) {
		// TODO Auto-generated method stub
		return pdfRepo.findByIDUsuariosEncargado(idUsuario);
	}
	@Override
	public List<DocumentoPdf> buscarporIdUsuarioModifica(int idUsuario) {
		// TODO Auto-generated method stub
		return pdfRepo.findByIDUsuariosModifica(idUsuario);
	}
	@Override
	public String UltimoFolio() {
		// TODO Auto-generated method stub
		return pdfRepo.ultimoFolio();
	}

}
