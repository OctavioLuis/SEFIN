package net.itinajero.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.itinajero.app.model.Usuario;
import net.itinajero.app.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements IUsuarioService{
	
	@Autowired
	private UsuarioRepository usuarioRepo;
	@Override
	public void insertar(Usuario usuario) {
		usuarioRepo.save(usuario);
		
	}
	@Override
	public List<Usuario> buscarTodas() {		
		return usuarioRepo.findAll();
	}
	@Override
	public Usuario buscarPorId(int idUsuario) {
		Optional<Usuario> usuario=usuarioRepo.findById(idUsuario);
		if(usuario.isPresent()) {
			return usuario.get();
		}
		return null;
	}
	@Override
	public void eliminar(int idUsuario) {
		usuarioRepo.deleteById(idUsuario);
		
	}

}
