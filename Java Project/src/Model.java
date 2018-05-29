
public class Model {
	
	private String usertest = "ale";
	private String passtest = "123";
	
	public boolean checkLogin(String usr, String pass){
		if(usr.equals(usertest) && pass.equals(passtest)){
			return true;
		}
		else{
			return false;
		}
	}
}
