package net.itinajero.app.service;

import java.util.Date;
import java.util.List;

import net.itinajero.app.model.DocumentoPdf;

public interface IPdfService {
	List<DocumentoPdf> buscarTodas();
	void insertar(DocumentoPdf docPdf);
	DocumentoPdf buscarPorId(int idDocumento);
	void eliminar(int idDocumento);
	List<DocumentoPdf> buscarporFechaEmision(Date fecha, Date fecha2);
	List<DocumentoPdf> buscarporFechaRecibida(Date fecha, Date fecha2);
	List<DocumentoPdf> buscarporFolio(String folio);
	List<DocumentoPdf> buscarporIdUsuarioEncargado(int idUsuario);
	List<DocumentoPdf> buscarporIdUsuarioModifica(int idUsuario);
	String UltimoFolio();
}
