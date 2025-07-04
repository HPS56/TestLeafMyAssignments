package week1.day2;

public class SmallLibraryManagement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SmallLibraryManagement Library = new SmallLibraryManagement();
		
		Library.addBook(1, "Head First : Java", "Kathry Sierra", true);
				
		Library.displayDetails();
		
		Library.borrowBook();
		
		Library.borrowBook();
		
		Library.returnBook();
		
		Library.displayDetails();
		
		Library.returnBook();
		
		Library.borrowBook();
		
		Library.displayDetails();
		
		
	}
	
	int bookId;
	String bookTitle;
	String bookAuthor;
	boolean bookIsAvailable;

	public void addBook(int id, String title, String author, boolean available) {
		// TODO Auto-generated method stub
		
		this.bookId = id;
		this.bookTitle = title;
		this.bookAuthor = author;
		this.bookIsAvailable = available;

	}
	
	public void borrowBook() {
		// TODO Auto-generated method stub
		
		if (this.bookIsAvailable==true) {
			System.out.println("\nBook : "+this.bookTitle+" issued successfully");
			this.bookIsAvailable = false;
		}
		else {
			System.out.println("\nBook : "+this.bookTitle+" is currently unavailable to issue");
		}

	}
	
	public void returnBook() {
		// TODO Auto-generated method stub
		if (this.bookIsAvailable==false) {
			System.out.println("\nBook : "+this.bookTitle+" returned successfully");
			this.bookIsAvailable = true;
		}
		else {
			System.out.println("\nBook : "+this.bookTitle+" unable to return, as its not issued");
		}
	}
	
	public void displayDetails() {
		// TODO Auto-generated method stub
			System.out.println("==========================================================");
			System.out.println("Book details for BookID "+this.bookId+" :\n");
			System.out.println("Title : "+this.bookTitle);
			System.out.println("Author : "+this.bookAuthor);
			System.out.println("\nBook availble to Borrow: "+this.bookIsAvailable);
			System.out.println("==========================================================");
						

	}

}
