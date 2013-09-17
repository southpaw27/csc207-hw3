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
		assertEquals(new BigInteger("64"), Calculator.eval0("2 ^ 3 ^ 2"));
		assertEquals(new BigInteger("18446744073709551616"), Calculator.eval0("2 ^ 64"));
		assertEquals(new BigInteger("3"), Calculator.eval0("6 / 2"));
		assertEquals(new BigInteger("1"), Calculator.eval0("100 ^ 0"));
	}

}
