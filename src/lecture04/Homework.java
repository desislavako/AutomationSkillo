package lecture04;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Homework {

    private static Object scanner;
    private static Object args;

    public static void main(String[] args) {
        divisibleBy5();

    }


    private static void dayOfTheWeek() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number (1-7): ");
        int dayNumber = scanner.nextInt();

        scanner.close();

        String dayOfWeek;

        switch (dayNumber) {
            case 1:
                dayOfWeek = "Sunday";
                System.out.print("Sunday");
                break;
            case 2:
                dayOfWeek = "Monday";
                System.out.print("Monday");
                break;
            case 3:
                dayOfWeek = "Tuesday";
                System.out.print("Tuesday");
                break;
            case 4:
                dayOfWeek = "Wednesday";
                System.out.print("Wednesday");
                break;
            case 5:
                dayOfWeek = "Thursday";
                System.out.print("Thursday");
                break;
            case 6:
                dayOfWeek = "Friday";
                System.out.print("Friday");
                break;
            case 7:
                dayOfWeek = "Saturday";
                System.out.print("Saturday");
                break;
            default:
                dayOfWeek = "Invalid input";
                break;
        }
        String suffix;

        switch (dayNumber) {
            case 1:
            case 21:
            case 31:
                suffix = "st";
                break;
            case 2:
            case 22:
                suffix = "nd";
                break;
            case 3:
            case 23:
                suffix = "rd";
                break;
            default:
                suffix = "th";
                break;
        }
        if (dayNumber >= 1 && dayNumber <= 7) {
            System.out.println("The " + dayNumber + suffix + " day of the week is " + dayOfWeek);
        } else {
            System.out.println("Invalid input. Please enter a number between 1 and 7.");
        }

    }

    private static void EligibleAge() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        scanner.close();

        if (age >= 16) {
            System.out.println("You are eligible to work.");
        } else {
            System.out.println("You are not eligible to work.");

        }
    }

    private static void calculateRevenue() {
        Scanner scanner = new Scanner(System.in);

        double unitPrice;
        double quantity;
        double revenue;
        double discount;
        double discountRate;

        System.out.print("Enter value for unit price:");
        unitPrice = scanner.nextDouble();

        System.out.print("Enter value for quantity:");
        quantity = scanner.nextDouble();

        revenue = unitPrice * quantity;

        if (quantity < 100) {
            discountRate = 0;
        } else if (quantity >= 100 && quantity <= 120) {
            discountRate = 0.15;
        } else {
            discountRate = 0.20;
        }
        discountRate = revenue * quantity;


    }

    private static void theLargestNumber() {
        int[] numbers = {11, 44, 68, 27, 99, 53, 34, 77, 86, 9};

        int largest = numbers[0]; // Initialize with the first element of the array

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > largest) {
                largest = numbers[i];
            }
        }
    }

    private static void divisibleBy5() {
        List<Integer> list1 = new ArrayList<>();
        list1.add(12);
        list1.add(15);
        list1.add(32);
        list1.add(42);
        list1.add(55);
        list1.add(75);
        list1.add(122);
        list1.add(132);
        list1.add(150);
        list1.add(180);
        list1.add(200);
        for (int number : list1) {
            if (number > 150) {
                break; // Stop the loop if the number is greater than 150
            }
            if (number % 5 == 0) {
                System.out.println(number);
            }
        }
    }
}

