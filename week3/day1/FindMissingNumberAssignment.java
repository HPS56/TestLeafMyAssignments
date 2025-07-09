/*
 * This program helps you practice array manipulation and looping in Java to find and print the first missing element in an array.
 * Find the missing element in the given array
 * Input -> {1, 4,3,2,8, 6, 7};
 * Output -> 5
 */
package week3.day1;

import java.util.Arrays;

public class FindMissingNumberAssignment {

	public static void main(String[] args) {
		// declaring array variables and assigning inputs
		int[] input = {1, 4,3,2,8, 6, 7};
		int count = 1; // assuming the value of the first index in array is 1 (after sort)

		// sorting array to form a sequence to find the missing numbers
		Arrays.sort(input);

		System.out.println("The missing number in the array input is : ");

		// for loop to iterate through the array and compare with iterator to find the
		// missing values
		for (int i = 0; i < input.length; i++) {

			// condition to check if the iterator + 1 is matching the numbers at each array
			if (count != input[i]) {
				System.out.print(count + " ");
				break;
			}
			count++;
		}

	}

}
