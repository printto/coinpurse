package coinpurse;

import java.text.DecimalFormat;

/**
 * a coin with a monetary value and currency
 * @author Pappim Pipatkasrira
 * @version 1.0
 * @since Feb 17, 2017
 */
public class Coin extends AbstractValuable {

	/**
	 * A coin with given value using the default currency.
	 * @param value
	 */
	public Coin( double value ) {
		super( value );
	}

	/**
	 * A coin with given value and currency.
	 * @param value
	 * @param currency
	 */
	public Coin( double value, String currency ) {
		super( value , currency );
	}

	/**
	 * Convert coin to string.
	 * @return Coin as a string.
	 */
	public String toString() {
		if ( currency.equals("Ringgit")) {
			DecimalFormat format = new DecimalFormat("0.##");
			return format.format(value*100) + "-Sen coin";
		}
		else {
			DecimalFormat format = new DecimalFormat("0.##");
			return format.format(value) + "-" + currency + " coin";
		}
	}
}
