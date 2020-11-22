package business.abstracts;

public abstract class Playable {
	
	private String path;
	
	public Playable(String path) {
		this.path = path;
	}

	public String getPath() {
		return path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
}