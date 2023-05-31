package com.mastek.assignment.FileApplication;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class FileApp {

    public static void main(String[] args) {
        displayWelcomeScreen();

        FileOperations fileOperations=new FileOperations();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            displayUserOptions();
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    displayFileNames();
                    break;
                case 2:
                	fileOperations.handleDirectoryOptions(scanner);
                    break;
                case 3:
                    System.out.println("Closing the application...");
                    break;
                default:
                    System.out.println("Invalid option! Please select a valid option.");
                    break;
            }
        } while (option != 3);

        scanner.close();
    }
    
    private static void displayWelcomeScreen() {
        System.out.println("Welcome to File Directory App!");
        System.out.println("Developed by Manisha Pisal");
        System.out.println();
    }
    
    private static void displayUserOptions() {
        System.out.println("Please select an option:");
        System.out.println("1. Display current file names in ascending order");
        System.out.println("2. Directory options");
        System.out.println("3. Close the application");
    }
    
    private static void displayFileNames() {
        File rootDirectory = new File("C:\\Users\\Manisha14662\\Documents\\New folder");
        File[] files = rootDirectory.listFiles();
        Arrays.sort(files);

        if (files != null && files.length > 0) {
            System.out.println("Current file names in ascending order:");
            for (File file : files) {
                System.out.println(file.getName());
            }
        } else {
            System.out.println("No files found in the directory.");
        }
    }

}
