package com.ingsoft.odontolog.model;

import java.util.HashMap;
import java.util.Vector;

public class Turno implements Comparable{
	private String fecha;
	private String horario;
	private String tratamiento;
	private String diente;
	private String odontologo;
	private String paciente;
	private String duracion;
	
	public static String[] tratamientos = {"CONSULTAS", "OPERATORIA", "ENDODONCIA", "PROTESIS", "PREVENCION", "ORTODONCIA",
			"ORTODONCIA", "PERIODONCIA", "RADIOLOGIA", "CIRUGIA"};
	private String[] cantidad = {"$ 100.00", "$ 2500.00", "$ 320.23", "$ 465.30", "$ 5026.88", "$ 15.00", "$ 1123.51", "$ 321.65", "$ 946.10", "$ 1000.12"};
	private static HashMap<String, String> precios = new HashMap<String, String>();
	
	public static final String[] campos = {"horario", "paciente", "tratamiento", "diente", "odontologo", "duracion", "fecha"};
	private HashMap<String, String> datos = new HashMap<String, String>();
	
	public Turno() {
		for(int i=0; i<tratamientos.length; i++){
			precios.put(tratamientos[i], cantidad[i]);
		}
	}
	
	public void setDatos(String fecha, String horario, String tratamiento, 
						String diente, String odonto, String paciente, String duracion){
		this.fecha = fecha;
		this.horario = horario;
		this.tratamiento = tratamiento;
		this.diente = diente;
		this.odontologo = odonto;
		this.paciente = paciente;
		this.duracion = duracion;
		
		
		datos.put(campos[0], this.horario);
		datos.put(campos[1], this.paciente);
		datos.put(campos[2], this.tratamiento);
		datos.put(campos[3], this.diente);
		datos.put(campos[4], this.odontologo);
		datos.put(campos[5], this.duracion);
		datos.put(campos[6], this.fecha);
	}
	
	public String getDato(String tipo){
		return datos.get(tipo);
	}
	
	public Vector<String> getTratamientoTabla(){
		Vector<String> vector_datos = new Vector<String>();
		vector_datos.addElement(tratamiento);
		vector_datos.addElement(precios.get(tratamiento));
		return vector_datos;
	}
	
	public Vector<String> getDatosCompletosTabla(){
		Vector<String> vector_datos = new Vector<String>();
		
		for(int i=0; i<campos.length; i++){
			vector_datos.addElement(this.getDato(campos[i]));
		}
		
		return vector_datos;
	}

	@Override
	public int compareTo(Object other) {
		Turno otherTurno = (Turno) other;
		return getDato("horario").compareToIgnoreCase(otherTurno.getDato("horario"));
		
	}
	
}
