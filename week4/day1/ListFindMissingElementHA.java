/*
 * Home Assignment --> Find missing element in a number sequence using List in Java..
 * Psuedo Code:
 * 		1. Get the array input from user
 * 		2. Use 2 TreeSet list 1--> to add array input 2--> to add missing numbers
 * 		3. Use for loop to iterate between .getFirst (smallest) and .getLast (largest)
 * 		4. Check if the current count is present in TreeSet using contains method
 * 		5. If not present add to the new TreeSet to print
 */

package week4.day1;

import java.util.Arrays;
import java.util.TreeSet;

public class ListFindMissingElementHA {

	public static void main(String[] args) {
		
		// Taking array input, declaring two TreeSet to process and add missing numbers
		Integer[] inputNumber = { 1, 2, 3, 4, 10, 6, 8 };
		TreeSet<Integer> numberSequence = new TreeSet<Integer>();
		TreeSet<Integer> missingNumbers = new TreeSet<Integer>();
		
		// Adding input array to TreeSet as array list
		numberSequence.addAll(Arrays.asList(inputNumber));

		// Using for loop to iterate between first and last value in the TreeSet (smallest to largest)
		for (int count = numberSequence.getFirst(); count <= numberSequence.getLast(); count++) {

			// Check whether the current count is not present and adding to new TreeSet
			if (!numberSequence.contains(count)) {
				missingNumbers.add(count);
			}
		}
		
		// Printing input and processed outputs
		System.out.println("The given number sequence is \t\t\t: "+Arrays.asList(inputNumber));
		System.out.println("The ordered number sequence is \t\t\t: "+numberSequence);
		System.out.println("The missing numbers in squence are \t\t: "+missingNumbers);

	}

}
