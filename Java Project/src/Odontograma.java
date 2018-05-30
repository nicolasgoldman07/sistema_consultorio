import java.util.ArrayList;


public class Odontograma {
	
	private ArrayList<Diente> dentadura;
	
	
	public Odontograma(){
		
		dentadura = new ArrayList<Diente>();
		IniciarDent();
		
	}
	
	public void setDiente(int numd, String cara, String str){
		dentadura.get(numd).addCondicion(dentadura.get(numd).getCara(cara), str);
	}
	
	public ArrayList<Diente> getDentadura(){
		return dentadura;
	}
	
	
	private void IniciarDent(){
		
		for(int i=0; i<52; i++){
			dentadura.add(new Diente());
		}
	}
}
