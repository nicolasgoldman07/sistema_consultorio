package com.ingsoft.odontolog.model;

import java.util.ArrayList;

public class OrdenarPorDni implements OrdenarStrategy{

	@Override
	public void ordenar() {
		ArrayList<Paciente> listaPaciente = ListModelPaciente.getInstance().getLista();
		ListModelPaciente modelo = ListModelPaciente.getInstance();
		for(int i=0; i<listaPaciente.size(); i++){
			listaPaciente.get(i).setCompararBehavior(new CompararDni());
		}
		listaPaciente.sort(null);
	}
}
