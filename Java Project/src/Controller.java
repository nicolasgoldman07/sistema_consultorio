import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controller {
	private View mView;
	private Model mModel;
	private int id;
	private Paciente paciente = new Paciente();

	
	public Controller(View v, Model m){
		
		this.mView = v;
		this.mModel = m;
		
		//mView.newLogin();
		//mView.login.addLoginListener(new LoginListener());
		//mView.newOdontograma();

		mView.newHistoriaClinica();
		mView.odontograma.addDienteListener(new DienteListener());
		
		//ListModelPaciente listaPacientes = new ListModelPaciente();
		
		
		
		/*for(int i=0; i<5; i++){
			paciente = mModel.dummyPaciente();
			listaPacientes.addPaciente(paciente);
		}*/
		
		mView.historia.iniciarLista(mModel.getListModelPaciente());
		mView.historia.addBusquedaListener(new BusquedaListener(), new EnterBusquedaListener());
		
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
	
	class DienteListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			id = mView.odontograma.getBotones().indexOf(e.getSource());
			
			try{
				mModel.setDienteTratado(paciente, id, 1);
				mView.odontograma.refresh(mModel.getTratamientosPaciente(paciente));
			}catch(NullPointerException exc){
				exc.printStackTrace();
			}
			//System.out.println(String.valueOf(id));
			//System.out.println("Diente N: "+String.valueOf((int)(id/5)));
			//System.out.println("Cara N: "+String.valueOf((int) id-(numD*5)));
		}
	}
	
	class BusquedaListener implements MouseListener{
		@Override
		public void mouseClicked(MouseEvent arg0) {
			if(mView.historia.getBusquedaField().getText().equals("\"B\u00FAsqueda\"")){
				mView.historia.getBusquedaField().setText("");
			}
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {}

		@Override
		public void mouseExited(MouseEvent arg0) {}

		@Override
		public void mousePressed(MouseEvent arg0) {}

		@Override
		public void mouseReleased(MouseEvent arg0) {}
	}
	
	class EnterBusquedaListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String aux = mView.historia.getBusquedaField().getText();
			ListModelPaciente list_aux = mModel.getListModelPaciente();
			int index = list_aux.getPacientePorNombre(aux);
			mView.historia.getListaDeNombres().setSelectedValue(list_aux.getElementAt(index), false);
			mView.historia.getListaDeNombres().setSelectionBackground(Color.GREEN);
			//mView.historia.getListaDeNombres().updateUI();
		}
	}
}
