package coinpurse;

import static org.junit.Assert.*;

import java.util.Collections;

import org.junit.Before;
import org.junit.Test;

import coinpurse.strategy.GreedyWithdraw;
import coinpurse.strategy.RecursiveWithdraw;

/**
 * Test between RecursiveWithdraw and GreedyWithdraw
 * @author Pappim Pipatkasrira
 * @version 1.0
 * @since Apr 28, 2017
 */
public class NewPurseTest {

	Purse purse;
	private static final double TOL = 1.0E-6;

	/**
	 * Set new purse capacity to 10 before testing.
	 */
	@Before
	public void setUp()
	{
		purse = new Purse(10);
		// set the withdraw strategy
		purse.setWithdrawStrategy(new RecursiveWithdraw());
	}

	/**
	 * Test RecursiveWithdraw deposite 5 2 2 2 and withdraw 6.
	 */
	@Test
	public void testRecursive1()
	{
		Coin coin1 = new Coin(5);
		Coin coin2 = new Coin(2);
		Coin coin3 = new Coin(2);
		Coin coin4 = new Coin(2);
		assertTrue( purse.insert(coin1));
		assertTrue( purse.insert(coin3));
		assertTrue( purse.insert(coin2));
		assertTrue( purse.insert(coin4));
		assertEquals( 4, purse.count() );
		Valuable [] result = purse.withdraw(6);
		assertEquals( 2 , result[0].getValue() , TOL);
		assertEquals( 2 , result[1].getValue() , TOL);
		assertEquals( 2 , result[2].getValue() , TOL);
	}

	/**
	 * Test GreedyWithdraw deposite 5 2 2 2 and withdraw 6.
	 */
	@Test
	public void testGreedy1()
	{
		purse.setWithdrawStrategy(new GreedyWithdraw());
		Coin coin1 = new Coin(5);
		Coin coin2 = new Coin(2);
		Coin coin3 = new Coin(2);
		Coin coin4 = new Coin(2);
		assertTrue( purse.insert(coin1));
		assertTrue( purse.insert(coin3));
		assertTrue( purse.insert(coin2));
		assertTrue( purse.insert(coin4));
		assertEquals( 4, purse.count() );
		Valuable [] result = purse.withdraw(6);
		assertEquals( 2 , result[1].getValue() , TOL);
		assertEquals( 2 , result[2].getValue() , TOL);
	}
	
	/**
	 * Test RecursiveWithdraw deposite 5 2 2 2 5 and withdraw 6.
	 */
	@Test
	public void testRecursive2()
	{
		Coin coin1 = new Coin(5);
		Coin coin2 = new Coin(2);
		Coin coin3 = new Coin(2);
		Coin coin4 = new Coin(2);
		Coin coin5 = new Coin(5);
		assertTrue( purse.insert(coin1));
		assertTrue( purse.insert(coin3));
		assertTrue( purse.insert(coin2));
		assertTrue( purse.insert(coin4));
		assertTrue( purse.insert(coin5));
		assertEquals( 5, purse.count() );
		Valuable [] result = purse.withdraw(6);
		assertEquals( 2 , result[0].getValue() , TOL);
		assertEquals( 2 , result[1].getValue() , TOL);
		assertEquals( 2 , result[2].getValue() , TOL);
	}

	/**
	 * Test GreedyWithdraw deposite 5 2 2 2 and withdraw 6.
	 */
	@Test
	public void testGreedy2()
	{
		purse.setWithdrawStrategy(new GreedyWithdraw());
		Coin coin1 = new Coin(5);
		Coin coin2 = new Coin(2);
		Coin coin3 = new Coin(2);
		Coin coin4 = new Coin(2);
		Coin coin5 = new Coin(5);
		assertTrue( purse.insert(coin1));
		assertTrue( purse.insert(coin3));
		assertTrue( purse.insert(coin2));
		assertTrue( purse.insert(coin4));
		assertTrue( purse.insert(coin5));
		assertEquals( 5, purse.count() );
		Valuable [] result = purse.withdraw(6);
		assertEquals( 2 , result[1].getValue() , TOL);
		assertEquals( 2 , result[2].getValue() , TOL);
	}

}
