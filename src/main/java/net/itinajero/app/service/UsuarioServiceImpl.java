package net.itinajero.app.service;

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

}
