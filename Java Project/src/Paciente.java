
public class Paciente {
	
	int dni;
	int obraSocialNum;
	String obraSocial;
	String nombre;
	String apellido;
	//Odontograma historiaC;
	
	public Paciente(int id, int osn, String os, String name, String surename){
		this.dni = id;
		this.obraSocialNum = osn;
		this.obraSocial = os;
		this.nombre = name;
		this.apellido = surename;
		//this.Odontograma;
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
	public int getDni(){
		return dni;
	}
	public int getNumeroObraSocial(){
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
	public void setObraSocial(int num, String nom){
		this.obraSocial = nom;
		this.obraSocialNum = num;
	}
	public void setDni(int num){
		this.dni = num;
	}
	
}
