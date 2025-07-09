package week3.day2.inheritanceandabstraction;

public class TestClass {

	public static void main(String[] args) {
		// Creating object of implementation classes
		ConcreteClass concreteClass = new ConcreteClass();
		JavaConnection javaConnection = new JavaConnection();

		// Invoking methods using Concrete Class
		concreteClass.connect();
		concreteClass.disconnect();
		concreteClass.executeUpdate();

		// Invoking methods using JavaConnection Class
		javaConnection.connect();
		javaConnection.disconnect();
		javaConnection.executeUpdate();
		javaConnection.executeQuery();

	}

}
