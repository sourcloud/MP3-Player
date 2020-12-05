package business.services;

import business.interfaces.Controller;

public class MainCLI {

	public static void main(String[] args) { 		
		Controller c = new KeyboardController();
		c.start();
	}
	
	
}
