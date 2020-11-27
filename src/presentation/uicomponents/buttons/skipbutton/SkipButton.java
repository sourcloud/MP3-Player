package presentation.uicomponents.buttons.skipbutton;

import javafx.scene.control.Button;
import javafx.scene.shape.Circle;

public class SkipButton extends Button {
	
	private double radius = 25;
	
	public SkipButton(String text) {
		
		super(text);
		
		double diameter = 2 * this.radius;
		
		this.setShape(new Circle(diameter));
		this.setMinSize(diameter, diameter);
		this.setMaxSize(diameter, diameter);
	}

}
