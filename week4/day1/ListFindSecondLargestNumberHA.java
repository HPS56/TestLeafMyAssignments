/*
 * Home Assignment --> Find Second Largest Number from the given array using List in Java..
 * Psuedo Code:
 * 		1. Get the array input from user
 * 		2. Use ArryaList list and add each value from array input to list
 * 		3. Use Index option to get the second largest number from the list to display to user 
 */

package week4.day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListFindSecondLargestNumberHA {

	public static void main(String[] args) {
		int[] inputSet = { 3, 2, 11, 4, 6, 7 };	// Getting array input from user
		List<Integer> numberList = new ArrayList<Integer>(); // ArrayList to add the values and sort

		for (int number : inputSet) {	// for each to iterate through array and add to list
			numberList.add(number);
		}

		Collections.sort(numberList);	// sorting arrayList
		
		// Get the second largest number from list using index (size of list minus 2),
		System.out.println("The second larget number in the given input is : " + numberList.get(numberList.size() - 2));

	}

}
