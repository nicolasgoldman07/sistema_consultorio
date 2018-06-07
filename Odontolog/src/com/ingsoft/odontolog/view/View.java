package com.ingsoft.odontolog.view;
import com.ingsoft.odontolog.model.AgendaDeTurnos;

public class View {
	
	
	
	public loginView login;
	public principalView menu;
	public odontogramaView odontograma = null;
	public AgendaDeTurnos agenda;
	public adminView administracion;


	
	public historiaClinicaView	historia;

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
			agenda = new AgendaDeTurnos();
			agenda.setVisible(true);
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


	public void newOdontograma(String name){
		try {
			odontograma = new odontogramaView();
			odontograma.setBounds(200, 38, 1600, 700);
			odontograma.setVisible(true);
			odontograma.setAlwaysOnTop(true);
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
