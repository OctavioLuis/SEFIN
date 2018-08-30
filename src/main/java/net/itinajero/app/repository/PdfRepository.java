package net.itinajero.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.itinajero.app.model.DocumentoPdf;
@Repository
public interface PdfRepository extends JpaRepository<DocumentoPdf, Integer> {
	@Query(" select DP from DocumentoPdf DP where DP.fechaEntrada between ?1 and ?2")
	List<DocumentoPdf> findByFecha(Date fecha, Date fecha2);
	
	@Query(" select DP from DocumentoPdf DP where DP.fechaRecibida between ?1 and ?2")
	List<DocumentoPdf> findByFechaRecibido(Date fecha, Date fecha2);
	
	@Query(" select DP from DocumentoPdf DP where DP.folio like %?1%")
	List<DocumentoPdf> findByFolio(String folio);
	
	@Query(" select DP from DocumentoPdf DP where DP.idEncargado = ?1")
	List<DocumentoPdf> findByIDUsuariosEncargado(int idUsuario);
	
	@Query(" select DP from DocumentoPdf DP where DP.quienModifico = ?1")
	List<DocumentoPdf> findByIDUsuariosModifica(int idUsuario);
	
	
	@Query("SELECT MAX(DP.folio)+1 from DocumentoPdf DP")
	String ultimoFolio();
	

}
