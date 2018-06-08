package com.ingsoft.odontolog.model;

import java.util.ArrayList;
import java.util.Vector;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
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
		for(int i=0; i<50; i++){
			listaPacientes.addPaciente(this.dummyPaciente());
		}
		listaPacientes.ordenarAlfa();
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
		dentaduraPaciente = paciente.getHistoriaClinica().getDentadura();
		int cantDientes = dentaduraPaciente.size();
		for(int i=0; i<cantDientes; i++){
			for(int j=0; j<Diente.CARAS; j++){
				dientes.add(dentaduraPaciente.get(i).getCara(Diente.keys[j])+Diente.keys[j]);
			}
		}
		return dientes;
	} 
	
	
	public boolean addPaciente(String nom, String ape, String id, String tel, String mai, String dir, String med, String pes, String obr, String num, String alt, String fac) {
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
	
	
	public Paciente dummyPaciente(){
		Paciente p = new Paciente("32", "12", "X", DummyNames[aux], DummySurenames[aux], new Odontograma());
		aux++;
		if(aux >= DummyNames.length){
			aux = 0;
		}
		return p;
	}
}
