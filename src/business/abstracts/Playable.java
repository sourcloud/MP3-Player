package business.abstracts;
/**
 * Class that represents a Playable Object.
 * 
 * @author Sascha Scheid
 */
public abstract class Playable {
	
	private String path;
	
	/**
	 * Initializes object with given path attribute
	 * @param path (String) Path to file.
	 */
	public Playable(String path) {
		this.path = path;
	}

	/**
	 * Getter for path attribute.
	 * @return (String) Path to file.
	 */
	public String getPath() {
		return path;
	}
	
	/**
	 * Setter for path attribute.
	 * @param path (String) Path to file.
	 */
	public void setPath(String path) {
		this.path = path;
	}
	
}