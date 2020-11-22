package business.services;

import business.interfaces.Controller;

public class Main {

	public static void main(String[] args) { 		
		Controller c = new KeyboardController();
		c.start();
	}
	
	
}
