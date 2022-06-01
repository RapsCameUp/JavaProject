package org.virtualkey;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FileDirectory {

	public static final String file_directory = "src/filedirectory/";

	private ArrayList<File> files_array = new ArrayList<File>();

	Path path = FileSystems.getDefault().getPath(file_directory).toAbsolutePath();

	File directory_files = path.toFile();

	// function to get all files in current directory
	public void GetAllFiles() {

		//get all the files and add them into an array for files
		File[] files = directory_files.listFiles();

		files_array.clear();
		for (int i = 0; i < files.length; i++) {
			if (files[i].isFile()) {
				files_array.add(files[i]);
			}
		}

		// sort
		Collections.sort(files_array);

		files_array.forEach(file -> System.out.println(file.getName()));
	}

	// function to add a new file name entered by the user
	public void AddANewFile() {
		System.out.println("\n");
		System.out.println("Please Enter New Filename To Add: ");

		Scanner in = new Scanner(System.in);
		String file_name = in.nextLine().trim().toLowerCase();

		System.out.println("Please wait. File " + file_name.trim() + "  is being added.");

		try {
			Path path = FileSystems.getDefault().getPath(file_directory + file_name).toAbsolutePath();
			File new_file = new File(file_directory + file_name);
			
			// add the new file in directory if it does not exist alread

			if (new_file.createNewFile()) {
				System.out.println("\n");
				System.out.println("File Has Successfully Been Added.");

			} else {
				System.out.println("\n");
				System.out.println("Warning. File Already Exists!");
			}
		} catch (IOException e) {
			//show error message
			System.out.println("\n");
			System.out.println("Warning. Something went wrong!");
			System.out.println(e);
		}
	}

	// function to delete a file name entered by the user
	public void DeleteAFile() {
		System.out.println("\n");
		System.out.println("Please Enter Filename To Delete: ");

		Scanner in = new Scanner(System.in);
		String file_name = in.nextLine().trim().toLowerCase();

		System.out.println("Please wait. File " + file_name + "  is being deleted.");

		Path path = FileSystems.getDefault().getPath(file_directory + file_name).toAbsolutePath();
		File file = path.toFile();

		// if the file is deleted successfully, show success message
		if (file.delete()) {
			System.out.println("Success. File Deleted Successfully!");
		} else {
			System.out.println("Error. File Was Not Found!");
		}
	}

	// function to search for a file name entered by the user
	public void SearchForAFile() {

		System.out.println("\n");
		System.out.println("Please Enter Filename To Search: ");

		Scanner in = new Scanner(System.in);
		String file_name = in.nextLine().trim().toLowerCase();

		// get the list and add into the array then search the array for the serached file
		File[] files = directory_files.listFiles();

		files_array.clear();
		for (int i = 0; i < files.length; i++) {
			if (files[i].isFile()) {
				files_array.add(files[i]);
			}
		}

		// if the file is found, change the file search status
		int file_search_status = 0;
		for (int i = 0; i < files_array.size(); i++) {
			System.out.println(files_array.get(i));
			if (files_array.get(i).getName().equals(file_name)) {
				file_search_status = 1;
			}
		}

		// display message
		if (file_search_status == 1) {
			System.out.println("Success. File Found Successfully!");
		} else {
			System.out.println("Warning. The Entered File Was Not Found!");
		}
	}

}
