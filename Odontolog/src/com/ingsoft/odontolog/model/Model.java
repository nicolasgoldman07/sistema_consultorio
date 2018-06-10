package com.ingsoft.odontolog.model;

import java.util.ArrayList;
import java.util.Vector;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


import com.ingsoft.odontolog.model.sql.ConexionLogin;
import com.ingsoft.odontolog.model.sql.ConexionPacientes;
import com.ingsoft.odontolog.model.sql.ConexionTurnos;


public class Model {
	
	private ConexionLogin con = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	private String sqlLoginCommand;
	private String sqlAddingCommand;
	private String sqlTurnosCommand;
	private ConexionPacientes conP;
	private ConexionTurnos conT;
	
	
	private int aux = 0;
	
	private ListModelPaciente listaPacientes = ListModelPaciente.getInstance();
	private ListaDeTurnos listaTurnos = ListaDeTurnos.getInstance();
	
	
	public Model(){
		
	}
	
	
	public boolean checkLogin(String usr, String pass){
		sqlLoginCommand = "select * from user where username=? and password=?";
		con = new ConexionLogin();
		try{
			pst = con.getConnection().prepareStatement(sqlLoginCommand);
			pst.setString(1, usr);
			pst.setString(2, pass);
			rs = pst.executeQuery();
			if(rs.next()) {
				return true;
			}
			else {
				JOptionPane.showMessageDialog(null, "Incorrect username or password");
				return false;
			}
		} catch(SQLException | HeadlessException ex){
			JOptionPane.showMessageDialog(null,ex);
			return false;
		}
	}
	
	public void setDienteTratado(Paciente paciente, int id, int tratamiento){
		Odontograma odonto;
		try{
			odonto = paciente.getHistoriaClinica();
		}catch(NullPointerException e){
			System.out.println("Este paciente no tiene historia clinica");
			odonto = new Odontograma();
		}
		int numeroDiente = (int) id/5; 
		int numeroCara = (int) id-(numeroDiente*5);
		odonto.setDiente(numeroDiente, Diente.keys[numeroCara], Diente.tratamientos[tratamiento]);
		paciente.setHistoriaClinica(odonto);
	}
	
	public Vector<String> getTratamientosPaciente(Paciente paciente){
		Vector<String> dientes = new Vector<String>();
		ArrayList<Diente> dentaduraPaciente = new ArrayList<Diente>();
		
		try{
			dentaduraPaciente = paciente.getHistoriaClinica().getDentadura();
		}catch(NullPointerException e){
			JOptionPane.showMessageDialog(null, "No tiene un odontograma", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		int cantDientes = dentaduraPaciente.size();
		for(int i=0; i<cantDientes; i++){
			for(int j=0; j<Diente.CARAS; j++){
				dientes.add(dentaduraPaciente.get(i).getCara(Diente.keys[j])+Diente.keys[j]);
			}
		}
		return dientes;
	} 
	
	
	public boolean addPacienteDB(String nom, String ape, String id, String tel, String mai, String dir, String med, String pes, String obr, String num, String alt, String fac) {
		sqlAddingCommand = "INSERT INTO pacientes (nombre, apellido, dni, telefono, mail, direccion,"
				+ " medicoCabecera, peso, obraSocial, numOS, altura, factorSang) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" ;
		conP = new ConexionPacientes();
		try{
			pst = conP.getConnection().prepareStatement(sqlAddingCommand);
			pst.setString(1, nom);
			pst.setString(2, ape);
			pst.setString(3, id);
			pst.setString(4, tel);
			pst.setString(5, mai);
			pst.setString(6, dir);
			pst.setString(7, med);
			pst.setString(8, pes);
			pst.setString(9, obr);
			pst.setString(10, num);
			pst.setString(11, alt);
			pst.setString(12, fac);
			
			if(pst.executeUpdate() == 1) {
				conP.desconectar();
				añadirUltimoALista();
				return true;
			}
			else {
				JOptionPane.showMessageDialog(null, "Falta algun dato importante wacho");
				return false;
			}
		} catch(SQLException | HeadlessException ex){
			JOptionPane.showMessageDialog(null,ex);
			return false;
		}
	}
	
	public void removePacienteDB(String id){
		String rmCommand = "DELETE FROM pacientes WHERE dni = '"+id+"' ";
		conP = new ConexionPacientes();
		
		try{
			Statement estatuto = conP.getConnection().createStatement();
			estatuto.execute(rmCommand);
		}catch(SQLException | HeadlessException ex){
			JOptionPane.showMessageDialog(null,ex);
		}
	}
	
	public void añadirUltimoALista(){
		ConexionLogin conex = new ConexionLogin();
		try {
			Statement estatuto = conex.getConnection().createStatement();
			ResultSet rs = estatuto.executeQuery("SELECT * FROM odontologin.pacientes");
			
			rs.last();
			
			Vector<String> datos = new Vector<String>();
			Paciente paciente = new Paciente();
			
			for (int i = 1; i < 13; i++){
				datos.addElement(String.valueOf(rs.getObject(i)).toUpperCase());	
			}
		
			paciente.setDatosCompletos(datos.get(0), datos.get(1), datos.get(2), 
					datos.get(3), datos.get(4), datos.get(5), datos.get(6), datos.get(7),
					datos.get(8), datos.get(9), datos.get(10), datos.get(11));
			
			listaPacientes.addPaciente(paciente);
			
			rs.close();
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Error al consultar", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	//Añadir Turnos a la Base de Datos
	public boolean addTurnoDB(String date, String time, String treatement, int duration, String tooth, String dentist, String pacient) {
		sqlTurnosCommand = "INSERT INTO turnos (fecha, horario, tratamiento, diente, "
				+ "odontologo, paciente, duracion) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)" ;
		conT = new ConexionTurnos();
		try {
			pst = conT.getConnection().prepareStatement(sqlTurnosCommand);
			pst.setString(1, date);
			pst.setString(2, time);
			pst.setString(3, treatement);
			pst.setString(4, tooth);
			pst.setString(5, dentist);
			pst.setString(6, pacient);
			pst.setInt(7, duration);
			if(pst.executeUpdate() == 1) {
				conT.desconectar();
				añadirUltimoTurno();
				return true;
			}
			else {
				JOptionPane.showMessageDialog(null, "La cagaste");
				return false;
			}
		} catch(SQLException | HeadlessException | NullPointerException ex){
			JOptionPane.showMessageDialog(null, ex);
			return false;
		}
	}
	//Añadir el Nuevo Turno a la Lista de Turnos
	public void añadirUltimoTurno(){
		ConexionLogin conex = new ConexionLogin();
		try {
			Statement estatuto = conex.getConnection().createStatement();
			ResultSet rs = estatuto.executeQuery("SELECT * FROM turnos");
			
			rs.last();
			
			Vector<String> datos = new Vector<String>();
			Turno turno = new Turno();
			
			for (int i = 1; i < Turno.campos.length+1; i++){
				datos.addElement(String.valueOf(rs.getObject(i)).toUpperCase());	
			}
		
			turno.setDatos(datos.get(0), datos.get(1), datos.get(2), 
					datos.get(3), datos.get(4), datos.get(5), datos.get(6));
			
			listaTurnos.addTurno(turno);
			
			rs.close();
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Error al consultar", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	public void llenarListaDeTurnos() {
		ConexionLogin conex = new ConexionLogin();
		
		try {
			Statement estatuto = conex.getConnection().createStatement();
			ResultSet rs = estatuto.executeQuery("SELECT * FROM turnos");
			while (rs.next()) {
				Vector<String> datos = new Vector<String>();
				Turno turno = new Turno();
				for (int i = 1; i < Turno.campos.length+1; i++){
					datos.addElement(String.valueOf(rs.getObject(i)).toUpperCase());
					
				}
				turno.setDatos(datos.get(0), datos.get(1), datos.get(2), 
						datos.get(3), datos.get(4), datos.get(5), datos.get(6));
				listaTurnos.addTurno(turno);
			}
			
			listaTurnos.Ordenar();
			
			rs.close();
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Error al consultar", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void llenarLista() {
		ConexionLogin conex = new ConexionLogin();
		
		try {
			Statement estatuto = conex.getConnection().createStatement();
			ResultSet rs = estatuto.executeQuery("SELECT * FROM odontologin.pacientes");
			while (rs.next()) {
				Vector<String> datos = new Vector<String>();
				Paciente paciente = new Paciente();
				for (int i = 1; i < 13; i++){
					datos.addElement(String.valueOf(rs.getObject(i)).toUpperCase());
					
				}
				paciente.setDatosCompletos(datos.get(0), datos.get(1), datos.get(2), 
						datos.get(3), datos.get(4), datos.get(5), datos.get(6), datos.get(7),
						datos.get(8), datos.get(9), datos.get(10), datos.get(11));
				
				listaPacientes.addPaciente(paciente);
			}
			listaPacientes.setOrdenarStrategy(new OrdenarAlfabeticamente());
			rs.close();
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Error al consultar", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void llenarTabla(JTable tabla, Vector<Vector<String>> datos){
		for(int i=0; i<tabla.getModel().getRowCount(); i++){
			for(int j=0; j<tabla.getModel().getColumnCount(); j++){
				tabla.getModel().setValueAt(" ", i, j);
			}
		}
		try{
			for(int i=0; i<datos.size(); i++){
				for(int j=0; j<datos.get(i).size(); j++){
					tabla.getModel().setValueAt(datos.get(i).get(j), i, j);
				}
			}
		}catch(Exception ex){
	
		}
	}
	
	public void llenarTablaTurnos(JTable tabla, Vector<Vector<String>> datos){
		for(int i=0; i<tabla.getModel().getRowCount(); i++){
			for(int j=0; j<4; j++){
				tabla.getModel().setValueAt(" ", i, j+1);
			}
		}
		try{
			for(int i=0; i<datos.size(); i++){
				for(int j=1; j<5; j++){
					tabla.getModel().setValueAt(datos.get(i).get(j), i, j);
				}
			}
		}catch(Exception ex){
	
		}
	}
	
	public OrdenarStrategy getOrdenamiento(int a){
		Vector<OrdenarStrategy> ordenes = new Vector<OrdenarStrategy>();
		ordenes.add(new OrdenarAlfabeticamente());
		ordenes.add(new OrdenarPorNombre());
		ordenes.add(new OrdenarPorDni());
		
		return ordenes.get(a);
	}
	
	//Calcula precio total de Tratamientos de un Paciente
	public String getPrecioTotal(Vector<Vector<String>> tratamientos){
		String precioTotal = "";
		String precio = "";
		float p = 0;
		for(int i=0; i<tratamientos.size(); i++){
			precio = tratamientos.get(i).get(1);
			p = p+Float.valueOf(precio.substring(2, precio.length()));
		}
		precioTotal = String.format("%.2f", p);
		return precioTotal;
	}
}
