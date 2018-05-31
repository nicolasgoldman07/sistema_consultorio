import java.util.ArrayList;
import java.util.Vector;

public class Model {
	
	private String usertest = "ale";
	private String passtest = "123";
	
	private String[] DummyNames = {"Ale", "Hueba", "Nico", "Lea", "Tortugo" };
	private String[] DummySurenames = {"Arce", "Weda", "Goldman", "Drueta", "Weda"};
	private int aux = 0;
	private ListModelPaciente listaPacientes;
	
	public Model(){
		listaPacientes = new ListModelPaciente();
		for(int i=0; i<5; i++){
			listaPacientes.addPaciente(this.dummyPaciente());
		}
		
		listaPacientes.ordenarAlfa();
	}
	
	
	public boolean checkLogin(String usr, String pass){
		if(usr.equals(usertest) && pass.equals(passtest)){
			return true;
		}
		else{
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
	
	public Paciente dummyPaciente(){
		Paciente p = new Paciente("32", "12", "X", DummyNames[aux], DummySurenames[aux], new Odontograma());
		aux++;
		if(aux >= DummyNames.length){
			aux = 0;
		}
		return p;
	}
	
	public ListModelPaciente getListModelPaciente(){
		return listaPacientes;
	}
	
}
