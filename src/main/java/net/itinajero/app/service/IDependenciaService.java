package net.itinajero.app.service;

import java.util.List;

import net.itinajero.app.model.Dependencia;

public interface IDependenciaService {
	void insertar(Dependencia dependencia);
	List<Dependencia> buscarTodas();
	List<Dependencia> search(String param);
	Dependencia buscarPorId(int idDependencia);
	void eliminar(int idDependencia);
	
}
