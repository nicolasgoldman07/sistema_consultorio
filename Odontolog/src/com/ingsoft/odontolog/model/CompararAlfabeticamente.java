package com.ingsoft.odontolog.model;

public class CompararAlfabeticamente implements CompararStrategy{

	@Override
	public int ordenar(Paciente a, Paciente b) {
		return a.getNombreCompleto().compareToIgnoreCase(b.getNombreCompleto());
	}

}
