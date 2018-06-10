package com.ingsoft.odontolog.model;

import java.util.HashMap;

public class Tratamientos {
	
	public static Tratamientos INSTANCE = new Tratamientos();
	public static String[] tratamientos = {"CONSULTAS", "OPERATORIA", "ENDODONCIA", "PROTESIS", "PREVENCION", "ORTODONCIA",
			"ORTODONCIA", "PERIODONCIA", "RADIOLOGIA", "CIRUGIA"};
	private String[] cantidad = {"100.00", "2500.00", "320.23", "465.30", "5026.88", "15.00", "1123.51", "321.65", "946.10", "1000.12"};
	
	private static HashMap<String, String> precios = new HashMap<String, String>();
	
	private Tratamientos(){
		for(int i=0; i<tratamientos.length; i++){
			precios.put(tratamientos[i], cantidad[i]);
		}
	}
	
	public static Tratamientos getInstance(){
		return INSTANCE;
	}
	
	public static String getPrecioDeTratamiento(String trata){
		return precios.get(trata);
	}
}
