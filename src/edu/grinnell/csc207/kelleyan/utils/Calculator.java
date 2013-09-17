package edu.grinnell.csc207.kelleyan.utils;


import java.math.BigInteger;

public class Calculator {

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
	}
	
//	public static int[] fewestCoins (int value) {
//		int[] coins = {2,7,11,54};
//		int[] change = new int[4];
//		
//		for (int x = 0); x >= 0; x--) {
//			if ()
//		}
//		
//		return change;
//	}
//}

	public static void main(String[] args) {
		System.out.println("answer is " + eval0("2 ^ 64"));
		}
}
	