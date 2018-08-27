package net.itinajero.app.service;

import java.util.Date;
import java.util.List;

import net.itinajero.app.model.DocumentoPdf;

public interface IPdfService {
	List<DocumentoPdf> buscarTodas();
	void insertar(DocumentoPdf docPdf);
	DocumentoPdf buscarPorId(int idDocumento);
	void eliminar(int idDocumento);
	List<DocumentoPdf> buscarporFecha(Date fecha);
	List<DocumentoPdf> buscarporFolio(String folio);
}
