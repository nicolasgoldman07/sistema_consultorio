package com.ingsoft.odontolog.controller;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.swing.JOptionPane;
import javax.swing.event.ChangeListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import com.github.lgooddatepicker.optionalusertools.CalendarListener;
import com.github.lgooddatepicker.zinternaltools.CalendarSelectionEvent;
import com.github.lgooddatepicker.zinternaltools.YearMonthChangeEvent;
import com.ingsoft.odontolog.model.ListModelPaciente;
import com.ingsoft.odontolog.model.ListaDeTurnos;
import com.ingsoft.odontolog.model.Model;
import com.ingsoft.odontolog.model.Paciente;
import com.ingsoft.odontolog.model.SubjectDB;
import com.ingsoft.odontolog.view.View;

public class Controller {
	private View mView;
	private Model mModel;
	private int id;
	private Paciente paciente = new Paciente();
	private int tipoOrden = 0;
	private String[] ordenes = {"Alfabeticamente", "Por Nombre", "Por Dni"};
	private ListModelPaciente listaPacientes = ListModelPaciente.getInstance();
	private ListaDeTurnos listaTurnos = ListaDeTurnos.getInstance();
	private String fechaSeleccionada = "";

	public Controller(View v, Model m){
		
		this.mView = v;
		this.mModel = m;
		mView.newLogin();
		mView.login.addLoginListener(new LoginListener());

		mModel.llenarLista();
		mModel.llenarListaDeTurnos();
		
		SubjectDB checkDB = new SubjectDB();
		checkDB.addObserver(mModel);

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
			}
		}
	}
	
	//Menu Listeners
	class menuListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			mView.menu.setVisible(false);
			Object source = e.getSource();
			//Boton LogOut
			if(source.equals(mView.menu.getLougoutBttn())){
				mView.login.setVisible(true);
			}
			//Boton Administracion View
			if(source.equals(mView.menu.getAdminBttn())){
				mView.newAdministracion();
				mView.administracion.iniciarLista(listaPacientes);
				mView.administracion.addAdminListener(new AdminListener(), new AdminMouseListener());
			}
			//Boton Agenda de Turnos View
			if(source.equals(mView.menu.getAgendaBttn())){
				mView.newAgenda();
				mView.agenda.addCalendarListener(new CalendarioListener());
				mView.agenda.addAgendaListener(new AgendaDeTurnosListener());
			}
			//Boton Historia Clinica View
			if(source.equals(mView.menu.getHistoriaBttn())){
				mView.newHistoriaClinica();
				mView.historia.iniciarLista(listaPacientes);
				mView.historia.addBusquedaListener(new historiaMouseListener(), new historiaActionListener(), new AddPacienteListener());
			}
		}
	}
	
	
	//Agenda de Turnos Listeners
	class AgendaDeTurnosListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
			
			//Boton Agregar Turno
			if(source.equals(mView.agenda.getAgregarButton())){
				mView.newAgregarTurno();
				mView.nuevoTurno.iniciarLista(listaPacientes);
				mView.nuevoTurno.setVisible(true);
				mView.nuevoTurno.addConfirmarTurnoListener(new ConfirmarTurnoListener());
				
				try {
					mView.nuevoTurno.getDateChooser().setDate(new SimpleDateFormat("dd/MM/yyyy").parse(fechaSeleccionada));
				} catch (ParseException e1) {
					
				}
				
			}
			
			//Boton No Dar Turno
			if (source.equals(mView.agenda.getNoDarTurnoButton())) {
				mView.newNoDarTurno();
				mView.noDarTurno.setVisible(true);
				mView.noDarTurno.addNoDarTurnoListener(new NoDarTurnosListener());
				
				try {
					mView.noDarTurno.getDateChooser().setDate(new SimpleDateFormat("dd/MM/yyyy").parse(fechaSeleccionada));
				} catch(ParseException ex) {
					
				}
			}
			
			//Boton Atras
			if(source.equals(mView.agenda.getBackButton())){
				mView.agenda.setVisible(false);
				mView.menu.setVisible(true);
			}
		}
	}

	
	class NoDarTurnosListener implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			Object source = e.getSource();
			
			if (source.equals(mView.noDarTurno.getConfirmar())){
				mView.noDarTurno.setVisible(false);
			}
			
			if (source.equals(mView.noDarTurno.getAtras())) {
				mView.noDarTurno.setVisible(false);
			}
		}
	}
	
	//Nuevo Turno Listener
	class ConfirmarTurnoListener implements ActionListener{
		public void actionPerformed (ActionEvent e) {
			
			Object source = e.getSource();
			
			if(source.equals(mView.nuevoTurno.getConfirmarBtn())){
				String fecha, horario, tratamiento, diente, odontologo, paciente;
				int duracion;
				fecha = mView.nuevoTurno.getFecha();
				horario = mView.nuevoTurno.getHorario();
				duracion = mView.nuevoTurno.getDuracion();
				tratamiento = mView.nuevoTurno.getTratamiento();
				diente = mView.nuevoTurno.getDiente();
				odontologo = mView.nuevoTurno.getOdontologo();
				
				try{
					paciente = mView.nuevoTurno.getPaciente();
					if (mModel.addTurnoDB(fecha, horario, tratamiento, duracion, diente, odontologo, paciente)){
						mView.nuevoTurno.setVisible(false);
						listaTurnos.Ordenar();
						mModel.llenarTablaTurnos(mView.agenda.getTabla(), listaTurnos.getTurnosPorDia(fechaSeleccionada));
					}
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null, "No se ha seleccionado un paciente", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			
			if(source.equals(mView.nuevoTurno.getBusquedaField())){
				String aux = mView.nuevoTurno.getBusquedaField().getText();
				int index = listaPacientes.getPacientePorNombre(aux);
				mView.nuevoTurno.getListaDeNombres().setSelectedValue(listaPacientes.getElementAt(index), false);
				mView.nuevoTurno.getListaDeNombres().setSelectionBackground(Color.GREEN);
			}
			
		}
	}
	
	//Listener Para El Calendario
	class CalendarioListener implements CalendarListener {
        @Override
        public void selectedDateChanged(CalendarSelectionEvent event) {
            LocalDate newDate = event.getNewDate();
            String diaSeleccionado;
            String mesSeleccionado;
            String anoSeleccionado = String.valueOf(newDate.getYear());
            
            if(newDate.getDayOfMonth() >= 10){
            	diaSeleccionado = String.valueOf(newDate.getDayOfMonth());
            }else{
            	diaSeleccionado = "0"+String.valueOf(newDate.getDayOfMonth());
            }
            
            if(newDate.getMonthValue() >= 10){
            	mesSeleccionado = String.valueOf(newDate.getMonthValue());
            } else{
            	mesSeleccionado = "0"+String.valueOf(newDate.getMonthValue());
            }
            
            fechaSeleccionada = diaSeleccionado+"/"+mesSeleccionado+"/"+anoSeleccionado;
            mView.agenda.getFechaSeleccion().setText(fechaSeleccionada);
            
            mModel.llenarTablaTurnos(mView.agenda.getTabla(), listaTurnos.getTurnosPorDia(fechaSeleccionada));
        }
        
        public void setTabla(LocalDate newDate){
        	
        }

        @Override
        public void yearMonthChanged(YearMonthChangeEvent event) {
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
	
	//HistoriaClinicaView Listeners
	class historiaMouseListener implements MouseListener{
		@Override
		public void mouseClicked(MouseEvent me) {
			
			Object source = me.getSource();
			
			//Click en panel de busqueda
			if(source.equals(mView.historia.getBusquedaField())){
				if(mView.historia.getBusquedaField().getText().equals("\"B\u00FAsqueda\"")){
					mView.historia.getBusquedaField().setText("");
				}
			}
			
			//Click en lista de nombres
			if(source.equals(mView.historia.getListaDeNombres())){
				
				//Obtengo el paciente seleccionado
				int index = mView.historia.getListaDeNombres().getSelectedIndex();
				paciente = listaPacientes.getPaciente(index);
				
				//Muestro sus datos en la tabla
				mView.historia.getListaDeNombres().setSelectionBackground(Color.GREEN);
				mModel.llenarTabla(mView.historia.getTablaDatos(), paciente.getDatosCompletosTabla());
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
			Object source = e.getSource();
			//Busqueda
			if(source.equals(mView.historia.getBusquedaField())){
				String aux = mView.historia.getBusquedaField().getText();
				int index = listaPacientes.getPacientePorNombre(aux);
				mView.historia.getListaDeNombres().setSelectedValue(listaPacientes.getElementAt(index), false);
				mView.historia.getListaDeNombres().setSelectionBackground(Color.GREEN);
				
				paciente = listaPacientes.getPaciente(index);
				mModel.llenarTabla(mView.historia.getTablaDatos(), paciente.getDatosCompletosTabla());
			}
			
			//Odontograma
			if(source.equals(mView.historia.getOdontoButton())){
				//Obtengo el paciente seleccionado
				int index = mView.historia.getListaDeNombres().getSelectedIndex();
				
				try{
					//Dejo el paciente seleccionado para ver el odontograma
					paciente = listaPacientes.getPaciente(index);
					
					//Creo la nueva ventana y la refresco
					mView.newOdontograma(paciente.getNombreCompleto());
					mView.odontograma.addDienteListener(new DienteListener());
					mView.odontograma.refresh(mModel.getTratamientosPaciente(paciente));
				}catch(ArrayIndexOutOfBoundsException outOfBounds){
					JOptionPane.showMessageDialog(null, "No se ha seleccionado un paciente \n INDEX: "+String.valueOf(index), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			
			//Boton Atras
			if(source.equals(mView.historia.getBackButton())){
				mView.historia.setVisible(false);
				
				try {
					mView.menu.setVisible(true);
				}catch(NullPointerException main_null){
						JOptionPane.showMessageDialog(null, "ERROR: 404", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				try{
					mView.odontograma.setVisible(false);
				}catch(NullPointerException odonto){
					
				}
			}
			
			//Boton Quitar
			if(source.equals(mView.historia.getRemoveButton())){
				int index = mView.historia.getListaDeNombres().getSelectedIndex();
				
				try{
					paciente = listaPacientes.getPaciente(index);
					
					if (JOptionPane.showConfirmDialog(null, "�Esta seguro que desea eliminar a: "+paciente.getNombreCompleto()+" ?", "ADVERTENCIA",
					        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						
						//Lo remuevo de la base de datos
						mModel.removePacienteDB(paciente.getDni());
						
						//Lo remuevo de la lista de Pacientes
						listaPacientes.removePaciente(paciente);
					}
					
				}catch(ArrayIndexOutOfBoundsException ex){
					JOptionPane.showMessageDialog(null, "No se ha seleccionado un paciente \n INDEX: "+String.valueOf(index), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			
			//Boton Ordenar
			if(source.equals(mView.historia.getOrdenarButton())){
				
				tipoOrden++;
				if(tipoOrden == ordenes.length){
					tipoOrden = 0;
				}
				
				listaPacientes.setOrdenarStrategy(mModel.getOrdenamiento(tipoOrden));
				mView.historia.getTipoLbl().setText("Tipo: "+ordenes[tipoOrden]);
				
			}
		}
	}
	

	//nuevoPacienteView Listener
	class NuevoPacienteListener implements ActionListener{
		public void actionPerformed (ActionEvent e) {
			
			Object source = e.getSource();
			
			//Boton Agregar
			if(source.equals(mView.nuevoPaciente.getAddButton())){
				String nombre, apellido, dni, telefono, mail, direccion, medicoCabecera, 
				peso, obraSocial, numeroOS, altura, factorSanguineo;
		
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
				
				if (mModel.addPacienteDB(nombre, apellido, dni, telefono, mail, direccion, medicoCabecera, peso, obraSocial, numeroOS, altura, factorSanguineo)) {
					mView.nuevoPaciente.setVisible(false);
				}
			}
			
			//Boton Cancelar
			if(source.equals(mView.nuevoPaciente.getCancelButton())){
				mView.nuevoPaciente.setVisible(false);
			}
			
		}
	}
	
	//AgregarUnNuevoPaciente Listener
	class AddPacienteListener implements ActionListener{
		public void actionPerformed (ActionEvent e) {
			mView.newAgregarPaciente();
			mView.nuevoPaciente.addNuevoPacienteListener(new NuevoPacienteListener());
		}
	}
	
	//BOTONES DE LA VISTA ADMINISTRACION
	class AdminListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
			
			//BOTON "ATRAS" (REGRESA AL MENU PRINCIPAL)
			if (source.equals(mView.administracion.getBackButton())) {
				try {
					mView.administracion.setVisible(false);
				}catch(NullPointerException admin_null){
				
				}
				mView.menu.setVisible(true);
			}

			//BOTON AGREGAR TRATAMIENTO
			/*if (source.equals(mView.administracion.getAddButton())) {
				
			}*/	
		}	
	}
	class AdminMouseListener implements MouseListener{
		@Override
		public void mouseClicked(MouseEvent me) {
			
			Object source = me.getSource();
			//Click en lista de nombres
			if(source.equals(mView.administracion.getListaNombres())){
				//Obtengo el paciente seleccionado
				int index = mView.administracion.getListaNombres().getSelectedIndex();
				paciente = listaPacientes.getPaciente(index);
				
				//Muestro sus datos en la tabla
				mView.administracion.getListaNombres().setSelectionBackground(Color.GREEN);
				mModel.llenarTabla(mView.administracion.getTablaImportes(), listaTurnos.getTratamientosPorPaciente(paciente.getNombreCompleto()));
				mView.administracion.getSaldosLbl().setText(mModel.getPrecioTotal(listaTurnos.getTratamientosPorPaciente(paciente.getNombreCompleto())));
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
		

}
