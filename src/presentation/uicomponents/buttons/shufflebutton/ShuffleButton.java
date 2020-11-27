package presentation.uicomponents.buttons.shufflebutton;

import javafx.scene.control.Button;
import javafx.scene.shape.Circle;

public class ShuffleButton extends Button {
	
	private double radius = 15;
	
	public ShuffleButton(String text) {
		
		super(text);
		
		double diameter = 2 * this.radius;
		
		this.setShape(new Circle(diameter));
		this.setMinSize(diameter, diameter);
		this.setMaxSize(diameter, diameter);
		
	}

}
