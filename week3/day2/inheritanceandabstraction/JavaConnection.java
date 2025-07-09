package week3.day2.inheritanceandabstraction;

// Concrete class implementing specific scope for the methods
public class JavaConnection extends MySqlConnection {
	@Override
	public void connect() {
		// Connect to database
		System.out.println("From JavaConnection : Connection to database is successful");

	}

	@Override
	public void disconnect() {
		// disconnect database
		System.out.println("From JavaConnection : Database disconnected successfully");

	}

	@Override
	public void executeUpdate() {
		// Connect to database
		System.out.println("From JavaConnection : Database has been update sucessfully");

	}

	@Override
	public void executeQuery() {
		// Connect to database
		System.out.println("From JavaConnection : Database query has been executed sucessfully");

	}

}
