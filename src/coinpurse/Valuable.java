package coinpurse;

/**
 * An interface for objects having a monetary value and currency.
 * @author Pappim Pipatkasrira
 * @version 1.0
 * @since Feb 17, 2017
 */

public interface Valuable extends Comparable<Valuable> {

	/**
	 * Get monetary value of this object, in it's own currency.
	 * @return the value of this object
	 */
	public double getValue();
	
	/**
	 * Get monetary currency of this object.
	 * @return the currency of this object
	 */
	public String getCurrency();
}
