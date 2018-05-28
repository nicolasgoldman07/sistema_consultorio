import java.util.ArrayList;


public class Odontograma {
	
	private ArrayList<Diente> dentadura;
	
	
	public Odontograma(){
		
		dentadura = new ArrayList<Diente>();
		IniciarDent();
		
	}
	
	public void setDiente(int numd, int numc, String str){
		dentadura.get(numd).addCondicion(dentadura.get(numd).getCara(numc), str);
	}
	
	
	private void IniciarDent(){
		
		for(int i=0; i<52; i++){
			dentadura.add(new Diente());
		}
	}
}
