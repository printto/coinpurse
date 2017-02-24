package coinpurse;

/**
 * Create money in Malaysian-Ringgit currency.
 * @author Pappim Pipatkasrira
 * @version 1.0
 * @since Feb 24, 2017
 */
public class MalayMoneyFactory extends MoneyFactory{

	@Override
	public Valuable createMoney(double value) {
		if(value == 0.05 || value == 0.10 || value == 0.20 || value == 0.50){
			return new Coin(value,"Ringgit");
		}
		else if(value == 1 || value == 2 || value == 5 || value == 10 || value == 20 || value == 50 || value == 100){
			return new BankNote(value,"Ringgit");
		}
		else{
			throw new IllegalArgumentException();
		}

	}

}
