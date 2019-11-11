/*
 * Ervin Canigur - 1617451
 * COSC 4353 - Assignment 6
 */

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // User input
        try {
            System.out.println("Enter 1 to enter sides of the triangle\n"
                    + "Enter 2 to enter the points of the triangle");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter in the sides of the triangle");
                    try {
                        float side1 = scanner.nextFloat();
                        float side2 = scanner.nextFloat();
                        float side3 = scanner.nextFloat();

                        // Generating triangle
                        Triangle triangle = new Triangle(side1, side2, side3);
                        if (triangle.isValid())
                            System.out.println(triangle.toString());
                        else
                            System.out.println("Invalid triangle.");
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input, please try again with valid input.");
                    }
                    break;
                case 2:
                    System.out.println("Enter in the points of the triangle e.g. 1,1");
                    String input = scanner.nextLine();
                    String[] filtered = input.split(" ");
                    ArrayList<Point> points = new ArrayList<>();

                    for (String str : filtered) {
                        float x = Float.parseFloat(str.substring(0, str.indexOf(",")));
                        float y = Float.parseFloat(str.substring(str.indexOf(",") + 1));
                        points.add(new Point(x, y));
                    }

                    // Generating triangle
                    if (points.size() == 3) {
                        Triangle triangle = new Triangle(points.get(0), points.get(1), points.get(2));
                        if (triangle.isValid())
                            System.out.println(triangle.toString());
                        else
                            System.out.println("Invalid triangle.");
                    } else {
                        System.out.println("Requires 3 points.");
                    }
                    break;
                default:
                    System.out.println("Invalid input, please try again with valid input.");
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input, please try again with valid input.");
        }
    }
}
