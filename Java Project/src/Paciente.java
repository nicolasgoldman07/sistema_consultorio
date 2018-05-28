
public class Paciente {
	
	private String dni;
	private String obraSocialNum;
	private String obraSocial;
	private String nombre;
	private String apellido;
	//private Odontograma historiaC;
	
	public Paciente(String id, String osn, String os, String name, String surename){
		this.dni = id;
		this.obraSocialNum = osn;
		this.obraSocial = os;
		this.nombre = name;
		this.apellido = surename;
		//this.Odontograma;
	}
	
	public Paciente(){
		
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
	
}
