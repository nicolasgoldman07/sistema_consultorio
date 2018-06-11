package com.ingsoft.odontolog.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.ingsoft.odontolog.model.sql.ConexionLogin;

public class SubjectDB implements Subject{
	ArrayList<Observer> observers = new ArrayList<Observer>();
	public SubjectDB(){
		Thread t = new Thread(() -> {
			int cant_anterior = ListModelPaciente.getInstance().getSize();
			int cant_actual = 0;
			try {
			ConexionLogin conex = new ConexionLogin();
			Statement estatuto;

				estatuto = conex.getConnection().createStatement();

				while(true){
	
						ResultSet rs = estatuto.executeQuery("SELECT COUNT(*) FROM odontologin.pacientes");
						 while (rs.next()) {
							cant_actual = rs.getInt(1);
						}
						 
						if(cant_actual > cant_anterior){
							notifyObservers();
						}
						
						rs.close();
						try {
							Thread.sleep(5000);
						} catch (Exception e) {
							e.printStackTrace();
						}
			    }
			}
			catch (SQLException e) {
					System.out.println(e.getMessage());
					JOptionPane.showMessageDialog(null, "Error al consultar", "Error",
					JOptionPane.ERROR_MESSAGE);
			}
		});
		t.start();
	}

	@Override
	public void notifyObservers() {
		for (Observer o : observers){
			o.update();
		}
	}

	@Override
	public void addObserver(Observer obs) {
		observers.add(obs);
	}

	@Override
	public void removeObserver(Observer obs) {
		observers.remove(obs);
	}
	
}
