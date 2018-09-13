package net.itinajero.app.model;

import java.io.File;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;


@Entity
@Table(name="DocumentoPdf")
public class DocumentoPdf {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // auto-increment MYSQL
	private int idDucumento;    
    private String folio;    
    private String nombreEmisor;    
    private Date fechaEntrada =new Date();    
    private int quienModifico =2;    
    private String fechaModificacion ;    
    private String  asunto;
    private String tipo;
    private int idEncargado;
    private Date fechaRecibida =new Date(); ;
    private String dependenciaEmisor;
    
    @Lob @Basic(fetch = FetchType.LAZY)
    private File content;
//    private Blob content;
    private String filename;
	private String contentType;
    
    public DocumentoPdf() {}
    
	public int getIdDucumento() {
		return idDucumento;
	}
	public void setIdDucumento(int idDucumento) {
		this.idDucumento = idDucumento;
	}
	public String getFolio() {
		return folio;
	}
	public void setFolio(String folio) {
		this.folio = folio;
	}
	
	
	


	public String getNombreEmisor() {
		return nombreEmisor;
	}

	public void setNombreEmisor(String nombreEmisor) {
		this.nombreEmisor = nombreEmisor;
	}

	public Date getFechaEntrada() {
		return fechaEntrada;
	}
	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}
	
	
	public int getQuienModifico() {
		return quienModifico;
	}

	public void setQuienModifico(int quienModifico) {
		this.quienModifico = quienModifico;
	}

	
	
	
	public String getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(String fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getIdEncargado() {
		return idEncargado;
	}
	public void setIdEncargado(int idEncargado) {
		this.idEncargado = idEncargado;
	}
	
	
	

	public File getContent() {
		return content;
	}

	public void setContent(File content) {
		this.content = content;
	}

	
	
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public Date getFechaRecibida() {
		return fechaRecibida;
	}

	public void setFechaRecibida(Date fechaRecibida) {
		this.fechaRecibida = fechaRecibida;
	}

	public String getDependenciaEmisor() {
		return dependenciaEmisor;
	}

	public void setDependenciaEmisor(String dependenciaEmisor) {
		this.dependenciaEmisor = dependenciaEmisor;
	}

	@Override
	public String toString() {
		return "DocumentoPdf [idDucumento=" + idDucumento + ", folio=" + folio + ", nombreEmisor=" + nombreEmisor
				+ ", fechaEntrada=" + fechaEntrada + ", quienModifico=" + quienModifico + ", fechaModificacion="
				+ fechaModificacion + ", asunto=" + asunto + ", tipo=" + tipo + ", idEncargado=" + idEncargado
				+ ", fechaRecibida=" + fechaRecibida + ", dependenciaEmisor=" + dependenciaEmisor + ", content="
				+ content + ", filename=" + filename + ", contentType=" + contentType + "]";
	}

	

	



    
}
