package coinpurse;

/**
 * Abstract of valuable objects.
 * Get values and currency and comparing valuable objects.
 * @author Pappim Pipatkasrira
 * @version 1.0
 * @since Feb 17, 2017
 */

public class AbstractValuable implements Valuable {

	public static final String DEFAULT_CURRENCY = "Baht";
	/** Value of the coin. */
	protected final double value;
	/** The currency, of course. */
	protected final String currency;
	
	/**
	 * A Valuable with given value using the default currency.
	 * @param value
	 */
	public AbstractValuable( double value ) {
		this.value = value;
		this.currency = DEFAULT_CURRENCY;
	}
	
	/**
	 * A Valuable with given value and currency.
	 * @param value currency
	 */
	public AbstractValuable( double value, String currency ) {
		this.value = value;
		this.currency = currency;
	}

	/**
	 * @return value of the coin.
	 */
	public double getValue() {
		return value;
	}

	/**
	 * @return currency of the coin
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * Check if the value of the coins are equal.
	 * @return true if the object are equal.
	 * @return false if the object are not equal.
	 */
	public boolean equals(Object obj) {
		if(obj.getClass() != this.getClass() || obj == null){
			return false;
		}
		Coin objCoin = ( Coin ) obj;
		return this.value == objCoin.getValue() && this.currency == objCoin.getCurrency();
	}

	/**
	 * Compare the value of 2 valuable objects.
	 * @return int of compareTo method.
	 */
	public int compareTo(Valuable other) {
		if( this == null ){
			return -1;
		}
		else if(this.value < other.getValue()){
			return -1;
		}
		else if(this.value > other.getValue()){
			return 1;
		}
		else{
			return 0;
		}
	}

}