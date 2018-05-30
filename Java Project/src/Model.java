
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
	
	public void setDienteTratado(Paciente paciente, int id, int tratamiento){
		Odontograma odonto;
		try{
			odonto = paciente.getHistoriaClinica();
		}catch(NullPointerException e){
			System.out.println("Este paciente no tiene historia clinica");
			odonto = new Odontograma();
			paciente.setHistoriaClinica(odonto);
		}
		
		int numeroDiente = (int) id/5; 
		int numeroCara = (int) id-(numeroDiente*5);
		odonto.setDiente(numeroDiente, Diente.getKey(numeroCara), Tratamiento.tratamientos[tratamiento]);
	}
	
	public String[] getDentaduraPaciente(Paciente paciente){
		String[] dientes = null;
		int cantDientes = paciente.getHistoriaClinica().getDentadura().size();
		
		for(int i=0; i<cantDientes; i++){
			
		}
		
		return dientes;
	}
	
	
}
