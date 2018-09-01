package net.itinajero.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.itinajero.app.model.Dependencia;

@Repository
public interface DependenciaRepository extends JpaRepository<Dependencia, Integer> {

	@Query(" select DE from Dependencia DE where DE.nombre like %?1%")
	List<Dependencia> autoAcompletado(String nombre);
}
