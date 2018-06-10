package com.ingsoft.odontolog.unit;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ingsoft.odontolog.model.Diente;

public class Diente_UT {
	
	Diente d1;
	
	@Before
	public void setUp() throws Exception {
		d1 = new Diente();
	}

	@Test 
	public void test() {
		for(int i=0; i<Diente.CARAS; i++){
			d1.addCondicion(Diente.keys[i], String.valueOf(i));
			Assert.assertEquals(String.valueOf(i), d1.getCara(Diente.keys[i]));
		}
	}

}
