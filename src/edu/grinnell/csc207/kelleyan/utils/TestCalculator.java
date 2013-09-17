package edu.grinnell.csc207.kelleyan.utils;

import static org.junit.Assert.*;

import org.junit.Test;
import java.math.BigInteger;
public class TestCalculator {

	@Test
	public void test_Calc() {
		assertEquals(new BigInteger("0"), Calculator.eval0("0"));
		assertEquals(new BigInteger("2"), Calculator.eval0("1 + 1"));
		assertEquals(new BigInteger("4"), Calculator.eval0("1 + 2 + 1"));
		assertEquals(new BigInteger("9"), Calculator.eval0("1 + 2 * 3"));
		//Above tests were taken from the homework written by Sam Rebelsky
		assertEquals(new BigInteger("64"), Calculator.eval0("2 ^ 3 ^ 2"));
		assertEquals(new BigInteger("18446744073709551616"), Calculator.eval0("2 ^ 64"));
		assertEquals(new BigInteger("3"), Calculator.eval0("6 / 2"));
		assertEquals(new BigInteger("1"), Calculator.eval0("100 ^ 0"));
	}//test_Calc()
	
	@Test
	public void test_fewestCoins() {
		//coin tests from Yksleber
		assertArrayEquals(new int[] {0,4,0,0},
				Calculator.fewestCoins(28, new int[] {2,7,11,54}));
		assertArrayEquals(new int[] {1,1,1,0},
				Calculator.fewestCoins(20, new int[] {2,7,11,54}));
		assertArrayEquals(new int[] {0,0,6,0},
				Calculator.fewestCoins(66, new int[] {2,7,11,54}));
		
		//coin tests with US coins
		assertArrayEquals(new int[] {0,1,0,1},
				Calculator.fewestCoins(30, new int[] {1,5,10,25}));
		assertArrayEquals(new int[] {0,1,1,1},
				Calculator.fewestCoins(40, new int[] {1,5,10,25}));
	}//test_fewestCoins()

}//TestCalculator
