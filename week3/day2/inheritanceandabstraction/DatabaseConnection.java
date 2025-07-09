package week3.day2.inheritanceandabstraction;

// Interface to give blueprint for the methods needs to be implemented by classes
public interface DatabaseConnection {

	public void connect(); // Method to connect to database
	
	public void disconnect(); // Method to disconnect to database
	
	public void executeUpdate(); // Method to update to database
	
}
