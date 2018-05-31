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
	public static final String[] tratamientos = {"Carie", "Piojos", "Obt. con Ionómero", "Obt.con Ionómero cav.simple", "Obt. con Ionómero"};
	public static final String[] keys = {"cara derecha", "cara superior", "cara central", "cara inferior", "cara izquierda"};
	public static final int CARAS  = keys.length;
	
	public Diente(){
		
		caras = new HashMap<String, String>();
		
		for(int i=0; i<keys.length; i++){
			caras.put(keys[i], "na");
		}
	}
	
	public void addCondicion(String cara, String cond){
		caras.put(cara, cond);
	}
	
	public String getCara(String c){
		return caras.get(c);
	}
}
