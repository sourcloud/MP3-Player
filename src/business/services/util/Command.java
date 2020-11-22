package business.services.util;

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

	public static Command fromString(String command) {
		if (command != null && !command.isEmpty()) {
			for (Command toCompare : Command.values()) {
				String name = toCompare.name();
				if (name.equalsIgnoreCase(command)) {
					return toCompare;
				}
			}
		}
		return NONE;
	}

}
