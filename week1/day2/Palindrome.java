/*
 * Create a class to solve this problem with a meaningful name.
 * Implement the logic for reversing the digits of the given number
 * Check whether the given input and the output are equal. If they are equal, then the given input is a Palindrome and if not, the given input is not a Palindrome.
 * For Example
 * Input: 121 -> Output: It is a Palindrome (because the number reads the same backward and forward)
 * Input: 12345 -> Output: It is not a Palindrome (since the reversed number, 54321, is not the same as original)
 */

package week1.day2;

public class Palindrome {

	public static void main(String[] args) {
		// Declaring variables and data types and initialising input & output values
		int input = 1234554321, output = 0, digit;
		
		// checking for valid input before going into iteration to reverse
		if (input > 0) {
			
			// For loop to iterate and reverse the given number
			for (int i=input; i > 0; i= i/10) { // Increments logic to get the quotient and iterate the remaining digits 
				
				// Getting reminder to start reversing number
				digit = i%10;
				
				// Multiplying by 10 to increase decimal places before adding the new digit
				output = output * 10 + digit;
			}
			
			// If else block to check whether input and output matches to display appropriate msg to the user
			if (output == input) {
				
				// True block number is a palindrome
				System.out.println("The number "+input+" is a palindrome");
			}
			else {
				// False block number is not a palindrome
				System.out.println("The number "+input+" is a not palindrome");
			}
		}
		else {
			// Else block to handle <=0 inputs
			System.out.println("Provide a valid input to check for plaindrome");
		}

	}

}
