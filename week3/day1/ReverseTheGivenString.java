package week3.day1;

public class ReverseTheGivenString {

	public static void main(String[] args) {
		// Taking Inputs
		String input = "reenignE esreveR";
		
		// Converting given string to char array
		char[] inputChar = input.toCharArray();
		
		// For loop to iterate the char array from backward using (length - 1)
		for (int i=inputChar.length-1; i>= 0; i--) {
			
			// Printing to console using print statement
			System.out.print(inputChar[i]);
			
		}

	}

}
