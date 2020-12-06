package presentation.application;

import javafx.scene.paint.Color;

public enum AppColor {

	FOUNDATION("#1a1a2e"),
	BACKGROUND("#16213e"),
	ELEMENT("#0f3460"),
	ACCENT_1("#5fb9b0"),
	ACCENT_2("#f6c90e"),
	INACTIVE("#4b5d67"),
	ERROR("#e94560");
	
	private String hex;
	
	AppColor(String hex) {
		this.hex = hex;
	}
	
	public String hex() {
		return hex;
	}
	
	public Color color() {
		return Color.valueOf(hex);
	}
}
