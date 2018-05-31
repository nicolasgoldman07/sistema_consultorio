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
}
