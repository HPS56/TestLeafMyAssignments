package week4.day2;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class LearningSet {

	public static void main(String[] args) {
		String companyName = "google";
		
		char[] charArray = companyName.toCharArray(); 					// Converting given string to a char array
		Set<Character> uniqueSet = new LinkedHashSet<Character>();		// Creating a new LinkedHashSet to print unique values in insertion order
		Set<Character> duplicateSet = new HashSet<Character>();			// Optional set to print duplicate values

		for (char character : charArray) {								// For each loop to iterate char in char array

			boolean duplicate = uniqueSet.add(character);				// Assessing the boolean return type true / false; true --> char added to set;false --> char already exists in set
			if (!duplicate)												// If false, then write to new set to capture duplicate char
				duplicateSet.add(character);
		}

		System.out.println("Unique Characters in the given string "+ companyName +" is : "+uniqueSet);	//Printing unique characters in given string
	}

}
