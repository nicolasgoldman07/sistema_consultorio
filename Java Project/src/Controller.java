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
				
			}
			
		}
		
		
		
	}
}
