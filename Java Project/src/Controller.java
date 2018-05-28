import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
	private View mView;
	private Model mModel;
	
	public Controller(View v, Model m){
		
		this.mView = v;
		this.mModel = m;
		
		mView.newLogin();
		mView.login.addLoginListener(new LoginListener());
		
	}
	
	class LoginListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String userName = "";
			String password = "";
			
			userName = mView.login.getUser();
			password =  String.copyValueOf(mView.login.getPass());
			
			if(mModel.checkLogin(userName, password)){
				mView.login.setVisible(false);
				mView.login.clearLogin();
				mView.newMenu();
				mView.menu.addLogoutListener(new LogoutListener());
				
			}
		}
	}
	
	class LogoutListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			mView.menu.setVisible(false);
			mView.login.setVisible(true);
			
		}
		
	}
}
