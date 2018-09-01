package net.itinajero.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.itinajero.app.model.Dependencia;
import net.itinajero.app.repository.DependenciaRepository;

@Service
public class DependenciaImpl implements IDependenciaService{

	@Autowired
	private DependenciaRepository repoDependencia;
	
	@Override
	public void insertar(Dependencia dependencia) {
		repoDependencia.save(dependencia);
		
	}

	@Override
	public List<Dependencia> buscarTodas() {
		// TODO Auto-generated method stub
		return repoDependencia.findAll();
	}

	@Override
	public Dependencia buscarPorId(int idDependencia) {
		Optional<Dependencia> op=repoDependencia.findById(idDependencia);
		if(op.isPresent()) {
			return op.get();
		}
		return null;
	}

	@Override
	public void eliminar(int idDependencia) {
		repoDependencia.deleteById(idDependencia);
		
	}

	@Override
	public List<Dependencia> search(String param) {
		// TODO Auto-generated method stub
		return repoDependencia.autoAcompletado(param);
	}

}
