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
		this.setMinSize(diameter, diameter);
		this.setPrefSize(diameter, diameter);
		this.setMaxSize(diameter, diameter);

	}
	
	public void setBackgroundColor(String hex) {
		String newStyle = "-fx-background-color: " + hex + ";";
		addStyle(newStyle);
	}
	
	private void addStyle(String newStyle) {
		String oldStyle = this.getStyle();
		this.setStyle(oldStyle + newStyle);
	}
	
}
