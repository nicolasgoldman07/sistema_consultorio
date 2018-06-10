package com.ingsoft.odontolog.view;

import java.awt.Dimension;

public class View {
	
	
	
	public loginView login;
	public principalView menu;
	public agendaTurnosView agenda;
	public odontogramaView odontograma = null;
	public adminView administracion;
	public nuevoPacienteView nuevoPaciente;
	public historiaClinicaView	historia;
	public nuevoTurnoView nuevoTurno;
	
	

	public View(){
		
	}
	
	public void newLogin(){
		try {
			login = new loginView();
			login.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void newMenu(){
		try {
			menu = new principalView();
			menu.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void newAgenda() {
		try {
			agenda = new agendaTurnosView();
			agenda.setVisible(true);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void newAgregarTurno() {
		try {
			nuevoTurno = new nuevoTurnoView();
			nuevoTurno.setVisible(true);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void newAdministracion() {
		try {
			administracion = new adminView();
			administracion.setVisible(true);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	public void newAgregarPaciente() {
		try {
			nuevoPaciente = new nuevoPacienteView();
			nuevoPaciente.setVisible(true);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	public void newOdontograma(String name){
		try {
			odontograma = new odontogramaView();
			odontograma.setBounds(200, 38, 1600, 700);
			odontograma.setVisible(true);
			odontograma.setTitle("Odontograma - "+name);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public void newHistoriaClinica(){
		historia = new historiaClinicaView();
		historia.setVisible(true);
		//this.newOdontograma();
	}
	

}
