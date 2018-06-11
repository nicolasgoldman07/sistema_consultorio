package com.ingsoft.odontolog.unit;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Vector;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ingsoft.odontolog.model.Turno;

public class Turno_UT {
	Turno t1;
	Turno t2;
	Turno t3;
	Turno t4;
	
	@Before
	public void setUp() throws Exception {
		t1 = new Turno();
		t2 = new Turno();
		t3 = new Turno();
		t4 = new Turno();
		
		t1.setDatos("06/06/1997", "8:30", "OPERATORIA", "11", "nachitog22", "PacientePrueba", "120");
		t2.setDatos("test", "8:30", "test", "test", "test", "test", "test");
		t3.setDatos("test", "9:30", "test", "test", "test", "test", "test");
		t4.setDatos("test", "7:30", "test", "test", "test", "test", "test");
	}
	
	
	@Test
	public void testGetters() {
		Assert.assertEquals("06/06/1997", t1.getDato("fecha"));
		Assert.assertEquals("OPERATORIA", t1.getDato("tratamiento"));
		Assert.assertEquals("120", t1.getDato("duracion"));
	}
	
	
	@Test
	public void testPrecioTratamiento() {
		Vector<String> testVector =  new Vector<String>();
		testVector.addElement("OPERATORIA");
		testVector.addElement("$ 2500.00");
		Assert.assertEquals(testVector, t1.getTratamientoTabla());
	}
	
	@Test
	public void compararTurnoCompleto() {
		//0 -> cuando son iguales
		//>0 mayor
		//<0 menor
		t1.compareTo(t2);
		Assert.assertEquals(0, t1.compareTo(t2));
	}
	
	
	@Test 
	public void compararTurnoAnterior() {
		int i = 0;
		int j = t1.compareTo(t4);
		Assert.assertEquals(true, i<j);
	}
	
	
	@Test
	public void compararTurnoPosterior() {
		int i = 0;
		int j = t1.compareTo(t3);
		Assert.assertEquals(true, i>j);
	}
	
}
