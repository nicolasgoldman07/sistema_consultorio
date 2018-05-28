import java.util.ArrayList;


public class Odontograma {
	
	//private ArrayList<Diente> dentaduraAdulto;
	//private ArrayList<Diente> dentaduraNene;
	private ArrayList<Diente> dentadura;
	
	public Odontograma(){
		
		//dentaduraAdulto = new ArrayList<Diente>();
		//dentaduraNene = new ArrayList<Diente>();
		dentadura = new ArrayList<Diente>();
		IniciarDent();
		
	}
	
	public void setDiente(int numd, int numc, String str){
		dentadura.get(numd).addCondicion(dentadura.get(numd).getCara(numc), str);
	}
	
	public void getDiente(int num){
		dentadura.get(num).printDiente();
	}
	
	private void IniciarDent(){
		
		/*for(int i=0; i<32; i++){
			dentaduraAdulto.add(new Diente());
		}
		for(int j=0; j<20; j++){
			dentaduraNene.add(new Diente());
		}*/
		
		for(int i=0; i<52; i++){
			dentadura.add(new Diente());
		}
	}
}
