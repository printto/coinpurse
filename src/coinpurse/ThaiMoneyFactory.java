package coinpurse;

/**
 * Create money in Thai-Bath currency.
 * @author Pappim Pipatkasrira
 * @version 1.0
 * @since Feb 24, 2017
 */
public class ThaiMoneyFactory extends MoneyFactory{

	@Override
	public Valuable createMoney(double value) {
		if(value == 1 || value == 2 || value == 5 || value == 10){
			return new Coin(value);
		}
		else if(value == 20 || value == 50 || value == 100 || value == 500 || value == 1000){
			return new BankNote(value);
		}
		else{
			throw new IllegalArgumentException();
		}

	}

}
