import java.text.Collator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

import javax.swing.AbstractListModel;

public class ListModelPaciente extends AbstractListModel{
	
	private ArrayList<Paciente> listaPaciente = new ArrayList<Paciente>();
	Collection<String> nombres =  new TreeSet<String>(Collator.getInstance());
	
	public void addPaciente(Paciente nuevoPaciente){
		listaPaciente.add(nuevoPaciente);
	}
	
	public Paciente getPaciente(int index){
		return listaPaciente.get(index);
	}
	
	public void ordenarAlfa(){
		
		ArrayList<Paciente> ordenado = new ArrayList<Paciente>();
		nombres.clear();
			
		for(int i=0; i<5; i++){
			nombres.add(listaPaciente.get(i).getNombreCompleto());
		}	
		ordenado.clear();
			
		for(int k=0; k<5; k++){
			for(int j=0; j<5; j++){
				if(listaPaciente.get(j).getNombreCompleto().equals(nombres.toArray()[k])){
					ordenado.add(listaPaciente.get(j));
				}
			}
		}
		listaPaciente = ordenado;
	}
	
	public int getPacientePorNombre(String name){
		
		for(int i=0; i<listaPaciente.size(); i++){
			if(listaPaciente.get(i).getNombreCompleto().startsWith(name.toUpperCase())){
				return i;
			}
		}
		
		return 0;
	}
	
	@Override
	public Object getElementAt(int index) {return listaPaciente.get(index).getNombreCompleto();}

	@Override
	public int getSize() {return listaPaciente.size();}

}
