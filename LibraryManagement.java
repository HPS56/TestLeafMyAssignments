/*  Create another Class LibraryManagement:
	Create an object for the Library class in the main method of LibraryManagement.
	Call both methods of the Library class from LibraryManagement and execute.
*/

package week1.day2;

public class LibraryManagement {

	public static void main(String[] args) {
		// Initiating new book object to passing book title to add and issue
		
		Library NewLibrary = new Library();
		
		// Invoking add method with a book title
		NewLibrary.addBook("Head First Design Patterns");
		
		// Invoking issue method
		NewLibrary.issueBook();	

	}

}