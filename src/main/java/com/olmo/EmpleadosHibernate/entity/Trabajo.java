package com.olmo.EmpleadosHibernate.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="trabajos")
public class Trabajo {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column
	private String nombre;
	
	@Column
	private float salario_min;
	
	@Column
	private float salario_max;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "trabajo")
	private List<Trabajador> trabajadores = new ArrayList<Trabajador>();
	
	
	public void addTrabajador(Trabajador trabajador) {

		if (!trabajadores.contains(trabajador)) {

			trabajadores.add(trabajador);
		}
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public float getSalario_min() {
		return salario_min;
	}


	public void setSalario_min(float salario_min) {
		this.salario_min = salario_min;
	}


	public float getSalario_max() {
		return salario_max;
	}


	public void setSalario_max(float salario_max) {
		this.salario_max = salario_max;
	}


	public List<Trabajador> getTrabajadores() {
		return trabajadores;
	}


	public void setTrabajadores(List<Trabajador> trabajadores) {
		this.trabajadores = trabajadores;
	}


	public Trabajo() {
		super();
	}


	@Override
	public String toString() {
		return "Trabajo [id=" + id + ", nombre=" + nombre + ", salario_min=" + salario_min + ", salario_max="
				+ salario_max + "]";
	}
	
	

}
