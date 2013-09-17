package edu.grinnell.csc207.kelleyan.utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestStringUtils {

	@Test
	public void test_toSplit() {
		assertArrayEquals(new String[] { "a", "b", "c" },
                StringUtils.splitAt("a:b:c", ':'));
		assertArrayEquals(new String[] { "a", "b", "c" },
                StringUtils.splitAt("a b c", ' '));
		assertArrayEquals(new String[] { "a:b:c" },
                StringUtils.splitAt("a:b:c", ' '));
		assertArrayEquals("one field", new String[] { "a" },
                StringUtils.splitAt("a", ':'));
		assertArrayEquals("empty inner field", new String[] { "a", "", "c" },
                StringUtils.splitAt("a::c", ':'));
		assertArrayEquals("leading empty field", new String[] { "", "a" },
                StringUtils.splitAt(":a", ':'));
		assertArrayEquals("trailing empty field", new String[] { "a", "" },
                StringUtils.splitAt("a:", ':'));
		/*Previous tests were taken from the examples on 
		 * the homework and were created by Sam Rebelsky
		 */
		assertArrayEquals("word separation", new String[] {"batter", "Average", "homeruns","walks"},
				StringUtils.splitAt("batter;Average;homeruns;walks", ';'));
		assertArrayEquals("long list", new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
				StringUtils.splitAt("1,2,3,4,5,6,7,8,9,10", ','));
		assertArrayEquals("no fields", new String[] {""},
				StringUtils.splitAt("", ','));
	}

	@Test
	public void test_splitCSV() {
		assertArrayEquals(new String[] { "a", "b", "c" },
                StringUtils.splitCSV("a,b,c"));
		assertArrayEquals(new String[] { "a,b", "c" },
                StringUtils.splitCSV("\"a,b\",c"));
		assertArrayEquals(new String[] { "a", "b,b\"", "c" },
                StringUtils.splitCSV("a,\"b,b\"\"\",c"));
	}
	
	@Test
	public void test_deLeet() {
		assertEquals("e", StringUtils.deLeet("3"));
		assertEquals("leet", StringUtils.deLeet("133+"));
		assertEquals("eat banana", StringUtils.deLeet("3@+ |3@|\\|@|\\|@"));
	}
}


