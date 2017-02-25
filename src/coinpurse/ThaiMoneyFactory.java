package coinpurse;

/**
 * Create money in Thai-Bath currency.
 * @author Pappim Pipatkasrira
 * @version 1.0
 * @since Feb 24, 2017
 */
public class ThaiMoneyFactory extends MoneyFactory{
	
	/**
	 * Bank note serial number generating.
	 */
	private static long nextSerialNumber = 1000000;

	/**
	 * Create a money in Bath currency.
	 * @param value
	 * @return Valuable object
	 */
	@Override
	public Valuable createMoney(double value) {
		if(value == 1 || value == 2 || value == 5 || value == 10){
			return new Coin(value);
		}
		else if(value == 20 || value == 50 || value == 100 || value == 500 || value == 1000){
			return new BankNote(value , nextSerialNumber++);
		}
		else{
			throw new IllegalArgumentException();
		}

	}

}
