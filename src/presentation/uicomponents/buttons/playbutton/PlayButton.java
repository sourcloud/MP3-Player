package presentation.uicomponents.buttons.playbutton;

import javafx.scene.control.Button;
import javafx.scene.shape.Circle;

public class PlayButton extends Button {

	private double radius = 50;
	
	public PlayButton(String text) {
		
		super(text);
		
		double diameter = 2 * this.radius;
		
		this.setShape(new Circle(diameter));
		this.setMinSize(diameter, diameter);
		this.setMaxSize(diameter, diameter);
	}
	
}
