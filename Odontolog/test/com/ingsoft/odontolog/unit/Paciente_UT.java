package com.ingsoft.odontolog.unit;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ingsoft.odontolog.model.CompararAlfabeticamente;
import com.ingsoft.odontolog.model.CompararDni;
import com.ingsoft.odontolog.model.CompararNombres;
import com.ingsoft.odontolog.model.Paciente;

public class Paciente_UT {
	
	Paciente p1;
	Paciente p2;
	Paciente p3;
	
	
	@Before
	public void setUp() throws Exception {
		p1 = new Paciente();
		p3 = new Paciente();
		
		p1.setDatosCompletos("Sujeto", "dePrueba", "404040401", "35171111", "mail@prueba.com", "prueba 247", "javier", "127", "obrasocial", "123", "180", "A+");
		p3.setDatosCompletos("A_Sujeto", "A_dePrueba", "3939391", "35171111", "mail@prueba.com", "prueba 247", "javier", "127", "obrasocial", "123", "180", "A+");
	}

	@Test
	public void test_getDatos() {
		Assert.assertEquals("Sujeto", p1.getDato("nombre"));
		Assert.assertEquals("dePrueba", p1.getDato("apellido"));
		Assert.assertEquals("404040401", p1.getDato("dni"));
	}
	
	@Test
	public void comparar_todo() {
		p1.setCompararBehavior(new CompararAlfabeticamente());
		int i = 0;
		int j = p1.compareTo(p3);
		Assert.assertEquals(true, i<j);
		
		p1.setCompararBehavior(new CompararNombres());
		j = p1.compareTo(p3);
		Assert.assertEquals(true, i<j);
		
		p1.setCompararBehavior(new CompararDni());
		j = p1.compareTo(p3);
		Assert.assertEquals(true, i<j);
	}
	
	@Test
	public void comparar_mismo() {
		p1.setCompararBehavior(new CompararAlfabeticamente());
		Assert.assertEquals(0, p1.compareTo(p1));
	
	}
	
	@Test (expected = NullPointerException.class)
	public void comparar_nulo(){
		p1.setCompararBehavior(new CompararAlfabeticamente());
		p1.compareTo(p2);
	}

}
