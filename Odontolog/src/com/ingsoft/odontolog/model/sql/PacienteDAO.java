package com.ingsoft.odontolog.model.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.ingsoft.odontolog.model.Paciente;


/**
 * Clase que permite el acceso a la base de datos
 * 
 */
public class PacienteDAO {


//	public void registrarPersona(Paciente miPersona) {
//		ConexionLogin conex = new ConexionLogin();
//
//		try {
//			Statement estatuto = conex.getConnection().createStatement();
//			estatuto.executeUpdate("INSERT INTO persona VALUES ('"
//					+ miPersona.getNombre() + "', '"
//					+ miPersona.getApellido() + "')");
//			JOptionPane.showMessageDialog(null,
//					"Se ha registrado Exitosamente", "Información",
//					JOptionPane.INFORMATION_MESSAGE);
//			estatuto.close();
//			conex.desconectar();
//
//		} catch (SQLException e) {
//			System.out.println(e.getMessage());
//			JOptionPane.showMessageDialog(null,
//					"No se Registro, verifique la consola para ver el error",
//					"Error", JOptionPane.ERROR_MESSAGE);
//		}
//	}
	
	public void getBaseDePacientes(ArrayList<Paciente> lista){
		ConexionLogin conex = new ConexionLogin();
		try {
			Statement estatuto = conex.getConnection().createStatement();
			ResultSet rs = estatuto.executeQuery("SELECT nombre, apellido FROM odontologin.odontologin");
			int i = 0;
			while (rs.next()) {
				
			}
			rs.close();
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Error al consultar", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}


	
	
	public void buscarNombreUsuarios(DefaultTableModel model) {

		ConexionLogin conex = new ConexionLogin();
		try {
			Statement estatuto = conex.getConnection().createStatement();
			ResultSet rs = estatuto.executeQuery("SELECT nombre, apellido FROM odontologin.pacientes");

			while (rs.next()) {
				Object[] fila = new Object[2];
				for (int i = 0; i < 2; i++)
					fila[i] = rs.getObject(i + 1);
				model.addRow(fila);
			}
			rs.close();
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Error al consultar", "Error",
					JOptionPane.ERROR_MESSAGE);

		}
	}

	/**
	 * Retorna una lista con los datos de la BD, para luego ser 
	 * recorrida y almacenada en la tabla por medio de la Matriz
	 * @return
	 */
	/*public ArrayList<Paciente> buscarUsuariosConMatriz() {

		Conexion conex = new Conexion();
		ArrayList<Paciente> miLista = new ArrayList<Paciente>();
		Paciente persona;
		try {
			Statement estatuto = conex.getConnection().createStatement();
			ResultSet rs = estatuto.executeQuery("SELECT * FROM persona ");

			while (rs.next()) {
				persona = new PersonaVo();
				persona.setIdPersona(Integer.parseInt(rs.getString("id")));
				persona.setNombrePersona(rs.getString("nombre"));
				persona.setEdadPersona(Integer.parseInt(rs.getString("edad")));
				persona.setProfesionPersona(rs.getString("profesion"));
				persona.setTelefonoPersona(Integer.parseInt(rs
						.getString("telefono")));
				miLista.add(persona);
			}
			rs.close();
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Error al consultar", "Error",
					JOptionPane.ERROR_MESSAGE);

		}
		return miLista;
	}*/
}
