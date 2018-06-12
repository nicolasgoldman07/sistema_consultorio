package com.ingsoft.odontolog.main;
import com.ingsoft.odontolog.controller.Controller;
import com.ingsoft.odontolog.model.Model;
import com.ingsoft.odontolog.view.View;

public class Main {
	public static void main(String[] args) {
		View theView = new View();
		Model theModel = new Model();
    
		Controller theController = new Controller(theView, theModel);
	}
}
