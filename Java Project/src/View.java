
public class View {
	
	public loginView login;
	
	public View(){
		
	}
	
	public void newLogin(){
		
		try {
			login = new loginView();
			login.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
