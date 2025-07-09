package week3.day2.inheritanceandabstraction;

public class ConcreteClass implements DatabaseConnection {
	@Override
	public void connect() {
		// Connect to database
		System.out.println("From Concrete : Connection to database is successful");

	}

	@Override
	public void disconnect() {
		// disconnect database
		System.out.println("From Concrete : Database disconnected successfully");

	}

	@Override
	public void executeUpdate() {
		// Connect to database
		System.out.println("From Concrete : Database has been update sucessfully");

	}

}
