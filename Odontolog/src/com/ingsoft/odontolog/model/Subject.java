package com.ingsoft.odontolog.model;

public interface Subject {
	public void notifyObservers();
	public void addObserver(Observer obs);
	public void removeObserver(Observer obs);
}
