package com.ingsoft.odontolog.controller;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import com.ingsoft.odontolog.model.ListModelPaciente;
import com.ingsoft.odontolog.model.Model;
import com.ingsoft.odontolog.model.Paciente;
import com.ingsoft.odontolog.view.View;

public class Controller {
	private View mView;
	private Model mModel;
	private int id;
	private Paciente paciente = new Paciente();

	public Controller(View v, Model m){
		this.mView = v;
		this.mModel = m;
		mView.newLogin();
		mView.login.addLoginListener(new LoginListener());
		//mView.newMenu();
		//mView.menu.addMenuListeners(new menuListener());

		//mView.menu.addAgendaListener(new AgendaListener());
		//mView.newOdontograma();
  
		//mView.newHistoriaClinica();
		//mView.odontograma.addDienteListener(new DienteListener());
		
		//mView.historia.iniciarLista(ListModelPaciente.getInstance());
		//mView.historia.addBusquedaListener(new historiaMouseListener(), new historiaActionListener());
		
		//mView.odontograma.addDienteListener(new DienteListener());
		
		//mView.newAdministracion();
		//mView.administracion.iniciarLista(ListModelPaciente.getInstance());


	}
	
	class LoginListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String userName = "";
			String password = "";
			userName = mView.login.getUser();
			password =  String.copyValueOf(mView.login.getPass());
			if(mModel.checkLogin(userName, password)){
				mView.login.setVisible(false);
				mView.login.clearLogin();
				mView.newMenu();
				mView.menu.addMenuListeners(new menuListener());
//				mView.menu.addAgendaListener(new AgendaListener());
//				mView.menu.addLogoutListener(new LogoutListener());
//				mView.menu.addAdministracionListener (new AdministracionListener());
				
			}
		}
	}
	
//	class LogoutListener implements ActionListener{
//		@Override
//		public void actionPerformed(ActionEvent evt) {
//			mView.menu.setVisible(false);
//			mView.login.setVisible(true);
//		}
//	}
//	
//	class AgendaListener implements ActionListener{
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			mView.newAgenda();
//			mView.menu.setVisible(false);
//			mView.agenda.addBackListener(new BackListener());
//		}
//	}
//	
//	class AdministracionListener implements ActionListener{
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			mView.newAdministracion();
//			mView.menu.setVisible(false);
//			mView.administracion.addBackListener(new BackListener());
//		}
//	}
	
	class menuListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			mView.menu.setVisible(false);
			Object source = e.getSource();
			if(source.equals(mView.menu.getLougoutBttn())){
				mView.login.setVisible(true);
			}
			if(source.equals(mView.menu.getAdminBttn())){
				mView.newAdministracion();
				//mView.administracion.addAddListener (new AddListener());
				//mView.administracion.addBackListener(new BackListener());
			}
			if(source.equals(mView.menu.getAgendaBttn())){
				mView.newAgenda();
				mView.agenda.addBackListener(new BackListener());
			}
		}
	}
	
	class BackListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				mView.agenda.setVisible(false);
			}catch(NullPointerException agenda_null) {
				
			}
			try {
				mView.administracion.setVisible(false);
			}catch(NullPointerException admin_null){
			
			}
			mView.menu.setVisible(true);
		}
	}
	
	class DienteListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			id = mView.odontograma.getBotones().indexOf(e.getSource());
			try{
				mModel.setDienteTratado(paciente, id, 0);
				mView.odontograma.refresh(mModel.getTratamientosPaciente(paciente));
			} catch(NullPointerException exc){
				exc.printStackTrace();
			}
		}
	}
	
	class historiaMouseListener implements MouseListener{
		@Override
		public void mouseClicked(MouseEvent me) {
			Object source = me.getSource();
			if(source.equals(mView.historia.getBusquedaField())){
				if(mView.historia.getBusquedaField().getText().equals("\"B\u00FAsqueda\"")){
					mView.historia.getBusquedaField().setText("");
				}
			}
			if(source.equals(mView.historia.getListaDeNombres())){
				mView.historia.getListaDeNombres().setSelectionBackground(Color.GREEN);
			}
		}
		@Override
		public void mouseEntered(MouseEvent me) {}
		@Override
		public void mouseExited(MouseEvent me) {}
		@Override
		public void mousePressed(MouseEvent me) {}
		@Override
		public void mouseReleased(MouseEvent me) {}
	}
	
	class historiaActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(mView.historia.getBusquedaField())){
				String aux = mView.historia.getBusquedaField().getText();
				int index = ListModelPaciente.getInstance().getPacientePorNombre(aux);
				mView.historia.getListaDeNombres().setSelectedValue(ListModelPaciente.getInstance().getElementAt(index), false);
				mView.historia.getListaDeNombres().setSelectionBackground(Color.GREEN);
			}
			
			if(e.getSource().equals(mView.historia.getOdontoButton())){
				//Obtengo el paciente seleccionado
				int index = mView.historia.getListaDeNombres().getSelectedIndex();
				
				try{
					//Dejo el paciente seleccionado para ver el odontograma
					paciente = ListModelPaciente.getInstance().getPaciente(index);
					
					//Creo la nueva ventana y la refresco
					mView.newOdontograma(paciente.getNombreCompleto());
					mView.odontograma.addDienteListener(new DienteListener());
					mView.odontograma.refresh(mModel.getTratamientosPaciente(paciente));
				}catch(Exception outOfBounds){
					JOptionPane.showMessageDialog(null, "No se ha seleccionado un paciente", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}
	
	class AdministracionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			mView.newAdministracion();
			mView.menu.setVisible(false);
			//mView.administracion.addAddListener(new AddListener());
			//mView.administracion.addBackListener(new BackListener());
		}
	}
	
	class NuevoPacienteListener implements ActionListener{
		public void actionPerformed (ActionEvent e) {
			String nombre, apellido, dni, telefono, mail, direccion, medicoCabecera, peso, obraSocial, numeroOS, altura, factorSanguineo;
			nombre = mView.nuevoPaciente.getNombre();
			apellido = mView.nuevoPaciente.getApellido();
			dni = mView.nuevoPaciente.getDni();
			telefono = mView.nuevoPaciente.getTelefono();
			mail = mView.nuevoPaciente.getMail();
			direccion = mView.nuevoPaciente.getDireccion();
			medicoCabecera = mView.nuevoPaciente.getMedicoCabecera();
			peso = mView.nuevoPaciente.getPeso();
			obraSocial = mView.nuevoPaciente.getObraSocial();
			numeroOS = mView.nuevoPaciente.getNumOSi();
			altura = mView.nuevoPaciente.getAltura();
			factorSanguineo = mView.nuevoPaciente.getFactor();
			if (mModel.addPaciente(nombre, apellido, dni, telefono, mail, direccion, medicoCabecera, peso, obraSocial, numeroOS, altura, factorSanguineo)) {
				mView.nuevoPaciente.setVisible(false);
			}
		}
	}
	
	class CancelListener implements ActionListener{
		public void actionPerformed (ActionEvent e) {
			mView.nuevoPaciente.setVisible(false);
		}
	}
	
	class AddListener implements ActionListener{
		public void actionPerformed (ActionEvent e) {
			mView.newAgregarPaciente();
			mView.nuevoPaciente.addNuevoPacienteListener(new NuevoPacienteListener());
			mView.nuevoPaciente.addCancelListener(new CancelListener());
		}
	}
	
	
	
	
	
	
}
