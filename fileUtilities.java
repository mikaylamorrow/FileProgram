package fileprog;

import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.util.Collections;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;

public class fileUtilities {

    public static void createFile(String fileName, int fileSize, int fileRange) {
        try {
            File myFile = new File(fileName + ".txt");
            if (myFile.createNewFile()) {
                populateFile(fileName, fileSize, fileRange);
            } else {
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            System.out.println("An error occurred " + e.getMessage());
        }
    }

    public static void populateFile(String fileName, int fileSize, int fileRange) {
        try {
            FileWriter myWriter = new FileWriter(fileName + ".txt");
            Random rand = new Random();

            for (int i = 0; i < fileSize; i++) {
                myWriter.write(rand.nextInt(fileRange) + "\n");
            }
            myWriter.close();
            System.out.println("You wrote on the file");
        } catch (IOException e) {
            System.out.println("An error occurred " + e.getMessage());
        }
    }

    public static float calculateAverage(String fileName) {
        float avg = 0;
        try {
            File myFile = new File(fileName + ".txt");
            Scanner scan = new Scanner(myFile);
            float sum = 0;
            int counter = 0;
            
            while (scan.hasNextLine()) {
                String data = scan.nextLine();
                sum = sum + Integer.parseInt(data);
                counter++;
            }
            scan.close();
            avg = sum / counter;

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred " + e.getMessage());
        }
        return avg;
    }

    public static double calculateMedian(String fileName) {
        ArrayList<Integer> numbers = new ArrayList<>();

        try {
            File newFile = new File(fileName + ".txt");
            Scanner myScan = new Scanner(newFile);

            while (myScan.hasNextLine()) {
                String data = myScan.nextLine();
                numbers.add(Integer.parseInt(data));
            }

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred " + e.getMessage());
        }

        Collections.sort(numbers);

        if (numbers.size() % 2 == 0) {
            return (numbers.get(numbers.size() / 2 - 1) + numbers.get(numbers.size() / 2)) / 2.0;
        } else {
            return numbers.get(numbers.size() / 2);
        }
    }

    public static void minMax(String fileName) {
        try {
            File myFile = new File(fileName + ".txt");
            Scanner scan = new Scanner(myFile);
            ArrayList<Integer> numbers = new ArrayList<>();
            while (scan.hasNextLine()) {
                String data = scan.nextLine();
                numbers.add(Integer.parseInt(data));
            }
            scan.close();
            Collections.sort(numbers);

            System.out.println("Min number is: " + numbers.get(0) + "\n" + "Max number is: " + numbers.get(numbers.size() - 1));
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred " + e.getMessage());
        }
    }

    public static void sortFile(String fileName) {
        try {
            File myFile = new File(fileName + ".txt");
            Scanner input = new Scanner(myFile);
            ArrayList<Integer> numbers = new ArrayList<>();
            while (input.hasNextLine()) {
                String data = input.nextLine();
                numbers.add(Integer.parseInt(data));
            }
            input.close();
            Collections.sort(numbers);
            writeFile(fileName, numbers);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred " + e.getMessage());
        }

    }

    public static void writeFile(String fileName, ArrayList<Integer> numbers) {
        try {
            FileWriter myWriter = new FileWriter(fileName + ".txt");
            for (int i = 0; i < numbers.size(); i++) {
                myWriter.write(numbers.get(i) + "\n");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred " + e.getMessage());
        }
    }

    public static boolean isPrime(int num) {
        boolean flag = false;
        for (int i = 2; i <= num / 2; ++i) {
            if (num % i == 0) {
                flag = true;
                break;
            }
        }
        return !flag;
    }

    public static void findPrime(String fileName) {
        try {
            File myFile = new File(fileName + ".txt");
            Scanner scan = new Scanner(myFile);

            while (scan.hasNextLine()) {
                String data = scan.nextLine();

                if (isPrime(Integer.parseInt(data))) {
                    System.out.println(data);
                }
            }
            scan.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred " + e.getMessage());
        }
    }
}
