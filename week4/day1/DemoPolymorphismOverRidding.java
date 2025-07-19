/*
 * A class to override the method from super class DemonstratingPolymorphism from child class using inheritance
 */

package week4.day1;

public class DemoPolymorphismOverRidding extends DemonstratingPolymorphism{
	
	// Overriding reportStep with 3 parameters from DemonstratingPolymorphism class 
	public void reportStep(String message, String Status,boolean snap) {
			System.out.println("This is from overridded method :" + message +" : " +Status + " Snap taken?: "+snap);
	}

	public static void main(String[] args) {
		// Creating an object for DemoPolymorphismOverRidding
		
		DemoPolymorphismOverRidding demoPolymorphismOverriding = new DemoPolymorphismOverRidding();
		
		// Call to reportStep overridden method with three parameters		
		demoPolymorphismOverriding.reportStep("Step 2", "In-Progress", true);


	}

}
