package com.ingsoft.odontolog.unit;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ingsoft.odontolog.model.ListModelPaciente;
import com.ingsoft.odontolog.model.Paciente;

public class ListaModelPaciente_UT {
	
	Paciente p1 = new Paciente();
	Paciente p3 = new Paciente();
	ListModelPaciente lista = ListModelPaciente.getInstance();
	
	@Before
	public void setUp() throws Exception {
		p1.setDatosCompletos("Sujeto", "dePrueba", "404040401", "35171111", "mail@prueba.com", "prueba 247", "javier", "127", "obrasocial", "123", "180", "A+");
		p3.setDatosCompletos("A_Sujeto", "A_dePrueba", "3939391", "35171111", "mail@prueba.com", "prueba 247", "javier", "127", "obrasocial", "123", "180", "A+");
	}
	
	@Test
	public void test_addPaciente() {
		Assert.assertEquals(0, lista.getSize());
		lista.addPaciente(p1);
		Assert.assertEquals(1, lista.getSize());
		
		lista.removePaciente(p1);
		Assert.assertEquals(0, lista.getSize());
	}

	@Test
	public void test_getElementAt() {
		Assert.assertEquals(0, lista.getSize());
		lista.addPaciente(p1);
		Assert.assertEquals(1, lista.getSize());
		Assert.assertEquals(p1.getNombreCompleto(), lista.getElementAt(0));
		
		lista.removePaciente(p1);
		Assert.assertEquals(0, lista.getSize());
	}
	
	@Test (expected = Exception.class)
	public void test_getPaciente() {
		Assert.assertEquals(0, lista.getSize());
		lista.addPaciente(p3);
		Assert.assertEquals(1, lista.getSize());
		
		Assert.assertEquals(0, lista.getPacientePorNombre(p3.getNombreCompleto()));
		
		Assert.assertEquals(p3, lista.getPaciente(0));
		
		lista.getPaciente(5);
		
		lista.removePaciente(p3);
		Assert.assertEquals(0, lista.getSize());
	}

}
