package coinpurse;

/**
 * Create moneys which are coins or bank notes in 2 currency, Bath and Ringgit.
 * @author Pappim Pipatkasrira
 * @version 1.0
 * @since Feb 24, 2017
 */

public abstract class MoneyFactory {

	private static MoneyFactory moneyFactory;

	/**
	 * Constructor
	 */
	protected MoneyFactory(){

	}
	
	/**
	 * Create or call a MoneyFactory
	 * @return MoneyFactory
	 */
	public static MoneyFactory getInstance(){
		if(moneyFactory == null){
			moneyFactory = new ThaiMoneyFactory();
		}
		return moneyFactory;
	}
	
	public abstract Valuable createMoney(double value);
	
	public Valuable createMoney(String value){
		return createMoney(Double.parseDouble(value));
	}
}
