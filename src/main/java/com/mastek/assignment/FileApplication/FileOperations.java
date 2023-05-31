package com.mastek.assignment.FileApplication;

import java.io.File;
import java.util.Scanner;

public class FileOperations {
	

    public void handleDirectoryOptions(Scanner scanner) {
        int option;

        do {
            displayDirectoryOptions();
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    addFile(scanner);
                    break;
                case 2:
                    deleteFile(scanner);
                    break;
                case 3:
                    searchFile(scanner);
                    break;
                case 4:
                    System.out.println("Returning to the main context...");
                    break;
                default:
                    System.out.println("Invalid option! Please select a valid option.");
                    break;
            }
        } while (option != 4);
    }
    
    private static void displayDirectoryOptions() {
        System.out.println("Directory options:");
        System.out.println("1. Add a file to the existing directory list");
        System.out.println("2. Delete a specific file from the existing directory list");
        System.out.println("3. Search a specific file from the main directory");
        System.out.println("4. Navigate back to the main context");
    }
    
    private static void addFile(Scanner scanner) {
        System.out.println("Enter the file name to add:");
        String fileName = scanner.next();

        File rootDirectory = new File("C:\\Users\\Manisha14662\\Documents\\New folder");
        File newFile = new File(rootDirectory, fileName);

        try {
            boolean created = newFile.createNewFile();
            if (created) {
                System.out.println("File added successfully!");
            } else {
                System.out.println("File already exists.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred while adding the file: " + e.getMessage());
        }
    }
    private static void deleteFile(Scanner scanner) {
        System.out.println("Enter the file name to delete:");
        String fileName = scanner.next();

        File rootDirectory = new File("C:\\Users\\Manisha14662\\Documents\\New folder");
        File fileToDelete = new File(rootDirectory, fileName);

        if (fileToDelete.exists()) {
            boolean deleted = fileToDelete.delete();
            if (deleted) {
                System.out.println("File deleted successfully!");
            } else {
                System.out.println("An error occurred while deleting the file.");
            }
        } else {
            System.out.println("File not found!");
        }
    }
    private static void searchFile(Scanner scanner) {
        System.out.println("Enter the file name to search:");
        String fileName = scanner.next();

        File rootDirectory = new File("C:\\Users\\Manisha14662\\Documents\\New folder");
        File[] files = rootDirectory.listFiles();

        boolean fileFound = false;
        if (files != null && files.length > 0) {
            for (File file : files) {
                if (file.getName().equals(fileName)) {
                    System.out.println("File found: " + file.getAbsolutePath());
                    fileFound = true;
                    break;
                }
            }
        }

        if (!fileFound) {
            System.out.println("File not found!");
        }
    }

}
