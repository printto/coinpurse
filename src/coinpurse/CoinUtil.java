package coinpurse;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Some Coin utility methods for practice using Lists and Comparator.
 */
public class CoinUtil {

	/**
	 * Method that examines all the money in a List and returns
	 * only the money that have a currency that matches the parameter value.
	 * @param coinlist is a List of Coin objects. This list is not modified.
	 * @param currency is the currency we want. Must not be null.
	 * @return a new List containing only the elements from moneylist
	 *     that have the requested currency.  
	 */
	public static List<Valuable> filterByCurrency(final List<Valuable> moneyList, String currency) {
		List<Valuable> newMoneylist = new ArrayList<Valuable>();
		for( Valuable coin : moneyList ){
			if( coin.getCurrency().equals(currency) ){
				newMoneylist.add(coin);
			}
		}
		return newMoneylist; // return a list of coin references copied from moneyList
	}


	/**
	 * Method to sort a list of money by currency.
	 * On return, the list (Valuable) will be ordered by currency.
	 * @param money is a List of Coin objects we want to sort. 
	 *
	 * TODO:
	 * 1. Write a Comparator<Valuable> (you can write the class at the end of this file.
	 *    Declare it as "class CompareByCurrency" without the "public").
	 *    You can also write Comparator as an anonymous class, if you know how.
	 *    The compare method should order money by currency.
	 * 2. Create a comparator instance and use it to sort the money.
	 */
	public static void sortByCurrency(List<Valuable> money) {
		Collections.sort(money, new Comparator<Valuable>() {
			@Override
			public int compare(Valuable o1, Valuable o2) {
				return o1.getCurrency().compareTo(o2.getCurrency());
			}
		});
	}

	/**
	 * Sum money by currency and print the sum for each currency.
	 * Print one line for the sum of each currency.
	 * For example: 
	 * money = { Coin(1,"Baht"), Coin(20,"Ringgit"), Coin(10,"Baht"), Coin(0.5,"Ringgit") }
	 * then sumByCurrency(money) would print:
	 * 
	 * 11.00 Baht
	 * 20.50 Ringgit
	 * 
	 * Hint: this is easy if you sort the money by currency first. :-)
	 */
	public static void sumByCurrency(List<Valuable> money) {
		sortByCurrency(money);
		String currency = "";
		double sum = 0;
		ArrayList<String> total = new ArrayList<String>();
		for(int i = 0 ; i < money.size() ; i++){
			currency = money.get(i).getCurrency();
			sum = sum + money.get(i).getValue();
			if(i < money.size() - 1){
				if(!money.get(i).getCurrency().equals(money.get(i + 1).getCurrency())){
					total.add(sum + " " + currency);
					sum = 0;
				}
			}
		}
		for(String result : total){
			System.out.println(result);
		}
	}

	/**
	 * This method contains some code to test the above methods.
	 * @param args not used
	 */
	public static void main(String[] args) {
		String currency = "Rupee";
		System.out.println("Filter money by currency of "+currency);
		List<Valuable> money = makeInternationalmoney();
		int size = money.size();
		System.out.print(" INPUT: "); printList(money," ");
		List<Valuable> rupees = filterByCurrency(money, currency);
		System.out.print("RESULT: "); printList(rupees," ");
		if (money.size() != size) System.out.println("Error: you changed the original list.");

		System.out.println("\nSort money by currency");
		money = makeInternationalmoney();
		System.out.print(" INPUT: "); printList(money," ");
		sortByCurrency(money);
		System.out.print("RESULT: "); printList(money," ");

		System.out.println("\nSum money by currency");
		money = makeInternationalmoney();
		System.out.print("money= "); printList(money," ");
		sumByCurrency(money);

	}

	/** Make a list of money containing different currencies. */
	public static List<Valuable> makeInternationalmoney( ) {
		List<Valuable> money = new ArrayList<Valuable>();
		money.addAll( makemoney("Baht", 0.25, 1.0, 2.0, 5.0, 10.0, 10.0) );
		money.addAll( makemoney("Ringgit", 2.0, 50.0, 1.0, 5.0) );
		money.addAll( makemoney("Rupee", 0.5, 0.5, 10.0, 1.0) );
		// randomize the elements
		Collections.shuffle(money);
		return money;
	}

	/** Make a list of money using given values. */ 
	public static List<Valuable> makemoney(String currency, double ... values) {
		List<Valuable> list = new ArrayList<Valuable>();
		for(double value : values) list.add(new Coin(value,currency));
		return list;
	}

	/** Print the list on the console, on one line. */
	public static void printList(List items, String separator) {
		Iterator iter = items.iterator();
		while( iter.hasNext() ) { 
			System.out.print(iter.next());
			if (iter.hasNext()) System.out.print(separator);

		}
		System.out.println(); // end the line
	}
}
