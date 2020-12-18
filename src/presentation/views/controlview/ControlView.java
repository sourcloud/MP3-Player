package presentation.views.controlview;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import presentation.application.AppColor;
import presentation.components.buttons.RoundButton;

public class ControlView extends VBox {
	
	protected Map<Symbol, Button> buttonMap;
	
	protected Label currentTimeLabel;
	protected Label maxTimeLabel;
	
	protected Label minVolume;
	protected Label maxVolume;
	
	protected Slider timeSlider;
	protected Slider volumeSlider;
	
	
	public ControlView() {
		
		initializeButtons();
		initializeTimeControls();
		initializeVolumeControls();
		
		HBox buttonControl = new HBox();
		HBox songTimeControl = new HBox();
		HBox volumeControl = new HBox();
		
		buttonControl.getChildren().addAll(
			buttonMap.get(Symbol.REPEAT),
			buttonMap.get(Symbol.SKIPBACK), 
			buttonMap.get(Symbol.STOP), 
			buttonMap.get(Symbol.PLAY), 
			buttonMap.get(Symbol.SKIP), 
			buttonMap.get(Symbol.SHUFFLE)
		);
		
		songTimeControl.getChildren().addAll(
			currentTimeLabel, 
			timeSlider, 
			maxTimeLabel
		);
		
		volumeControl.getChildren().addAll( 
			minVolume,
			volumeSlider,
			maxVolume
		);
		
		this.getChildren().addAll(songTimeControl, buttonControl, volumeControl);
		
		this.getStylesheets().add(getClass().getResource("control_style.css").toExternalForm());
		
	}
	
	private void initializeButtons() {
		
		buttonMap = new HashMap<>();
		
		for (Symbol symbol : Symbol.values()) {
			
			if (symbol.equals(Symbol.PAUSE)) // PLAY & PAUSE will be combined into one button, so ignore here
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
	
	private void initializeTimeControls() {
		
		currentTimeLabel = new Label("0:00");
		currentTimeLabel.setTextFill(AppColor.ACCENT_1.color());
		
		timeSlider = new Slider();
		timeSlider.setPrefWidth(300);
		timeSlider.setMin(0);
		timeSlider.setValue(0);
		
		maxTimeLabel = new Label("0:00");
		maxTimeLabel.setTextFill(AppColor.ACCENT_1.color());
	}
	
	private void initializeVolumeControls() {
		
		minVolume = new Label(Symbol.QUIET.unicode());
		minVolume.setTextFill(AppColor.ACCENT_1.color());
		
		volumeSlider = new Slider();
		volumeSlider.setMin(0);
		volumeSlider.setMax(5);
		volumeSlider.setValue(2);
		
		maxVolume = new Label(Symbol.LOUD.unicode());
		maxVolume.setTextFill(AppColor.ACCENT_1.color());
		
	}
	
}
