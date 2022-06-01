package org.virtualkey;

import org.virtualkey.FileDirectory;
import org.virtualkey.FilesMenuDisplay;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Display {
	
	public void WelcomeDeveloperDetails() {
		System.out.println("\n");
		System.out.println("Virtual Key Application");
		System.out.println("\n");
		System.out.println("Hi there,my name is Rabelani.");
	}

	//function to display the welcome screen menu options
	public void StartingScreen() {
		System.out.println("\n");
		System.out.println("Below is the things you can do!");
		System.out.println("\n");
		System.out.println("1. Display All Current Files");
		System.out.println("2. Display File Options Menu");
		System.out.println("3. Quit");

		this.UserInput();
	}

	// function for getting user input and navigating to the selected option
	private void UserInput() {
		Scanner in = new Scanner(System.in);

		int selected_option = in.nextInt();

		if (selected_option == 1) {
			this.ShowAllCurrentFiles();
			System.out.println("\n");
			this.StartingScreen();
		} else if (selected_option == 2) {
			System.out.println("\n");
			this.ShowFileOptionsMenu();
		} else if (selected_option == 3) {
			System.out.println("\n");
			System.out.println("Goodbye!");
			System.out.println("\n");
			System.exit(0);
		} else {
			System.out.println("\n");
			System.out.println("Invalid Input. Please Try Again.");
			System.out.println("\n");
			this.StartingScreen();
		}
	}

	// function for displaying all the current files in the directory
	private void ShowAllCurrentFiles() {
		System.out.println("\n");
		System.out.println("A List Of All Files In The Directory.");
		System.out.println("\n");

		FileDirectory files = new FileDirectory();
		files.GetAllFiles(); // get all the files from directory

	}

	// function for showing the file options menu (adding, deleting, and searching a file)
	private void ShowFileOptionsMenu() {
		FilesMenuDisplay files_menu = new FilesMenuDisplay();
		files_menu.ShowFilesActionMenu();

	}
}
