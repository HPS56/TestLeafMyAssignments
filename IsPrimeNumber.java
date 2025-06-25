/* Assignment Details
 * Create a class by name: IsPrime
 * Create a main method using shortcut
 * Write a logic to find if the given number is prime or not
 * Print if it is prime or not
 */

package week1.day2;

public class IsPrimeNumber {
	
	public static void main(String[] args) {
		// Logic to iterate from 1 to 13 to identify whether the current number is a prime or not
		
		int maxRange = 13; // Setting max range for number of iteration
		
		System.out.println("Lets find out whether each number in the range 1 to "+maxRange+" is a prime number or not:");
		
		// Starting a for loop to iterate until the range specified is met
		
		for (int i=1; i<=maxRange; i++) {
			// Defining condition to validate the current number is a prime or not
			
			if(i%2==1) {
				// if block to print prime numbers
				
				System.out.println(i+"   --> Prime");
			} 
			else {
				// else block to print non prime numbers
				
				System.out.println(i+"   --> Non Prime");
			}
			
		}
		
	}

}
