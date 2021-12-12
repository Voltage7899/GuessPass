package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Processing processing = new Processing();
        boolean isSuccessful = false;
        boolean restart = false;

        do {

            System.out.println("Добро пожаловать,введите пароль который нужно отгадать");
            do {
                isSuccessful = processing.setWord(scanner.nextLine());
            } while (!isSuccessful);
            isSuccessful = false;
            System.out.println("\nВведите описание");
            processing.setDescription(scanner.nextLine());
            System.out.println("\nХотите выйти напишите -");
            System.out.println("Хотите угадать пароль целиком,введите +");
            System.out.println("\nТеперь вы можете отгадывать слово");

            do {
                String line = scanner.nextLine();
                if (line.equals("-")) {
                    System.out.println("Удачи!");
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
