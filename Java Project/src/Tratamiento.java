

public class Tratamiento {
	private static String[] tratamientos = {"Obturacion c/ amalgama: cavidad compuesta", "Obturacion c/amalgama: reconstrucciones",
			"Obt. con Ion�mero", "Obt.con Ion�mero cav.simple", "Obt. con Ion�mero"};
	private String tipo;
	
	public Tratamiento(String tipo){
		this.tipo = tipo;
	}
	
	public Tratamiento(){
		
	}
	
	public void setTratamiento(String t){
		tipo = t;
	}
	
	public static String[] getTipos(){
		return tratamientos;
	}
}
