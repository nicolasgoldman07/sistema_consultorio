package com.ingsoft.odontolog.model;

import java.util.ArrayList;
import java.util.Vector;

public class ListaDeTurnos{
	private ArrayList<Turno> listaTurnos = new ArrayList<Turno>();
	private static final ListaDeTurnos INSTANCE = new ListaDeTurnos();
	
	private ListaDeTurnos(){};
	
	public static ListaDeTurnos getInstance() {
        return INSTANCE;
	}
	
	public void addTurno(Turno nuevoturno){
		listaTurnos.add(nuevoturno);
	}
	
	public void removeTurno(Turno turno){
		listaTurnos.remove(turno);
	}
	
	public Turno getTurno(int index){
		return listaTurnos.get(index);
	}
	
	public Vector<Vector<String>> getTurnosPorDia(String fecha){
		Vector<Vector<String>> vector_datos = new Vector<Vector<String>>();
		for(int i=0; i<listaTurnos.size(); i++){
			if(listaTurnos.get(i).getDato(Turno.campos[0]).equals(fecha)){
				vector_datos.add(listaTurnos.get(i).getDatosCompletosTabla());
			}
		}
		return vector_datos;
	}

}
