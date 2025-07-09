/*
 * Remove the duplicate words from a String with the input:
 * String text = “We learn Java basics as part of java sessions in java week1”;
 * Expected output: “We learn Java basics as part of sessions in week1”
 */

package week3.day1;

public class RemoveDuplicateWordsAssignment {

	public static void main(String[] args) {
		// declare variables to take inputs and track counts
		String inputString = "We learn Java basics as part of java sessions in java week1";
		int count = 0;

		// splitting input string using space as delimiter
		String[] stringBase = inputString.split(" ");

		// nested for loop to iterate the words to find duplicates
		for (int i = 0; i < stringBase.length; i++) {
			for (int j = i + 1; j < stringBase.length; j++) {
				if (stringBase[i].toLowerCase().equals(stringBase[j].toLowerCase())) {
					stringBase[j].replace(stringBase[j], ""); // replacing duplicate values using j as index
					count++;
				}
			}
		}
		// if block to check whether duplicates have been found using value of count
		if (count > 0) {
			for (int index = 0; index < stringBase.length; index++) {
				System.out.print(stringBase[index] + " "); // print final output removing duplicates
			}
		} else {
			System.out.println("No duplicate words found");
		}

	}

}
