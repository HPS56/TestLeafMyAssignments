/*
 * To determine whether two given strings have the same characters, regardless of their order, thereby indicating that they are anagrams of each other.
 */
package week3.day1;

import java.util.Arrays;

public class AnagramHomeAssignment {

	public static void main(String[] args) {

		// Initialising arrays and taking inputs
		String input1 = "stops", input2 = "potss";
		boolean isAnagram; // Declaring boolean to check and set (t/f)

		// if else block to check whether the length of the two given strings are same
		if (input1.length() == input2.length()) {

			isAnagram = true; // Assuming true as the strings are of the same length
			// Block to handle when the two input string length is same
			// Declaring char array and storing the input string as char array
			char[] input1Char = input1.toCharArray();
			char[] input2Char = input2.toCharArray();

			// Sorting array to prepare for comparison.
			Arrays.sort(input1Char);
			Arrays.sort(input2Char);

			// Using for loop to traverse through the array to see if the chars value are
			// same
			for (int i = 0; i < input1.length(); i++) {

				if (input1Char[i] != input2Char[i]) {
					// Setting isAnagram as false if any of the given char at current index is not
					// the same in both char arrays
					isAnagram = false;
					break;
				}
			}

		} else {
			// setting as false as the input strings are not of the same size
			isAnagram = false;
		}

		// if block to check whether isAnagram is true or false to confirm whether the
		// the given strings are anagram or not
		if (isAnagram) {
			System.out.println("The given string inputs are an Anagram!!");
		} else {
			System.out.println("The given string inputs are not an Anagram!!");
		}

	}

}
