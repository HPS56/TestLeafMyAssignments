/*
 * Assignment Details:
 * To find Fibonacci Series for a given range
 * Input(range): 8 
 */

package week1.day2;

public class FibonacciSeries {

	public static void main(String[] args) {
		
		int maxRange = 100; // Setting max range for number of iteration
		
		// Logic to check whether the maxRange is 0  to handle the fibonacci series using switch case (trying)
		
		switch (maxRange) { 
		
		case 0: // For range 0, there is no Fib series to be generated
			
			System.out.println("The Fibonnaci series up to the value '"+maxRange+"' is : 0 \n\nTry a higher range to generate fibonacci series\n");
			break;

		default: // Default block for range > 0
			
			// Defining data types and variables 
			int currentNumber = 0; 
			int nextNumber = 1;
			int generateNextNumber;
			
			// Handling the default series for value up to 1 before entering iteration
			System.out.print("The Fibonnaci series up to the value '"+maxRange+"' is : "+currentNumber+" "+nextNumber+" ");
			
			for (int i=1; i<=maxRange;i++) {
				
				// calculating next number in the series by adding the previous two values
				generateNextNumber = currentNumber + nextNumber;
				
				// Validating value of the next number is higher than the range, true will trigger a break out of the loop
				if (generateNextNumber > maxRange) {
					break;
				}
				
				// Printing the next number using print to form a sequence
				System.out.print(+generateNextNumber+" ");
				
				// Reassigning values to generate the next number in the series
				currentNumber = nextNumber;
				nextNumber = generateNextNumber;
			}
			break;
		}
		
	}

}
