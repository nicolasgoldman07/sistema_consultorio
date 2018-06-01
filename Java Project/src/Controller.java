import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
	private View mView;
	private Model mModel;
	private int id;
	private Paciente paciente = new Paciente();

	
	public Controller(View v, Model m){
		this.mView = v;
		this.mModel = m;
		mView.newLogin();
		//mView.newMenu();
		mView.login.addLoginListener(new LoginListener());
		//mView.menu.addAgendaListener(new AgendaListener());
		//mView.newOdontograma();
		//mView.odontograma.addDienteListener(new DienteListener());
		//paciente = mModel.dummyPaciente();
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
				mView.menu.addAgendaListener(new AgendaListener());
				mView.menu.addLogoutListener(new LogoutListener());
				mView.menu.addAdministracionListener (new AdministracionListener());
			}
		}
	}
	
	
	
	class LogoutListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent evt) {
			mView.menu.setVisible(false);
			mView.login.setVisible(true);
		}
	}
	
	
	class AgendaListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			mView.newAgenda();
			mView.menu.setVisible(false);
			mView.agenda.addBackListener(new BackListener());
		}
	}
	
	class BackListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(mView.agenda.isVisible()) {
			mView.agenda.setVisible(false);
			}
			else if(mView.administracion.isVisible()) {
			mView.administracion.setVisible(false);
			}
			mView.menu.setVisible(true);
		}
	}
	
	class AdministracionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			mView.newAdministracion();
			mView.menu.setVisible(false);
			mView.administracion.addBackListener(new BackListener());
		}
	}
		
	
	class DienteListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			id = mView.odontograma.getBotones().indexOf(e.getSource());
			try{
				mModel.setDienteTratado(paciente, id, 1);
				mView.odontograma.refresh(mModel.getTratamientosPaciente(paciente));
			} catch(NullPointerException exc){
				exc.printStackTrace();
			}
			//System.out.println(String.valueOf(id));
			//System.out.println("Diente N: "+String.valueOf((int)(id/5)));
			//System.out.println("Cara N: "+String.valueOf((int) id-(numD*5)));
		}
		
	}
	
	
	
	
	
	
	
	
	
}
