package net.itinajero.app.service;

import java.util.List;

import net.itinajero.app.model.DocumentoPdf;

public interface IPdfService {
	List<DocumentoPdf> buscarTodas();
	void insertar(DocumentoPdf docPdf);
	DocumentoPdf buscarPorId(int idDocumento);
	void eliminar(int idDocumento);
}
