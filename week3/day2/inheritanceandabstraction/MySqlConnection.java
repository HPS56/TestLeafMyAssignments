package week3.day2.inheritanceandabstraction;

// Abstract class that implements DatabaseConnection class
public abstract class MySqlConnection implements DatabaseConnection{

	// Defining specific methods for classes inheriting from this class
	public abstract void executeQuery();

}
