// Create a class named Library with methods to manage book details. Execute these methods using objects from the main method.

package week1.day2;

public class Library {
	
	// Method to add a book to the catalogue
	
	public String addBook(String bookTitle) {
		
		// Using the book name from main class to print and return value
		
		System.out.println("\""+bookTitle+ "\" Book added successfully\n");
		
		return bookTitle;

	}
	
	//Method to issue book to the user
	
	public void issueBook() {
		
		// Confirmation to user the book has been issued
		
		System.out.println("Book issued successfully");

	}
	
	public static void main(String[] args) {
		// Initiating new book object to passing book title to add and issue
		
		Library NewLibrary = new Library();
				
		// Invoking add method with a book title
		
		NewLibrary.addBook("Head First Java");
		
		// Invoking issue method
		
		NewLibrary.issueBook();
		

	}

}
