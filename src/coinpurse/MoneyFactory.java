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
	
	/**
	 * Create a money in the current local currency.
	 * @param value
	 */
	public abstract Valuable createMoney(double value);
	
	/**
	 * Create a money in the current local currency.
	 * @param value as a string.
	 */
	public Valuable createMoney(String value){
		return createMoney(Double.parseDouble(value));
	}
	
	public static void setMoneyFactory(String factoryName){
		if( factoryName.equals( "ThaiMoneyFactory" ) ){
			moneyFactory = new ThaiMoneyFactory();
		}
		else if( factoryName.equals( "MalayMoneyFactory" ) ){
			moneyFactory = new MalayMoneyFactory();
		}
		else{
			System.out.println("Sorry, "+factoryName+" is not a type of MoneyFactory\nThe MoneyFactory is set to ThaiMoneyFactory (Default stage)");
		}
	}
	
	public abstract String getCurrency();
}
