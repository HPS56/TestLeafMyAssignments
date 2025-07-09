/*
 * The assignment requires comparing two arrays and printing matching elements.
 * int a[]={3,2,11,4,6,7};
 * int b[]=for {1,2,8,4,9,7};
 */

package week3.day1;

import java.util.Arrays;

public class FindIntersectionArrayAssignment {

	public static void main(String[] args) {

		// declaring array of int to take inputs
		int[] inputA = {3,2,11,4,6,7};
		int[] inputB = {1,2,8,4,9,7};
		
		// sorting arrays to optimise search
		Arrays.sort(inputA);
		Arrays.sort(inputB);
		
		System.out.println("The intersecting numbers for the given array sets are : ");
		// nested for loops to iterate array a and b to find matching values
		for (int i=0; i<inputA.length;i++) {
			for (int j=0; j<inputB.length; j++) {
				
				// checking whether the value of array at i is matching with value of array at j
				if (inputA[i]==inputB[j]) {
					System.out.print(inputA[i]+" ");
					break;
				}
			}
		}
		

	}

}
