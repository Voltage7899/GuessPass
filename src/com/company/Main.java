package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Processing processing = new Processing();
        boolean isSuccessful = false;
        boolean restart = false;

        do {

            System.out.println("Welcome to the game! Please enter the word you want to guess");
            do {
                isSuccessful = processing.setWord(scanner.nextLine());
            } while (!isSuccessful);
            isSuccessful = false;
            System.out.println("\nNow enter the description for the word");
            processing.setDescription(scanner.nextLine());
            System.out.println("\nIf you want to cancel the game, please type '-' in console");
            System.out.println("If you want to guess the entire word at once, please type '+' in console");
            System.out.println("\nNow you can proceed to guessing the word");

            do {
                String line = scanner.nextLine();
                if (line.equals("-")) {
                    System.out.println("Good luck!");
                    return;
                }
                else if (line.equals("+"))
                    isSuccessful = processing.guessWord(scanner.nextLine());
                else
                    isSuccessful = processing.guess(line);
            } while (!isSuccessful);
            restart = processing.restart();
        } while (restart);
    }
}
