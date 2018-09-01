package net.itinajero.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Dependencia")
public class Dependencia {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // auto-increment MYSQL
	 private int idDependencia;   
	 private String nombre;
	 
	 public Dependencia() {}

	public int getIdDependencia() {
		return idDependencia;
	}

	public void setIdDependencia(int idDependencia) {
		this.idDependencia = idDependencia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Dependencia [idDependencia=" + idDependencia + ", nombre=" + nombre + "]";
	}
	 
	 
}
