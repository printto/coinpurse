package coinpurse;

/**
 * A main class to create objects and connect objects together.
 * The user interface needs a reference to coin purse.
 * @author Pappim Pipatkasrira
 */
public class Main {

	/**
	 * Configure and start the application.
	 * @param args not used
	 */
	public static void main( String[] args ) {
		// 1. create a Purse
		Purse purse = new Purse(20);

		// 2. create a ConsoleDialog with a reference to the Purse object
		ConsoleDialog console = new ConsoleDialog(purse);

		// 3. run the ConsoleDialog
		console.run();

	}
}
