package coinpurse;

import coinpurseGUI.ItemCountGUI;
import coinpurseGUI.ShowBalanceGUI;

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
		
		// 0. setup a MoneyFactory
		MoneyFactory moneyFactory = MoneyFactory.getInstance();
		moneyFactory.setMoneyFactory("ThaiMoneyFactory");
		
		// 1. create a Purse
		Purse purse = new Purse(20);
		
		// 1.5. add observer to the purse
		ShowBalanceGUI observer1 = new ShowBalanceGUI();
		ItemCountGUI observer2 = new ItemCountGUI();
		purse.addObserver(observer1);
		purse.addObserver(observer2);
		observer1.run();
		observer2.run();

		// 2. create a ConsoleDialog with a reference to the Purse object
		ConsoleDialog console = new ConsoleDialog(purse);

		// 3. run the ConsoleDialog
		console.run();

	}
}
