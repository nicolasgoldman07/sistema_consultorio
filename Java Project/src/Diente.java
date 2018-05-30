import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class Diente {
	
	private String caraSup;
	private String caraInf;
	private String caraDer;
	private String caraIzq;
	private String caraC;
	private HashMap<String, String> caras;
	private static String[] keys = {"cara derecha", "cara superior", "cara central", "cara inferior", "cara izquierda"};
	
	public Diente(){
		
		
		caras = new HashMap<String, String>();
		caraSup = new String();
		caraInf = new String();
		caraDer = new String();
		caraIzq = new String();
		caraC = new String();
		
		caras.put("cara superior", caraSup);
		caras.put("cara inferior", caraInf);
		caras.put("cara central", caraC);
		caras.put("cara derecha", caraDer);
		caras.put("cara izquierda", caraIzq);
		
	}
	
	public void addCondicion(String cara, String cond){
		cara = cond;
	}
	
	public String getCara(String c){
		return caras.get(c);
	}
	
	public static String getKey(int numero){
		return keys[numero];
	}
	
	
}
