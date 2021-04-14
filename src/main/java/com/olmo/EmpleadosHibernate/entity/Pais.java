package com.olmo.EmpleadosHibernate.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="paises")
public class Pais {

	
	@EmbeddedId
	private PaisId id;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "pais")
	private List<Direccion> direcciones = new ArrayList<Direccion>();
	
	public void addDireccion(Direccion dir) {

		if (!direcciones.contains(dir)) {

			direcciones.add(dir);
		}
	}
	

	public Pais() {
		super();
	}

	public PaisId getId() {
		return id;
	}

	public void setId(PaisId id) {
		this.id = id;
	}

	

	public List<Direccion> getDirecciones() {
		return direcciones;
	}

	public void setDirecciones(List<Direccion> direcciones) {
		this.direcciones = direcciones;
	}


	@Override
	public String toString() {
		return "Pais [id=" + id +  ", direcciones=" + direcciones + "]";
	}


	
	
	
}
