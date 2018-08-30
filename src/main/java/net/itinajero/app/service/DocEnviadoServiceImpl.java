package net.itinajero.app.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.itinajero.app.model.DocumentoEnviado;
import net.itinajero.app.repository.DocEnviadoRepository;

@Service
public class DocEnviadoServiceImpl implements DocEnviadoService{
	
	@Autowired
	private DocEnviadoRepository repoDocEnviado;

	@Override
	public List<DocumentoEnviado> buscarTodas() {
		// TODO Auto-generated method stub
		return repoDocEnviado.findAll();
	}

	@Override
	public void insertar(DocumentoEnviado docEnviado) {
		repoDocEnviado.save(docEnviado);
		
	}

	@Override
	public DocumentoEnviado buscarPorId(int idDocumento) {
		Optional<DocumentoEnviado> optional=repoDocEnviado.findById(idDocumento);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public void eliminar(int idDocumento) {
		repoDocEnviado.deleteById(idDocumento);
		
	}

	@Override
	public List<DocumentoEnviado> buscarporFechaEmision(Date fecha, Date fecha2) {
		// TODO Auto-generated method stub
		return repoDocEnviado.findByFechaEmision(fecha, fecha2);
	}

	@Override
	public List<DocumentoEnviado> buscarporFechaSalida(Date fecha, Date fecha2) {
		// TODO Auto-generated method stub
		return repoDocEnviado.findByFechaSalida(fecha, fecha2);
	}

	@Override
	public List<DocumentoEnviado> buscarporFolio(String folio) {
		// TODO Auto-generated method stub
		return repoDocEnviado.findByFolio(folio);
	}

	@Override
	public List<DocumentoEnviado> buscarporIdUsuarioEmisor(int idUsuario) {
		// TODO Auto-generated method stub
		return repoDocEnviado.findByIDUsuariosEmisor(idUsuario);
	}

	@Override
	public List<DocumentoEnviado> buscarporIdUsuarioElaboro(int idUsuario) {
		// TODO Auto-generated method stub
		return repoDocEnviado.findByIDUsuariosElaboro(idUsuario);
	}

	@Override
	public String UltimoFolio() {
		// TODO Auto-generated method stub
		return repoDocEnviado.ultimoFolio();
	}

}
