
public class Paciente {
	
	private String dni;
	private String obraSocialNum;
	private String obraSocial;
	private String nombre;
	private String apellido;
	private Odontograma historiaC;
	
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
	
}
