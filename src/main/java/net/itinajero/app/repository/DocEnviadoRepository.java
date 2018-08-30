package net.itinajero.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.itinajero.app.model.DocumentoEnviado;


@Repository
public interface DocEnviadoRepository extends JpaRepository<DocumentoEnviado, Integer> {
	@Query(" select DE from DocumentoEnviado DE where DE.fechaEmision between ?1 and ?2")
	List<DocumentoEnviado> findByFechaEmision(Date fecha, Date fecha2);
	
	@Query(" select DE from DocumentoEnviado DE where DE.fechaSalida between ?1 and ?2")
	List<DocumentoEnviado> findByFechaSalida(Date fecha, Date fecha2);
	
	@Query(" select DE from DocumentoEnviado DE where DE.folio like %?1%")
	List<DocumentoEnviado> findByFolio(String folio);
	
	@Query("SELECT MAX(DE.folio)+1 from DocumentoEnviado DE")
	String ultimoFolio();
	
	@Query(" select DE from DocumentoEnviado DE where DE.nombreEmisor = ?1")
	List<DocumentoEnviado> findByIDUsuariosEmisor(int idUsuario);
	
	@Query(" select DE from DocumentoEnviado DE where DE.quienElaboro = ?1")
	List<DocumentoEnviado> findByIDUsuariosElaboro(int idUsuario);
	

}
