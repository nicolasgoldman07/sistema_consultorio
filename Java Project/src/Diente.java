import java.util.ArrayList;
import java.util.Vector;

public class Diente {
	
	private ArrayList<String> caraSup;
	private ArrayList<String> caraInf;
	private ArrayList<String> caraDer;
	private ArrayList<String> caraIzq;
	private ArrayList<String> caraC;
	private Vector<ArrayList<String>> caras;
	
	public Diente(){
		
		caras = new Vector<ArrayList<String>>();
		caraSup = new ArrayList<String>();
		caraInf = new ArrayList<String>();
		caraDer = new ArrayList<String>();
		caraIzq = new ArrayList<String>();
		caraC = new ArrayList<String>();
		
		caras.addElement(caraSup);
		caras.addElement(caraInf);
		caras.addElement(caraDer);
		caras.addElement(caraIzq);
		caras.addElement(caraC);
	}
	
	public void addCondicion(ArrayList<String> cara, String cond){
		cara.add(cond);
	}
	
	public ArrayList<String> getCara(int num){
		return caras.get(num);
	}
	
	public void printDiente(){
	
	for(int j=0; j<caras.size(); j++){
		System.out.println("Cara: " + j);
		for(int i=0; i < caras.get(j).size(); i++ ){
			System.out.println(caras.get(j).get(i));
		}
	}
		
	}
	
	
}
