package org.virtualkey;

import org.virtualkey.Display;
import java.util.Scanner;

public class FilesMenuDisplay {

	FileDirectory files = new FileDirectory();

	// function for showing the file options menu
	public void ShowFilesActionMenu() {
		System.out.println("Below Are The File Actions!");
		System.out.println("\n");
		System.out.println("1. Add A New File");
		System.out.println("2. Delete A File");
		System.out.println("3. Search For A File");
		System.out.println("4. Go Back To Main Menu");

		this.UserInput();
	}

	// get user input and navigate to the selected option
	private void UserInput() {
		Scanner in = new Scanner(System.in);

		int selected_option = in.nextInt();

		if (selected_option == 1) {

			files.AddANewFile(); // add new file function
			System.out.println("\n");
			this.ShowFilesActionMenu();
			
		} else if (selected_option == 2) {
			
			files.DeleteAFile(); // delete a file function
			System.out.println("\n");
			this.ShowFilesActionMenu();
			
		} else if (selected_option == 3) {
			
			files.SearchForAFile(); // search for a file function
			System.out.println("\n");
			this.ShowFilesActionMenu();
			
		} else if (selected_option == 4) {

			Display display = new Display();
			display.StartingScreen(); // go back to main menu
			
		} else {
			System.out.println("\n");
			System.out.println("Invalid Input. Please Try Again.");
			System.out.println("\n");
		}
	}
}
