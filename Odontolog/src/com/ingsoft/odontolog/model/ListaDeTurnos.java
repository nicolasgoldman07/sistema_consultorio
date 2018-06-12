package com.ingsoft.odontolog.model;

import java.util.ArrayList;
import java.util.Vector;

public class ListaDeTurnos{
	private ArrayList<Turno> listaTurnos = new ArrayList<Turno>();
	private static final ListaDeTurnos INSTANCE = new ListaDeTurnos();
	private Vector<String> vector_vacio = new Vector<String>();
	private Vector<String> vector_blanco = new Vector<String>();
	
	private ListaDeTurnos(){
		for(int i=0; i<Turno.campos.length; i++){
			vector_vacio.addElement(" - ");
			vector_blanco.addElement("  ");
		}
	}
	
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
	
	public void Ordenar(){
		listaTurnos.sort(null);
	}
	
	public int getDiferenciaDeHorarios(String hora_a, String hora_b){
		
		int hora_1 = Integer.valueOf(hora_a.substring(0, 2));
		int min_1 = Integer.valueOf(hora_a.substring(3, 4));
		
		int hora_2 = Integer.valueOf(hora_b.substring(0, 2));
		int min_2 = Integer.valueOf(hora_b.substring(3, 4));
		
		int index = hora_2 - hora_1;
		
		if((min_1 - min_2) < 0){
			index = (index*2)+1;
		}
		if((min_1 - min_2) == 0){
			index = index*2;
		}
		if((min_1 - min_2) > 0){
			index = (index*2)-1;
		}
		
		return index;
	}
	
	//VER BIEN ESTOOOO
	public Vector<Vector<String>> getTurnosPorDia(String fecha){
		Vector<Vector<String>> vector_datos = new Vector<Vector<String>>();
		
		int primero = 0;
		Vector<Integer> indices = new Vector<Integer>();
		int blancos = 0;
		
		for(int i=0; i<listaTurnos.size(); i++){
			if(listaTurnos.get(i).getDato(Turno.campos[6]).equals(fecha)){
				indices.add(i);
			}
		}
		
		for(int j=0; j<indices.size(); j++){
			
				int i = indices.get(j);
			
				String esta_hor = listaTurnos.get(i).getDato("horario");
				
				if(primero==0){
					int dif = getDiferenciaDeHorarios("07:00", esta_hor);
					System.out.println("LA DIFERENCIA ES: "+String.valueOf(dif));
					System.out.println("EL PRIMER TURNO ES DE: "+listaTurnos.get(i).getDato("paciente")+ "/ A LAS: "+listaTurnos.get(i).getDato("horario"));
					for(int k=0; k<dif; k++){
						vector_datos.add(vector_blanco);
						blancos++;
					}
				}
				
				primero++;
				
				//Agrego los turnos para determinado dia
				vector_datos.add(listaTurnos.get(i).getDatosCompletosTabla());
				
				//Agrego Espacios para la duracion del Turno
				int espacios = Integer.valueOf(listaTurnos.get(i).getDato("duracion"))/30; 
				for(int k=0; k<espacios; k++){
					vector_datos.add(vector_vacio);
				}
				
				try{
					String prox_hor = listaTurnos.get(indices.get(j+1)).getDato("horario");
					
					int index = getDiferenciaDeHorarios(esta_hor, prox_hor);
					index = (index+blancos) - (vector_datos.size()-primero) - 1;
					
					System.out.println("INDEX: "+String.valueOf(index));
					
					for(int k=0; k<index; k++){
						vector_datos.add(vector_blanco);
						blancos++;
					}
					
				}catch(Exception ex){
					
				}
				
				System.out.println("++TURNO ES DE: "+listaTurnos.get(i).getDato("paciente")+ "/ A LAS: "+listaTurnos.get(i).getDato("horario"));
			}
		
		return vector_datos;
	}
	
	public Vector<Vector<String>> getTratamientosPorPaciente(String paciente){
		Vector<Vector<String>> vector_datos = new Vector<Vector<String>>();
		
		for(int i=0; i<listaTurnos.size(); i++){
			if(listaTurnos.get(i).getDato("paciente").equals(paciente)){
				vector_datos.add(listaTurnos.get(i).getTratamientoTabla());
			}	
		}
		
		return vector_datos;
	}

}
