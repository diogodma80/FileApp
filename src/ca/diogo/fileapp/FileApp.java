package ca.diogo.fileapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileApp {
	
	/**
	 * To run in the command line on Linux
	 * $javac ca.diogo.fileapp.FileApp.java
	 * java ca.diogo.fileApp listDirectory /home/[DIRECTORY_NAME]
	 * @$param args [listDirectory|createDirectory|deleteDirectory|deleteFile|copyFile][DIRECTORY_OR_FILE_FULL_PATH][NEW_FILE_FULL_PATH]
	 */

	public static void main(String[] args) {
		
		if(args.length == 0) {
			System.out.println("First parameter must be the operation");
		} else if (args.length == 1) {
			System.out.println("Second parameter must be declared");
		} else {
			String operationType = args[0];
			String secondParam = args[1];
			String thirdParam = null;
			if(args.length == 3) {
				thirdParam = args[2];
			}
			if(operationType.equalsIgnoreCase("createDirectory")) {
				createDirectory(secondParam);
			} else if (operationType.equalsIgnoreCase("deleteDirectory")) {
				deleteDirectory(secondParam);
			} else if (operationType.equalsIgnoreCase("deleteFile")) {
				deleteFile(secondParam);
			} else if (operationType.equalsIgnoreCase("listDirectory")) {
				listDirectory(secondParam);
			} else if (operationType.equalsIgnoreCase("copyFile")) {
				copyFile(secondParam, thirdParam);
			}
		}
	}

	//gets origin file and destiny file name
	private static void copyFile(String secondParam, String thirdParam) {
		System.out.println("Copying files");
		File fileOrigin = new File(secondParam);
		File fileDestiny = new File(thirdParam);
		
		InputStream input = null;
		OutputStream output = null;
		
		try {
			input = new FileInputStream(fileOrigin);
			output = new FileOutputStream(fileDestiny);
			byte[] buffer = new byte[1024];
			int length;
			while((length = input.read(buffer)) > 0) {
				output.write(buffer, 0, length);
			}
		} catch (Exception e) {
			System.out.println("Processing error:" + e.getMessage());
			return;
		} finally {
			try {
				input.close();
				output.close();
			} catch (Exception e) {
				System.out.println("Error closing files:" + e.getMessage());
				return;
			}
		}
		
		return;
	}

	//gets the directory full path
	private static void listDirectory(String secondParam) {
		System.out.println("List files");
		System.out.println("File or Directory Full Path");
		File fileObject = new File(secondParam);
		//tests if directory exists. If false, returns
		if(!fileObject.exists()) {
			System.out.println("Directory " + secondParam + " does not exist");
			return;
		}
		File[] files = fileObject.listFiles();
		//tests if files in the array exist. If false, returns
		if(files == null) {
			System.out.println("Failed to list files in the directory " + secondParam);
			return;
		}
		//for each file object sets it as "D"irectory or "F"ile
		for(File file:files) {
			String flagDirectory;
			if(file.isDirectory()) {
				flagDirectory = "D";
			} else {
				flagDirectory = "F";
			}
			System.out.println("[" +flagDirectory + "]" + " " + file);
		}
		System.out.println("Full list");
	}

	//gets the full name of the file to be deleted
	private static void deleteFile(String secondParam) {
		System.out.println("Deleting the file");
		File file = new File(secondParam);
		if(!file.exists()) {
			System.out.println("File " + secondParam + " does not exist");
			return;
		} else if (!file.isFile()) {
			System.out.println(secondParam + " is not a file");
			return;
		} 
		boolean isDeleted = file.delete();
		if(isDeleted) {
			System.out.println("File was deleted");
		} else {
			System.out.println("Failed to delete the file");
		}
	}

	//gets the directory path
	private static void deleteDirectory(String secondParam) {
		System.out.println("Deleting directory");
		File directory = new File(secondParam);
		if(!directory.exists()) {
			System.out.println("Directory " + secondParam + " does not exist");
			return;
		} else if (!directory.isDirectory()) {
			System.out.println(secondParam + " is not a directory");
		}
		boolean isDeleted = directory.delete();
		if(isDeleted) {
			System.out.println("Directory was deleted");
		} else {
			System.out.println("Failed to delete the directory");
		}
	}

	//gets the directory to be created
	private static void createDirectory(String secondParam) {
		System.out.println("Creating the new directory");
		File directory = new File(secondParam);
		boolean isDirCreated = directory.mkdir();
		if(isDirCreated) {
			System.out.println("Directory was created");
		} else {
			System.out.println("Failed to create the directory");
		}
		
	}

}
