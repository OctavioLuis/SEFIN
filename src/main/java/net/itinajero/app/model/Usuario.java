package net.itinajero.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // auto-increment MYSQL
	 private int idUsuario; 
	 private String usuario;
	 private String nombre;
	 private String apellidoP;
	 private String maternoM;
	 private String cargo;
	 private String pasw;
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidoP() {
		return apellidoP;
	}
	public void setApellidoP(String apellidoP) {
		this.apellidoP = apellidoP;
	}
	public String getMaternoM() {
		return maternoM;
	}
	public void setMaternoM(String maternoM) {
		this.maternoM = maternoM;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getPasw() {
		return pasw;
	}
	public void setPasw(String pasw) {
		this.pasw = pasw;
	}
	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", usuario=" + usuario + ", nombre=" + nombre + ", apellidoP="
				+ apellidoP + ", maternoM=" + maternoM + ", cargo=" + cargo + ", pasw=" + pasw + "]";
	}
	 
	 

}
