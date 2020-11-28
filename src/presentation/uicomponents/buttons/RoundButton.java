package presentation.uicomponents.buttons;

import javafx.scene.control.Button;
import javafx.scene.shape.Circle;

public class RoundButton extends Button {

	private double radius = 30;
	
	public RoundButton(String text) {
		
		super(text);

		this.getStyleClass().add("roundbutton");
		
		double diameter = 2 * this.radius;
		
		this.setShape(new Circle(diameter));
		this.setPrefSize(diameter, diameter);

	}
	
}
