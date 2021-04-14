package com.olmo.EmpleadosHibernate.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class PaisId implements Serializable{

	private String cod;
	private String nombre;
	
	
	public PaisId() {
	}


	public PaisId(String cod, String nombre) {
		this.cod = cod;
		this.nombre = nombre;
	}


	public String getCod() {
		return cod;
	}


	public void setCod(String cod) {
		this.cod = cod;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PaisId))
			return false;
		PaisId castOther = (PaisId) other;

		return ((this.getCod() == castOther.getCod()) || (this.getCod() != null
				&& castOther.getCod() != null && this.getCod().equals(castOther.getCod())))
				&& (this.getNombre() == castOther.getNombre());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getCod() == null ? 0 : this.getCod().hashCode());
		result = 37 * result + (getNombre() == null ? 0 : this.getNombre().hashCode());

		return result;
	}
	
}
