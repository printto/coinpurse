package coinpurse.strategy;

import java.util.ArrayList;
import java.util.List;

import coinpurse.Coin;
import coinpurse.Valuable;

public class RecursiveWithdraw implements WithdrawStrategy{

	@Override
	public List<Valuable> withdraw(double amount, List<Valuable> money) {

		if(amount == 0) {
			return new ArrayList<Valuable>();
		}
		
		if(money.isEmpty()) return null;

		if(money.size() > 0){
			//Case 1
			List<Valuable> withdraw1 = withdraw (amount - money.get(0).getValue() , money.subList(1 , money.size()));
			if(withdraw1 != null){
				List<Valuable> toAdd = new ArrayList<Valuable>();
				toAdd.add(money.get(0));
				toAdd.addAll(withdraw1);
				return toAdd;
			}
			//Case 2
			List<Valuable> withdraw2 = withdraw (amount, money.subList(1 , money.size()));
			if( withdraw2 != null){
				List<Valuable> toAdd = new ArrayList<Valuable>();
				toAdd.add(money.get(0));
				toAdd.addAll(withdraw2);
				return toAdd;
			}
		}

		return null;
	}
}
