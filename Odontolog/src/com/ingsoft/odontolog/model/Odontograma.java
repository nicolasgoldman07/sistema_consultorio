package com.ingsoft.odontolog.model;
import java.util.ArrayList;


public class Odontograma {
	
	private ArrayList<Diente> dentadura;
	
	
	public Odontograma(){
		
		dentadura = new ArrayList<Diente>();
		IniciarDent();
		
	}
	
	public void setDiente(int numerodiente, String cara, String tratamiento){
		dentadura.get(numerodiente).addCondicion(cara, tratamiento);
	}
	
	public ArrayList<Diente> getDentadura(){
		return dentadura;
	}
	
	private void IniciarDent(){
		for(int i=0; i<52; i++){
			dentadura.add(new Diente());
		}
	}
}
