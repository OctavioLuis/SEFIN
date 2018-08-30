package net.itinajero.app.service;

import java.util.Date;
import java.util.List;

import net.itinajero.app.model.DocumentoEnviado;

public interface DocEnviadoService {
	List<DocumentoEnviado> buscarTodas();
	void insertar(DocumentoEnviado docEnviado);
	DocumentoEnviado buscarPorId(int idDocumento);
	void eliminar(int idDocumento);
	List<DocumentoEnviado> buscarporFechaEmision(Date fecha, Date fecha2);
	List<DocumentoEnviado> buscarporFechaSalida(Date fecha, Date fecha2);
	List<DocumentoEnviado> buscarporFolio(String folio);
	List<DocumentoEnviado> buscarporIdUsuarioEmisor(int idUsuario);
	List<DocumentoEnviado> buscarporIdUsuarioElaboro(int idUsuario);
	String UltimoFolio();

}
