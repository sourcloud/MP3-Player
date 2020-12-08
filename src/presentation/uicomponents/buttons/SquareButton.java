package presentation.uicomponents.buttons;

import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;

public class SquareButton extends Button {

	private final static double DEFAULT_WIDTH = 30;
	
	public SquareButton(String text) {	
		this(text, DEFAULT_WIDTH);
	}
	
	public SquareButton(String text, double width) {
		
		super(text);
		
		this.getStyleClass().add("squarebutton");
		
		this.setShape(new Rectangle(width, width));
		this.setMinSize(width, width);
		this.setPrefSize(width, width);
		this.setMaxSize(width, width);
		
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
