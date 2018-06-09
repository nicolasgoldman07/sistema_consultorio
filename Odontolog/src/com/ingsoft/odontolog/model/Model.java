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


public class Model {
	
	private ConexionLogin con = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	private String sqlLoginCommand = "";
	private String sqlAddingCommand;
	private ConexionPacientes conP;
	
	
	private String[] DummyNames = {"Ale", "Hueba", "Nico", "Lea", "Tortugo" };
	private String[] DummySurenames = {"Arce", "Weda", "Goldman", "Drueta", "Weda"};
	private int aux = 0;
	private ListModelPaciente listaPacientes;
	
	public Model(){
		listaPacientes = ListModelPaciente.getInstance();
//		for(int i=0; i<50; i++){
//			listaPacientes.addPaciente(this.dummyPaciente());
//		}
//		listaPacientes.ordenarAlfa();
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
			listaPacientes.ordenarAlfa();
			
			
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
		for(int i=0; i<datos.size(); i++){
			for(int j=0; j<datos.get(i).size(); j++){
				tabla.getModel().setValueAt(datos.get(i).get(j), i, j);
			}
		}
		

	}
	

	
	
	public Paciente dummyPaciente(){
		Paciente p = new Paciente("32", "12", "X", DummyNames[aux], DummySurenames[aux], new Odontograma());
		aux++;
		if(aux >= DummyNames.length){
			aux = 0;
		}
		return p;
	}
}
