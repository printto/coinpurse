package coinpurse.strategy;

import java.util.List;
import java.util.ArrayList;
import coinpurse.Valuable;

/**
 * Strategy to use for withdrawing money.
 * @author Pappim Pipatkasrira
 * @version 1.0
 * @since Apr 28, 2017
 */
public interface WithdrawStrategy {
	
	/**
	 * Withdraw money
	 * @param amount of the money.
	 * @param money as a List.
	 * @return List of money to be remove or return.
	 */
	public List<Valuable> withdraw( double amount , List<Valuable> money);

}
