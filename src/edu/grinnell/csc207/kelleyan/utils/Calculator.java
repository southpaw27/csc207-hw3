package edu.grinnell.csc207.kelleyan.utils;


import java.math.BigInteger;

/**
 * This class was created by Andrew Kelley 
 * for the Grinnell College csc207 homework 3 project
 * on 9-16-2013
 * @author Andrew Kelley
 *
 */
public class Calculator {

	/**
	 * eval0 is a calculator that takes a string of operations
	 * as input and returns their result as a BigInteger
	 * 
	 * @param expr, a string with an operation to be solved
	 * 
	 * @return a BigInteger that is the result of expr
	 */
	
	/*
	 * Thanks to John Brady and Mira Hall for reminding how
	 * to declare BigInteger methods and variables.
	 */
	public static BigInteger eval0 (String expr) {
		String[] expression = StringUtils.splitAt(expr, ' ');
		BigInteger answer = new BigInteger(expression[0]);
		for (int x = 1; x < expression.length; x++) {
			String op = expression[x];
			if (op.charAt(0) == '+') {
				answer = answer.add(new BigInteger(expression[x + 1]));
			}
			else if (op.charAt(0) == '-') {
				answer = answer.subtract(new BigInteger(expression[x + 1]));
			}
			else if (op.charAt(0) == '*') {
				answer = answer.multiply(new BigInteger(expression[x + 1]));
			}
			else if (op.charAt(0) == '/') {
				answer = answer.divide(new BigInteger(expression[x + 1]));
			}
			else if (op.charAt(0) == '^') {
				answer = answer.pow(new Integer(expression[x + 1]));
				}
		}
		return answer;
	} //eval0(String)
	
	/**
	 * fewestCoins takes an integer value and an array of coin
	 * values, preferably from lowest to highest in value, and 
	 * find the smallest amount of coins to make change for the
	 * given value.
	 * 
	 * @param value, an amount to make change for
	 * @param coins, the integer array of coin values
	 * @return an integer array of values whose numbers and position
	 * correspond to the amount of coins needed for each coin value.
	 * returns -1 if change is not able to be made successfully. 
	 */
	public static int[] fewestCoins (int value, int[] coins) {
		int len = coins.length;
		int[] change = new int[len];/*numbers of coins to be 
									stored here
									*/
		int changeSum = 0;
		int totalCoins = -1;
		//default value for total number of coins
		
		/*
		 * This for loop finds the smallest number of coins
		 * by first using the largest coin and working its 
		 * way down to the smallest, comparing the total
		 * number of coins as it goes as to always have the
		 * smallest number of total coins used.
		 */
		for (int x = len - 1; x >= 0; x--) {
			int[] coinCount = new int[len];
			int remainder;
			
			if (coins[x] <= value) {
				coinCount[x] = value / coins[x];
				remainder = value % coins[x];
				for(int y = x - 1; y >= 0; y--) {
					coinCount[y] = remainder / coins[y];
					remainder = remainder % coins[y];
				}
			}
			else
				continue;
			/*
			 * The next few lines are used to first find the
			 * total number of coins, and then to place the coin
			 * numbers into the change array if the total number
			 * is smaller than the previous total number of coins
			 */
			int numberOfCoins = 0;
			for (int z = 0; z < len; z++) {
				numberOfCoins += coinCount[z];
			}
			if (totalCoins == -1) {
				for (int a = 0; a < len; a++) {
					change[a] = coinCount[a];
				}
				totalCoins = numberOfCoins;
			}
			else if(numberOfCoins < totalCoins) {
				for (int b = 0; b < len; b++) {
					change[b] = coinCount[b];
				}
				totalCoins = numberOfCoins;
			}
			changeSum = 0;
			for (int c = 0; c < len; c++) {
				changeSum += coins[c]*change[c];
			}
			if(changeSum != value)
				totalCoins = -1;
				continue;

	}
		/*
		 * Here is the error checking. If the sum of change does
		 * not equal the value input, then -1 is returned as the
		 * value cannot be made in change
		 */
		if (changeSum != value)
			return new int[] {-1};
		
		return change;
} // fewestCoins(int, int[])

	public static void main(String[] args) {
		int[] coins = fewestCoins(66, new int[] {2,7,11,54});
		for(int x = 0; x < coins.length; x++) {
			System.out.println(coins[x]);
		}
	} // main
	
} // Calculator
	