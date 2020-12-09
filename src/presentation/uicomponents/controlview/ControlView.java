package presentation.uicomponents.controlview;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import presentation.application.AppColor;
import presentation.uicomponents.buttons.RoundButton;

public class ControlView extends HBox {
	
	protected Map<Symbol, Button> buttonMap;

	public ControlView() {
		
		initializeButtons();

		this.getChildren().addAll(
				buttonMap.get(Symbol.REPEAT),
				buttonMap.get(Symbol.SKIPBACK), 
				buttonMap.get(Symbol.STOP), 
				buttonMap.get(Symbol.PLAY), 
				buttonMap.get(Symbol.SKIP), 
				buttonMap.get(Symbol.SHUFFLE)
		);
		
		this.getStylesheets().add(getClass().getResource("control_style.css").toExternalForm());
		
	}
	
	private void initializeButtons() {
		
		buttonMap = new HashMap<>();
		
		for (Symbol symbol : Symbol.values()) {
			
			if (symbol.equals(Symbol.PAUSE)) // PLAY & PAUSE will be combined into one button
				continue;
			
			RoundButton toAdd = new RoundButton(symbol.unicode());
			
			Color fillColor = (symbol.equals(Symbol.REPEAT) || symbol.equals(Symbol.SHUFFLE)) 
								? AppColor.INACTIVE.color() 
								: AppColor.ACCENT_1.color();
									
			toAdd.setTextFill(fillColor);
			toAdd.setBackgroundColor(AppColor.ELEMENT.hex());
			
			buttonMap.put(symbol, toAdd);
			
		}
		
	}
	
}
