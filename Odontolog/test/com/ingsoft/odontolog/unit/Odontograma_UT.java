package com.ingsoft.odontolog.unit;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ingsoft.odontolog.model.CompararAlfabeticamente;
import com.ingsoft.odontolog.model.Diente;
import com.ingsoft.odontolog.model.Odontograma;

public class Odontograma_UT {
	
	Odontograma odo1;
	Odontograma odo2 = new Odontograma();
	
	@Before
	public void setUp() throws Exception {
		
	}

	@Test (expected = Exception.class)
	public void test_null() {
		odo1.getDentadura();
	}
	
	@Test
	public void test_dentadura() {
		Assert.assertEquals(52, odo2.getDentadura().size());
	}
	
	@Test (expected = Exception.class)
	public void test_setDiente() {
		
		int index = 12;
		String cara = Diente.keys[0];
		String tratamiento = Diente.tratamientos[0];
		
		odo2.setDiente(index, cara, tratamiento);
		Assert.assertEquals(tratamiento, odo2.getDentadura().get(index).getCara(cara));
		
		index = 100;
		odo2.setDiente(index, cara, tratamiento);
	}
	

}
