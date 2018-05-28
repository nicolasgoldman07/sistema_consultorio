
public class View {
	
	public loginView login;
	public principalView menu;
	
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
	
	public void newMenu(){
		try {
			menu = new principalView();
			menu.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
