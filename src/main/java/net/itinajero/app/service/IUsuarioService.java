package net.itinajero.app.service;

import java.util.List;

import net.itinajero.app.model.Usuario;

public interface IUsuarioService {

	void insertar(Usuario usuario);
	List<Usuario> buscarTodas();
	Usuario buscarPorId(int idUsuario);
	void eliminar(int idUsuario);
}
