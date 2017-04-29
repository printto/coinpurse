package coinpurse.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import coinpurse.Valuable;

public class GreedyWithdraw implements WithdrawStrategy{

	@Override
	public List<Valuable> withdraw( double amount , List<Valuable> money) {

		List<Valuable> templist = new ArrayList<Valuable>();
		for(int i = money.size() -1 ; i >= 0 ; i--){
			if(amount - money.get(i).getValue() >= 0){
				amount = amount - money.get(i).getValue();
				templist.add(money.get(i));
			}
		}
		// Did we get the full amount?
		// This code assumes you decrease amount each time you remove a coin.
		if ( amount > 0 ) {
			// failed. Don't change the contents of the purse.
			return null;
		}
		return templist;
	}

}
