package edu.grinnell.csc207.kelleyan.utils;

/**
 * This class was created by Andrew Kelley 
 * for the Grinnell College csc207 homework 3 project
 * on 9-16-2013
 * @author Andrew Kelley
 *
 */
public class StringUtils {
	
	/**
	 * splitAt takes a string and separates it into substrings
	 * with the separation point being the char splitter.
	 * 
	 * @param toSplit, a string whose components are separated
	 * by splitter
	 * splitter, the character separating parts of the string, 
	 * toSplit
	 * 
	 * @return an array of strings that are formed from
	 * splitting toSplit at the character splitter
	 */
	public static String[] splitAt (String toSplit, char splitter) {
	
		int placeHolder = 0; //tracks latest position of new substring
		int arrayCount = 0; //tracks of position of array entries
		int numberOfSplitters = 0; /*counts number of splitters so that
									*the length of array will be correct
									*/
		for (int x = 0; x < toSplit.length(); x++) {
			if (toSplit.charAt(x) == splitter)
				numberOfSplitters += 1;
		}
		/*
		 * creates array to return with the correct number of 
		 * elements based on number of splitters plus 1
		 */
		String[] splitArray = new String[numberOfSplitters + 1];
		for (int x = 0; x < toSplit.length(); x++){
			if (toSplit.charAt(x) == splitter) {
				splitArray[arrayCount] = 
						toSplit.substring(placeHolder, x);
				placeHolder = x + 1;
				arrayCount += 1;
			}
		}
	    //adds substring from last splitter to end of string
		splitArray[arrayCount] = 
				toSplit.substring(placeHolder);
		return splitArray;
	}//splitAt(string, char)

	
	/**
	 * splitCSV takes a string with a comma as a separator and
	 * returns a string array that consists of the separated 
	 * parts of the original string. splitCSV also takes into
	 * account more than one quotation mark in a sequence and
	 * considers them characters instead of the stop of a string
	 * 
	 * @param toSplit, a comma separated string
	 * 
	 * @return a string array with the separations created by
	 * the commas in the original string
	 */
	
/*
 * Right now, splitCSV is not working completely. It works when
 * there are no double quotes and it also works when there are sets
 * of double quotes grouping different elements. It does not work
 * when there are more than one quote in a sequence. I have spend 
 * too much time trying to figure out how to do this right now
 * but will return when my brain can handle the annoyance of 
 * double quotations.
 * 
 * The odd green // comments in the middle of the code were my
 * attempts to make the double quotes work and are commented out
 * to make the rest of the method work.
 */
	public static String[] splitCSV (String toSplit) {
		int placeHolder = 0; //tracks latest position of new substring
		int arrayCount = 0; //tracks of position of array entries
		int numberOfSplitters = 0; /*counts number of splitters so that
									*the length of array will be correct
									*/
		for (int x = 0; x < toSplit.length(); x++) {
			if (toSplit.charAt(x) == ',')
				numberOfSplitters += 1;
			else if (toSplit.charAt(x) == '"') {
				x++;
				while (toSplit.charAt(x) != '"') {
					x++;
				}
			}
		}
		String[] splitArray = new String[numberOfSplitters + 1];
		for (int x = 0; x < toSplit.length(); x++){
			if (toSplit.charAt(x) == ',') {
				if (toSplit.charAt(x - 1) == '"') {
					placeHolder = x + 1;
				}
				else {
					splitArray[arrayCount] = 
							toSplit.substring(placeHolder, x);
					placeHolder = x + 1;
					arrayCount += 1;
				}
			}
			else if(toSplit.charAt(x) == '"') {
//				if (toSplit.charAt(x + 1) == '"') {
//					placeHolder = x + 2;
//					x += 2;
//				}
//				else {
				placeHolder = x + 1;
				x++;
//				}
				while (toSplit.charAt(x) != '"') {
//					if (x == toSplit.length() - 1)
//						break;
//					if (toSplit.charAt(x + 1) == '"') {
//						x += 2;
//					}
//					else
						x++;
				}
				splitArray[arrayCount] = 
						toSplit.substring(placeHolder, x);
				placeHolder = x + 1;
				arrayCount += 1;
			} 
		}
		splitArray[arrayCount] = 
				toSplit.substring(placeHolder);
		return splitArray;
	}//splitCSV(String)
	
	
	/**
	 * deLeet takes a string written in leet, or hacker code,
	 * and translates it into readable English
	 *
	 * @param leet, a string in the form of 133+ (leet)
	 * 
	 * @return deLeet, a string in English
	 */
	public static String deLeet(String leet) {
		String deLeet = "";
		for (int x = 0; x < leet.length(); x++) {
			if (leet.charAt(x) == '@')
				deLeet += 'a';
			else if (leet.charAt(x) == '|' && leet.charAt(x + 1) == '3') {
				deLeet += 'b';
				x++;
			}
			else if (leet.charAt(x) == '3')
				deLeet += 'e';
			else if (leet.charAt(x) == '1')
				deLeet += 'l';
			else if (leet.charAt(x) == '|' && leet.charAt(x + 1) == '\\' 
					&& leet.charAt(x + 2) == '|') {
				deLeet += 'n';
				x += 2;
			}
			else if (leet.charAt(x) == '0')
				deLeet += 'o';
			else if (leet.charAt(x) == '+')
				deLeet += 't';
			else if (leet.charAt(x) == ' ')
				deLeet += ' ';
			else
				deLeet += leet.charAt(x);
		}
		return deLeet;
	}//deLeet(String)
	
	/**
	 * nameGame takes a name in string form and returns a 
	 * verse of the "Name Game" by Shirley Ellis. 
	 * 
	 * Credit for the way the game works with names starting 
	 * with vowels goes to Wikipedia at:
	 * http://en.wikipedia.org/wiki/The_Name_Game
	 * 
	 * @param name, a string
	 * 
	 * @return a verse of the name game using the string name
	 */
	public static String nameGame(String name) {
		String verse = "";
		String lowerName = name.toLowerCase();
		int count = 0;
		while(lowerName.charAt(count) != 'a' && lowerName.charAt(count) != 'e'
			   && lowerName.charAt(count) != 'i' && lowerName.charAt(count) != 'o'
			   && lowerName.charAt(count) != 'u') {
			count++;
		}
		String strippedName;
		if(count == 0)
			strippedName = lowerName;
		else
			strippedName = name.substring(count);
		
		verse += name + "!" + "\n";
		verse += name + ", " + name + " bo ";
		verse += "B" + strippedName + " Bonana ";
		verse += "fanna fo " + "F" + strippedName + "\n";
		verse += "Fee fy mo M" + strippedName +", " + name + "!";
		
		return verse;
	}
	
	/**
	 * Here is a main method to show the output of various
	 * names input into the nameGame method. Feel free to 
	 * highlight and control / them to uncomment and run
	 * @param args
	 */
	public static void main(String[] args) {
//		System.out.println(nameGame("Shirley"));
//		System.out.println(nameGame("Lincoln"));
//		System.out.println(nameGame("Matthew"));
//		System.out.println(nameGame("Steven"));
//		System.out.println(nameGame("Andrew"));
//		System.out.println(nameGame("Eric"));
		String[] str = splitCSV("a,\"b,b\",c");
		for (int x = 0; x < str.length; x++) {
			System.out.println(str[x]);
		}
	}
}





