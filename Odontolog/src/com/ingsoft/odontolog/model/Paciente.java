package com.ingsoft.odontolog.model;

import java.util.HashMap;
import java.util.Vector;

public class Paciente implements Comparable {
	
	private String dni;
	private String obraSocialNum;
	private String obraSocial;
	private String nombre;
	private String apellido;
	private String altura;
	private String peso;
	private String medico;
	private String telefono;
	private String mail;
	private String direccion;
	private String grupoSanguineo;
	private Odontograma historiaC;
	
	private HashMap<String, String> datos = new HashMap<String, String>();
	
	public static String[] campos = {"nombre", "apellido", "dni", "telefono", "e-mail", "direccion", "medico", 
			"peso", "obra social", "numero OS", "altura", "grupo sanguineo"};
	
	public Paciente(){	}
	
	public Paciente(String name, String surename){
		this.nombre = name;
		this.apellido = surename;
	}
	
	public Paciente(String id, String name, String surename){
		this.dni = id;
		this.nombre = name.toUpperCase();
		this.apellido = surename.toUpperCase();
	}
	
	public Paciente(String id, String name, String surename, Odontograma hist){
		this.dni = id;
		this.nombre = name.toUpperCase();
		this.apellido = surename.toUpperCase();
		this.historiaC = hist;
	}
	
	public Paciente(String id, String osn, String os, String name, String surename, Odontograma hist){
		this.dni = id;
		this.obraSocialNum = osn;
		this.obraSocial = os;
		this.nombre = name.toUpperCase();
		this.apellido = surename.toUpperCase();
		this.historiaC = hist;
	}
	
	//Getters
	public String getNombre(){
		return nombre;
	}
	public String getApellido(){
		return apellido;
	}
	public String getNombreCompleto(){
		return apellido+", "+nombre;
	}
	public String getDni(){
		return dni;
	}
	public String getNumeroObraSocial(){
		return obraSocialNum;
	}
	public String getObraSocial(){
		return obraSocial;
	}
	public Odontograma getHistoriaClinica(){
		return historiaC;
	}
	
	public String getDato(String tipo){
		return datos.get(tipo);
	}
	
	//Setters
	public void setNombre(String nom, String ape){
		this.nombre = nom;
		this.apellido = ape;
	}
	public void setObraSocial(String num, String nom){
		this.obraSocial = nom;
		this.obraSocialNum = num;
	}
	public void setDni(String num){
		this.dni = num;
	}
	public void setHistoriaClinica(Odontograma odonto){
		this.historiaC = odonto;
	}
	public void setDatosCompletos(String nom, String ape, String dni, String tel, String mail, 
			String direc, String med, String peso, String os, String osnum, String alt, String gs){
		this.nombre = nom;
		this.apellido = ape;
		this.dni = dni;
		this.altura = alt;
		this.telefono = tel;
		this.direccion = direc;
		this.grupoSanguineo = gs;
		this.medico = med;
		this.mail = mail.toLowerCase();
		this.peso = peso;
		this.obraSocial = os;
		this.obraSocialNum = osnum;
		
		this.historiaC = new Odontograma();
		
		datos.put(campos[0], this.nombre);
		datos.put(campos[1], this.apellido);
		datos.put(campos[2], this.dni);
		datos.put(campos[3], this.altura);
		datos.put(campos[4], this.telefono);
		datos.put(campos[5], this.direccion);
		datos.put(campos[6], this.grupoSanguineo);
		datos.put(campos[7], this.medico);
		datos.put(campos[8], this.mail);
		datos.put(campos[9], this.peso);
		datos.put(campos[10],this.obraSocial);
		datos.put(campos[11],this.obraSocialNum);
		
	}
	
	public Vector< Vector<String> > getDatosCompletosTabla(){
		
		Vector< Vector<String> > datos = new Vector< Vector<String> >();
		
		for(int i=0; i<campos.length; i++){
			datos.addElement(new Vector<String>());
			datos.get(i).addElement(this.campos[i]);
			datos.get(i).addElement(this.getDato(campos[i]));
		}
		return datos;
	}

	@Override
	public int compareTo(Object other) {
		Paciente otherPacient = (Paciente) other;
		return getNombreCompleto().compareToIgnoreCase(otherPacient.getNombreCompleto());
	}
	
}
