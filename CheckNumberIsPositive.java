/* Assignment Details:
 * Create a class named CheckNumberIsPositive with integer variable as version with value 10
 * Write a logic to print the given number Positive or Negative.
 */

package week1.day2;

public class CheckNumberIsPositive {

	public static void main(String[] args) {
		// Defining data types and initialising variables
		
		int version = 1;
		
		// Using if else statements to check whether version is positive or negative
		
		if(version==0) {
			// Block to handle if the number is neutral
			
			System.out.println(version+" : is a neutral number");
			
		}
		else if(version>0) {
			//  Block to handle if the number is positive
			
			System.out.println(version+" : is a positive number");
			
		}
		else {
			//  Block to handle if the number is negative
			
			System.out.println(version+" : is a negative number");
		}

	}

}
