package Presentation;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class Menu {

    private final Scanner scanner;

    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {
        spacing();
        System.out.println("--- The Factory ---");
        spacing();
        System.out.println("1. Show Progress");
        System.out.println("2. Exit");
        spacing();
    }

    /**
     * Shows  message
     * @param message message
     */
    public void showMessage(String message) {
        System.out.print(message);
    }

    /**
     * Asks the user for a integer
     * @param message message displayed
     * @return the user's input
     */
    public int askForInteger(String message) {
        while (true) {
            try {
                System.out.print(message);
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("That's not a valid integer, try again!");
            } finally {
                scanner.nextLine();
            }
        }
    }

    /**
     * Shows tabulated message
     * @param message message to show
     */
    public void showTabulatedMessage(String message) {
        System.out.println("\t" + message);
    }

    /**
     * Displays a space in the console
     */
    public void spacing() {
        System.out.println();
    }

}
