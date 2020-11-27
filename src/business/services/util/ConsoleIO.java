package business.services.util;

import de.hsrm.mi.prog.util.StaticScanner;

/**
 * Utility class that provides static methods for console interaction.
 * 
 * @author Sascha Scheid
 *
 */
public class ConsoleIO {

	/**
	 * Asks user for console input.
	 * 
	 * @return (String) User input.
	 */
	public static String askForUserInput() {
		System.out.print("> ");
		return StaticScanner.nextString().trim();
	}

	/**
	 * Prints Menu to the console.
	 */
	public static void printMenu() {
		System.out.println("Available commands: ");
		System.out.println(Command.PLAY + " [song] \t - start the song");
		System.out.println(Command.STOP + " \t\t - stops the player");
		System.out.println(Command.LOAD + " [playlist]  - loads playlist");
		System.out.println(Command.PAUSE + " \t\t - pauses the player");
		System.out.println(Command.REPEAT + " \t\t - toggle shuffle all / one / none");
		System.out.println(Command.SHUFFLE + "\t\t - toggles shuffle on / off");
		System.out.println(Command.SKIP + "\t\t - skip to next track");
		System.out.println(Command.SKIPBACK + "\t - skip to previous track");
		System.out.println(Command.VOLUME + " [gain] \t - sets volume to gain level");
		System.out.println(Command.QUIT + " \t\t - exits the application");
	}

}
