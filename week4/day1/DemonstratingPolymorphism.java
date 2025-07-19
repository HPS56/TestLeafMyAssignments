/*
 * A class to create two methods of the same signature and using different parameters to demonstrate Method Overloading
 */

package week4.day1;

public class DemonstratingPolymorphism {
	
	// reportStep with two parameters
	public void reportStep(String message, String Status) {
		System.out.println(message +" : " +Status);
		
	}
	
	// reportStep with three parameters
	public void reportStep(String message, String Status,boolean snap) {
		System.out.println(message +" : " +Status + " Snap taken?: "+snap);
		
	}

	public static void main(String[] args) {
		// Creating an object for DemonstratingPolymorphism
		
		DemonstratingPolymorphism demoPolymorphism = new DemonstratingPolymorphism();
		
		// Call to reportStep with two parameters
		demoPolymorphism.reportStep("Step 1", "Complete");

		// Call to reportStep with three parameters		
		demoPolymorphism.reportStep("Step 2", "In-Progress", true);

	}

}
