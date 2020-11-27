package business.services.util;

/**
 * Enum that represents user interaction commands.
 * 
 * @author Sascha Scheid
 */
public enum Command {
	
	LOAD,
	NONE,
	PAUSE,
	PLAY,
	QUIT,
	REPEAT,
	SHUFFLE,
	SKIP,
	SKIPBACK,
	STOP,
	VOLUME;

	/**
	 * Parses String to match a Command.
	 * @param toParse (String) String to parse.
	 * @return (Command) Command that matches provided String.
	 */
	public static Command fromString(String toParse) {
		
		if (toParse != null && !toParse.isEmpty()) {
			
			for (Command toCompare : Command.values()) {
				
				String name = toCompare.name();
				if (name.equalsIgnoreCase(toParse)) {
					return toCompare;
				}
			}
		}
		return NONE;
	}

}
