package com.ingsoft.odontolog.unit;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ingsoft.odontolog.model.ListModelPaciente;
import com.ingsoft.odontolog.model.Model;
import com.ingsoft.odontolog.model.OrdenarAlfabeticamente;

public class Model_UT {
	
	Model model;
	ListModelPaciente listaPaciente = ListModelPaciente.getInstance();
	String id = "000123";
	
	@Before
	public void setUp() throws Exception {
		model = new Model();
	}

	@Test 
	public void test_login() {
		//Login negativo
		Assert.assertEquals(false, model.checkLogin("no_usuario", "no_contraseña"));
		//Login positivo
		Assert.assertEquals(true, model.checkLogin("ale", "123"));
	}
	
	@Test 
	public void test_addPacienteDB() {
		boolean result;
		result = model.addPacienteDB("Paciente", "DePrueba", id, "4816144", "@deprueba", "prueba", "javier", "80", "osde", "123", "180", "A+");
		Assert.assertEquals(true, result);
		model.removePacienteDB(id);
	}
	
	@Test 
	public void test_anadirUltimoALista(){
		model.llenarLista();
		int size = listaPaciente.getSize();
		Assert.assertEquals(true, size > 0);
		
		size = listaPaciente.getSize();
		
		model.añadirUltimoALista();
		Assert.assertEquals(size+1, listaPaciente.getSize());
	}
	
	@Test
	public void test_getOrdenamiento(){
		Assert.assertEquals(OrdenarAlfabeticamente.class, model.getOrdenamiento(0).getClass());
	}
	
	

}
