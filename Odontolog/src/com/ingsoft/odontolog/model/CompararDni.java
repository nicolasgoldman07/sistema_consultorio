package com.ingsoft.odontolog.model;

public class CompararDni implements CompararStrategy{

	@Override
	public int ordenar(Paciente a, Paciente b) {
		return a.getDni().compareToIgnoreCase(b.getDni());
	}

}
