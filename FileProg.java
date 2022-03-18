package fileprog;

import java.util.Scanner;

public class FileProg {

    public static void main(String[] args) {
        boolean loop = true;
        while (loop) {
            System.out.println("Choose one of the following: ");
            System.out.println("\t1 - Create a File");
            System.out.println("\t2 - Sort File");
            System.out.println("\t3 - Calculate Average");
            System.out.println("\t4 - Calculate Median");
            System.out.println("\t5 - Find Prime");
            System.out.println("\t6 - Print Min & Max");
            System.out.println("\t7 - Exit");

            Scanner scan = new Scanner(System.in);
            int num = scan.nextInt();

            switch (num) {
                case 1:
                    System.out.println("Enter the file name: ");
                    String fileName = scan.next();
                    
                    System.out.println("Enter the file size: ");
                    int fileSize = scan.nextInt();
                    
                    System.out.println("Enter the file range: ");
                    int fileRange = scan.nextInt();
                    
                    fileUtilities.createFile(fileName, fileSize, fileRange);
                    break;
                case 2:
                    System.out.println("Enter the file name: ");
                    fileName = scan.next();  
                    
                    fileUtilities.sortFile(fileName);
                    break;
                case 3:
                    System.out.println("Enter the file name: ");
                    fileName = scan.next();
                    System.out.println("Average is: " + fileUtilities.calculateAverage(fileName));
                    break;
                case 4:
                    System.out.println("Enter the file name: ");
                    fileName = scan.next();
                    System.out.println("Median is: " + fileUtilities.calculateMedian(fileName));
                    break;
                case 5:                    
                    System.out.println("Enter the file name: ");
                    fileName = scan.next();
                    fileUtilities.findPrime(fileName);
                    break;
                case 6:
                    System.out.println("Enter the file name: ");
                    fileName = scan.next();
                    fileUtilities.minMax(fileName);
                    break;
                case 7:
                    loop = false;
                    System.out.println("You ended the program.");
                    break;
                default:
                    System.out.println("Invalid choice.");

            }
        }
    } 
    
}
