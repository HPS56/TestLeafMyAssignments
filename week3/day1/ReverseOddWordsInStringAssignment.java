/*
 * Reverse the odd position words from a String with the input:
 * String test = "I am a software tester";
 * Expected output: “I ma a erawtfos tester”
 */
package week3.day1;

public class ReverseOddWordsInStringAssignment {

	public static void main(String[] args) {
		// declare variables to take inputs and process output
		String input = "I am a software tester";

		// splitting string to words
		String[] inputStringSplit = input.split(" ");

		// using for loop to identify odd / even index
		for (int index = 0; index < inputStringSplit.length; index++) {

			// if block to identify whether the index is odd or not
			if (index % 2 != 0) {
				// declaring char array to reverse the odd word
				char[] oddWordChar = inputStringSplit[index].toCharArray();

				// use for loop to print the char in reverse
				for (int j = oddWordChar.length - 1; j >= 0; j--) {
					System.out.print(oddWordChar[j]);
				}
				// adding space for formatting after printing reversed word
				System.out.print(" ");
			} else {
				// block to print even words
				System.out.print(inputStringSplit[index] + " ");
			}
		}

	}

}
