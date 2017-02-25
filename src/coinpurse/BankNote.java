package coinpurse;

import java.util.Random;

/**
 * a bank note with a monetary value and currency
 * @author Pappim Pipatkasrira
 * @version 1.0
 * @since Feb 17, 2017
 */

public class BankNote extends AbstractValuable {
	
	private long serialNumber = 1000000;

	/**
	 * A bank note with given value using the default currency.
	 * @param value
	 */
	public BankNote( double value , long serial) {
		super(value,DEFAULT_CURRENCY);
		serialNumber = serial;
	}

	/**
	 * A bank note with given value and currency.
	 * @param value
	 * @param currency
	 */
	public BankNote( double value, String currency , long serial) {
		super(value,currency);
		serialNumber = serial;
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
