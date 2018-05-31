
import java.util.ArrayList;
import java.util.Vector;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Model {
	
	private Connection con = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	private String sqlLoginCommand = "";
	
	
	public boolean checkLogin(String usr, String pass){
		
		sqlLoginCommand = "select * from login_table where username=? and password=?";
		
		try{
			con = DriverManager.getConnection("jdbc:mysql://localhost/login_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","demoniofc");
			pst = con.prepareStatement(sqlLoginCommand);
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
				dientes.add(dentaduraPaciente.get(i).getCara(Diente.keys[j]));
			}
		}
		
		return dientes;
	} 
	
	/*public Paciente dummyPaciente(){
		Paciente p = new Paciente("32", "12", "X", "Ale", "Arce", new Odontograma());
		return p;
	}*/
}
