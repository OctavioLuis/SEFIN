package net.itinajero.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.itinajero.app.model.DocumentoPdf;
@Repository
public interface PdfRepository extends JpaRepository<DocumentoPdf, Integer> {

}
