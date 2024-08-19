// Name: Haisam Awais
// Date: 19/06/2024
// Description: This is code for a game of finding the airport where a user has to fly a plane to the airport. The user enters what direction the airport is flying in and how far the plane is travelling. The goal of the user is to get within 5 miles of the aiport in the least amount of flights. The user can choose the regular mode to play the game, which is played with graphics. Or the user can choose hard mode which is played without graphics.

import java.util.Scanner;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Display options to the user
        System.out.println("Choose an option to play the game:");
        System.out.println("1. Play with Graphics");
        System.out.println("2. Play with No Graphics (more challenging)");
        int choice = scanner.nextInt();

        // Create the airport and plane objects
        Airplane airport = new Airplane(Math.random() * 1000, Math.random() * 1000);
        Airplane plane = new Airplane(Math.random() * 1000, Math.random() * 1000);

        if (choice == 1) {
            // Set up the JFrame for graphical mode
            JFrame frame = new JFrame("Find the Airport");
            Airplane2D panel = new Airplane2D(airport, plane);
            frame.add(panel);
            frame.setSize(1000, 1000);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

            int flights = 0;
            double distanceBetween;

            // Game loop for graphical mode
            do {
                System.out.printf("You are %.2f miles from the airport%n", plane.distanceBetween(airport));
                System.out.print("Direction (in degrees): ");
                double angle = scanner.nextDouble();
                System.out.print("Distance (in miles): ");
                double distance = scanner.nextDouble();

                panel.updatePlane(angle, distance);
                flights++;
                distanceBetween = plane.distanceBetween(airport);
            } while (distanceBetween > 5);

            System.out.println("You are within 3 miles of the airport.");
            System.out.println("You see the airport and land.");
            System.out.printf("You took %d flights to find the airport.%n", flights);
        } else if (choice == 2) {
            int flights = 0;
            double distanceBetween;

            // Game loop for text-only mode
            do {
                System.out.printf("You are %.2f miles from the airport%n", plane.distanceBetween(airport));
                System.out.print("Direction (in degrees): ");
                double angle = scanner.nextDouble();
                System.out.print("Distance (in miles): ");
                double distance = scanner.nextDouble();

                plane.fly(angle, distance);
                flights++;
                distanceBetween = plane.distanceBetween(airport);
            } while (distanceBetween > 5);

            System.out.println("You are within 3 miles of the airport.");
            System.out.println("You see the airport and land.");
            System.out.printf("You took %d flights to find the airport.%n", flights);
        } else {
            System.out.println("Invalid choice. Please restart the game and choose a valid option.");
        }

        scanner.close();
    }
}
