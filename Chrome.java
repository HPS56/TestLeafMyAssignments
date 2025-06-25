package week1.day1;

public class Chrome {

	public static void main(String[] args) {
		// Program to demonstrate understanding of the different data types and variables
		
		//1. version of type float with a value of 91.0f
		//2. developer of type String with a value of "Google"
		//3. isBeta of type boolean with a value of false
		//4. releaseYear of type int with a value of 2008
		//5. shortcutKey of type char with a value of 'C'
		
		// Defining variables, data types and initialising with values
		
		float browserVersion = 91.0f;
		String browserDeveloper = "Google Inc";
		boolean isBetaVersion = false;
		int browserReleaseYear = 2008;
		char browserShortcutKey = 'C';
		
		// Formatting and printing values
		
		System.out.println("Hi User!!, below are details about your chrome browser:\n");
		
		System.out.println("Your browser is developed by \""+browserDeveloper+"\", its current version is \""+browserVersion+"\" released on \""+browserReleaseYear+"\" and shortcut key to launch browser is \""+browserShortcutKey+"\"\n");
		
		System.out.println("Is this version a beta relase?: "+isBetaVersion);

	}

}
