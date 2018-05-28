import java.util.ArrayList;
import java.util.Vector;

public class Diente {
	
	private Tratamiento caraSup;
	private Tratamiento caraInf;
	private Tratamiento caraDer;
	private Tratamiento caraIzq;
	private Tratamiento caraC;
	private Vector<Tratamiento> caras;
	
	public Diente(){
		
		caras = new Vector<Tratamiento>();
		caraSup = new Tratamiento();
		caraInf = new Tratamiento();
		caraDer = new Tratamiento();
		caraIzq = new Tratamiento();
		caraC = new Tratamiento();
		
		caras.addElement(caraSup);
		caras.addElement(caraInf);
		caras.addElement(caraDer);
		caras.addElement(caraIzq);
		caras.addElement(caraC);
	}
	
	public void addCondicion(Tratamiento cara, String cond){
		cara.setTratamiento(cond);
	}
	
	public Tratamiento getCara(int num){
		return caras.get(num);
	}
	
	
}
