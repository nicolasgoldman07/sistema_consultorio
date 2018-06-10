package com.ingsoft.odontolog.unit;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ingsoft.odontolog.model.Model;

public class Model_UT {
	
	Model model;
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
	
	@Test (expected = Exception.class)
	public void test_removePacienteDB() {
		model.removePacienteDB("0000.135");
	}

}
