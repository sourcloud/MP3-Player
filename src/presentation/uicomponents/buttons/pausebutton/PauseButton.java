package presentation.uicomponents.buttons.pausebutton;

import javafx.scene.control.Button;
import javafx.scene.shape.Circle;

public class PauseButton extends Button {
	
	private double radius = 25;
	
	public PauseButton(String text) {
		
		super(text);
		
		double diameter = 2 * this.radius;
		
		this.setShape(new Circle(diameter));
		this.setMinSize(diameter, diameter);
		this.setMaxSize(diameter, diameter);
	}

}
