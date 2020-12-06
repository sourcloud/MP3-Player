package presentation.uicomponents.controlview;

public enum Symbol {

	PLAY("\u25B6"),
	STOP("\u25A0"),
	SKIP("\u25B6\u25AE"),
	PAUSE("\u25AE\u25AE"),
	REPEAT("\u27F2"),
	SHUFFLE("\u292E"),
	SKIPBACK("\u25AE\u25C0");
	
	private String unicode;
	
	Symbol(String unicode) {
		this.unicode = unicode;
	}
	
	public String unicode() {
		return unicode;
	}
	
}
