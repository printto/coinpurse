package coinpurse;

import java.util.ArrayList;
import java.util.Collections;

public class test {
	public static void main (String[] arg){
		
		Purse purse = new Purse( 3 );
		System.out.println( purse.getBalance( ) );
		System.out.println( purse.count( ));
		System.out.println( purse.isFull( ));
		System.out.println( purse.insert(new Coin(5)));
		System.out.println( purse.insert(new Coin(10)));
		System.out.println( purse.insert(new Coin(0)));
		System.out.println( purse.insert(new Coin(1)));
		System.out.println( purse.insert(new Coin(5)));
		System.out.println( purse.count( ));
		System.out.println( purse.isFull( ));
		System.out.println( purse.getBalance( ));
		System.out.println( purse.toString());
		System.out.println( purse.withdraw(12));
		Coin[] a =purse.withdraw(11);
		for (Coin coin: a){
			System.out.println(coin);
		}
//		(coins can be in any order in array)
		System.out.println( purse.getBalance());
	}
}
