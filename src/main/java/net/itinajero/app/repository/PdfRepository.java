package net.itinajero.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.itinajero.app.model.DocumentoPdf;
@Repository
public interface PdfRepository extends JpaRepository<DocumentoPdf, Integer> {
	@Query(" select DP from DocumentoPdf DP where DP.fechaEntrada=?1")
	List<DocumentoPdf> findByFecha(Date fecha);
	
	@Query(" select DP from DocumentoPdf DP where DP.folio like %?1%")
	List<DocumentoPdf> findByFolio(String folio);
	

}
