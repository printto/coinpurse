package coinpurse;

import java.util.Random;

/**
 * 
 * @author Pappim Pipatkasrira
 * @version 1.0
 * @since Feb 17, 2017
 */

public class BankNote implements Valuable{
	public static final String DEFAULT_CURRENCY = "Baht";
	/** Value of the bank note. */
	private final double value;
	/** The currency, of course. */
	private final String currency;
	private static long nextSerialNumber = 1000000;
	private long serialNumber = 1000000;

	/**
	 * A bank note with given value using the default currency.
	 * @param value
	 */
	public BankNote( double value ) {
		this.value = value;
		this.currency = DEFAULT_CURRENCY;
		serialNumber = nextSerialNumber++;
	}

	/**
	 * A bank note with given value and currency.
	 * @param value
	 * @param currency
	 */
	public BankNote( double value, String currency ) {
		this.value = value;
		this.currency = currency;
		serialNumber = nextSerialNumber++;
	}

	/**
	 * Compare the value of 2 valuable objects.
	 * @return int of compareTo method.
	 */
	@Override
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

	/**
	 * @return value of the bank note.
	 */
	@Override
	public double getValue() {
		return value;
	}

	/**
	 * @return currency of the bank note.
	 */
	@Override
	public String getCurrency() {
		return currency;
	}
	
	/**
	 * @return serial of the bank note.
	 */
	public long getSerialNumber() {
		return serialNumber;
	}
	
	/**
	 * @return value, currency and serial number of the bank note
	 */
	public String toString(){
		return value + "-" + currency + " note " + serialNumber;
	}

}
