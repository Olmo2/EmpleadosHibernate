package com.olmo.EmpleadosHibernate.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "trabajadores")
public class Trabajador {

	@Id
	private Integer id;

	@Column
	private String nombre;

	@Column
	private String apellidos;

	@Column
	private String email;

	@Column
	private String tlf;

	@Column
	private Date fecha_alta;

	@ManyToOne
	Trabajo trabajo = new Trabajo();

	@ManyToOne
	Departamento dept = new Departamento();

	public Trabajador() {
		super();
	}

	

	public Trabajador(Integer id, String nombre, String apellidos, String email, String tlf, Date fecha_alta,
			Trabajo trabajo, Departamento dept) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.tlf = tlf;
		this.fecha_alta = fecha_alta;
		this.trabajo = trabajo;
		this.dept = dept;
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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTlf() {
		return tlf;
	}

	public void setTlf(String tlf) {
		this.tlf = tlf;
	}

	public Date getFecha_alta() {
		return fecha_alta;
	}

	public void setFecha_alta(Date fecha_alta) {
		this.fecha_alta = fecha_alta;
	}

	public Trabajo getTrabajo() {
		return trabajo;
	}

	public void setTrabajo(Trabajo trabajo) {
		this.trabajo = trabajo;
	}

	public Departamento getDept() {
		return dept;
	}

	public void setDept(Departamento dept) {
		this.dept = dept;
	}



	@Override
	public String toString() {
		return "Trabajador [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email
				+ ", tlf=" + tlf + ", fecha_alta=" + fecha_alta + ", trabajo=" + trabajo + ", dept=" + dept.getNombre() + "]";
	}

	
	

}
