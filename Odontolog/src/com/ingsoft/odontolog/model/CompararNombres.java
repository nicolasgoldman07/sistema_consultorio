package com.ingsoft.odontolog.model;

public class CompararNombres implements CompararStrategy{

	@Override
	public int ordenar(Paciente a, Paciente b) {
		return a.getNombre().compareToIgnoreCase(b.getNombre());
	}

}
