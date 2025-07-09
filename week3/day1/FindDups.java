package week3.day1;

import java.util.Arrays;

public class FindDups {

	public static void main(String[] args) {
		// Input array
		int[] num= {2, 5, 7, 7, 5, 9, 2, 3};
		
		// sorting array
		Arrays.sort(num);
		
		//Outer loop to initiate iteration from index [0]
		System.out.print("The duplicates in the given array is : ");
		for (int i=0; i<num.length;i++) {
			
			//Inner loop to compare from the second index [i + 1]
			for (int j=i+1; j<num.length;j++) {
				
				//if there is match, it will print and break the for loop
				if (num[i]==num[j]) {
					
					//printing duplicates
					System.out.print(num[j]);
					break;
				}
			}
		}
		

	}

}
