package coinpurse;

/**
 * Create money in Malaysian-Ringgit currency.
 * @author Pappim Pipatkasrira
 * @version 1.0
 * @since Feb 24, 2017
 */
public class MalayMoneyFactory extends MoneyFactory{
	
	/**
	 * Bank note serial number generating.
	 */
	private static long nextSerialNumber = 1000000;
	
	/**
	 * Currency of the money
	 */
	public final String CURRENCY = "Ringgit";

	/**
	 * Create a money in Ringgit currency.
	 * @param value
	 * @return Valuable object
	 */
	@Override
	public Valuable createMoney (double value) {
		if(value == 0.05 || value == 0.10 || value == 0.20 || value == 0.50){
			return new Coin( value , CURRENCY );
		}
		else if(value == 1 || value == 2 || value == 5 || value == 10 || value == 20 || value == 50 || value == 100){
			return new BankNote( value, CURRENCY , nextSerialNumber++ );
		}
		else{
			throw new IllegalArgumentException();
		}

	}

	/**
	 * Get currency
	 * @return CURRENCY
	 */
	@Override
	public String getCurrency(){
		return CURRENCY;
	}

}
