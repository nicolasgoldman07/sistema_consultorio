
public class Model {
	
	private String usertest = "ale";
	private String passtest = "123";
	
	public boolean checkLogin(String usr, String pass){
		if(usr.equals(usertest) && pass.equals(passtest)){
			System.out.println("------------------------");
			System.out.println(usr);
			System.out.println(pass);
			System.out.println("ENTRASTE WACHO");
			System.out.println("------------------------");
			
			return true;
		}
		else{
			System.out.println("------------------------");
			System.out.println(usr);
			System.out.println(pass);
			System.out.println("NOOOO ENTRASTE WACHO");
			System.out.println("------------------------");
			
			return false;
		}
	}
}
