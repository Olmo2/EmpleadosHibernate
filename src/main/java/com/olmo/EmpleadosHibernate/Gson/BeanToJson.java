package com.olmo.EmpleadosHibernate.Gson;

import com.google.gson.Gson;
import com.olmo.EmpleadosHibernate.entity.Departamento;
import com.olmo.EmpleadosHibernate.entity.Direccion;
import com.olmo.EmpleadosHibernate.repository.DepartamentoDAO;

public class BeanToJson {

	static DepartamentoDAO deptDAO;

	public static void main(String[] args) {

		Gson gson = new Gson();
		Departamento dept = new Departamento();
		dept.setId(100);
		dept.setNombre("Alfonso");
		dept.setDir(new Direccion());
		String representacionJSON = gson.toJson(dept);
		Departamento[] depts = new Departamento[3];
		for (int i = 0; i < depts.length; i++) {
			depts[i] = dept;
		}

		String json = "{\"id\":100,\"nombre\":\"Alfonso\",\"dir\":{\"pais\":{\"direcciones\":[]},\"departamentos\":[]},\"trabajadores\":[]}"; 

		Departamento departamento = gson.fromJson(json, Departamento.class);
		
		String representacionJSONArray = gson.toJson(depts);
		System.out.println("**JSON**");
		System.out.println(representacionJSON);
		System.out.println("**Array**");
		System.out.println(representacionJSONArray);
		System.out.println("**Objecto de Json**");
		System.out.println(departamento.getId());
		System.out.println(departamento.getNombre());
	}
}
