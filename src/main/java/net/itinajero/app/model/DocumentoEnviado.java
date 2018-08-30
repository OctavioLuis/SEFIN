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
@Table(name="DocumentoEnviado")
public class DocumentoEnviado {
	public DocumentoEnviado() {}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // auto-increment MYSQL
	private int  idDucumento;   
	private String   folio;
	private int   nombreEmisor;  
	private Date fechaEmision = new Date();
	private Date fechaSalida = new Date();
	private Date fechaRecepcion = new Date();
	private String dependenciaReceptora;  	
	private String asunto;
	private String tipo;
	private int quienElaboro;
	 @Lob @Basic(fetch = FetchType.LAZY)
    private File content;
//    private Blob content;
    private String filename;
	private String contentType;
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
	
	public int getNombreEmisor() {
		return nombreEmisor;
	}
	public void setNombreEmisor(int nombreEmisor) {
		this.nombreEmisor = nombreEmisor;
	}
	public Date getFechaEmision() {
		return fechaEmision;
	}
	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}
	public Date getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public Date getFechaRecepcion() {
		return fechaRecepcion;
	}
	public void setFechaRecepcion(Date fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}
	public String getDependenciaReceptora() {
		return dependenciaReceptora;
	}
	public void setDependenciaReceptora(String dependenciaReceptora) {
		this.dependenciaReceptora = dependenciaReceptora;
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
	public int getQuienElaboro() {
		return quienElaboro;
	}
	public void setQuienElaboro(int quienElaboro) {
		this.quienElaboro = quienElaboro;
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
	@Override
	public String toString() {
		return "DocumentoEnviado [idDucumento=" + idDucumento + ", folio=" + folio + ", nombreEmisor=" + nombreEmisor
				+ ", fechaEmision=" + fechaEmision + ", fechaSalida=" + fechaSalida + ", fechaRecepcion="
				+ fechaRecepcion + ", dependenciaReceptora=" + dependenciaReceptora + ", asunto=" + asunto + ", tipo="
				+ tipo + ", quienElaboro=" + quienElaboro + ", content=" + content + ", filename=" + filename
				+ ", contentType=" + contentType + "]";
	}
	
	

}
