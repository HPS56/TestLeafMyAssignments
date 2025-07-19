/*
 * Create a Java class named APIClient and create two methods with the same name passing different input arguments.
 * Psuedo Code:
 * 	1. Create a class to implement with two methods of same name with different parameters set (signature)
 * 	2. Create an instance from the main method for the class and call the two methods by using different signature
 */
package week4.day1;

public class DemonstrateMethodOverloadingHA {
	public void sendRequest(String endpoint) {
		// Method to receives an API end point from the main method
		System.out.println("From sendrequest method with one parameter:");
		System.out.println("Endpoint recieved is '" + endpoint + "'");
		System.out.println("===========================================");

	}

	public void sendRequest(String endpoint, String requestBody, boolean requestStatus) {
		// Method to receives an API end point, a request and confirm the status of the
		// request from the main method
		System.out.println("From sendrequest method with three parameter");
		System.out.println("Request '" + requestBody + "' has been sent to endpoint '" + endpoint + "'");
		System.out.println("Is request sucessfull ? : " + requestStatus);
		System.out.println("===========================================");

	}

	public static void main(String[] args) {
		// Generating instance of the class to implement overloading of two methods with
		// diff signature
		DemonstrateMethodOverloadingHA endpoint = new DemonstrateMethodOverloadingHA();

		endpoint.sendRequest("https://api.ipify.org/"); // Call to send request method with one parameter
		endpoint.sendRequest("https://api.ipify.org/", "ip : 49.37.217.252", true); // Call to send request method with
																					// three parameter

	}

}
