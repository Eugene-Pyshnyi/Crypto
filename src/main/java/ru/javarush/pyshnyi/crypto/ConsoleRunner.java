package ru.javarush.pyshnyi.crypto;

import ru.javarush.pyshnyi.crypto.result.Result;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Application application = new Application();
        args = getArgs(args);
        Result result = application.run(args);
        System.out.println(result);
    }

    public static final String[][][] QUESTIONS = new String[][][]{
            {
                    {"encode"},
                    {"Enter path of file"},
                    {"Enter path where to encrypt"},
                    {"Enter key int number QR Enter for key=1 :", "1"}
            },
            {
                    {"decode"},
                    {"Enter path of file"},
                    {"Enter path where to decrypt"},
                    {"Enter key int number QR Enter for key=1 :", "1"}
            },
            {
                    {"bruteforce"},
                    {"Enter path of file"},
                    {"Enter path where to encrypt"},
            },
            {
                    {"analyze"},
                    {"Enter path of file"},
                    {"Enter path where to encrypt"},
            },
    };
    public static final String MESSAGE_SELECT_MODE = """
            Please select mode:
            1. Encrypt
            2. Decrypt
            3. Brute Force
            4. Analyze
            """;
    public static final String INCORRECT_SELECTION = "Incorrect selection";
    private static String[] getArgs(String[] args) {
        if (args.length == 0) {
            Scanner scanner = new Scanner(System.in);
            int mode = getMode(scanner);

            mode--;
            args = new String[QUESTIONS[mode].length];
            args[0] =  QUESTIONS[mode][0][0];
            for (int i = 0; i < args.length; i++) {
                String quest = QUESTIONS[mode][i][0];
                System.out.println(quest);
                String answer = scanner.nextLine();
                args[i] = answer.isEmpty() ? QUESTIONS[mode][i][1] : answer;
            }
        }
        return args;
    }
    private static int getMode(Scanner scanner) {
        int mode;
        do {
            System.out.println(MESSAGE_SELECT_MODE);
            String input = scanner.nextLine();
            mode = switch (input) {
                case "1" -> 1;
                case "2" -> 2;
                case "3" -> 3;
                case "4" -> 4;
                default -> {
                    System.out.println(INCORRECT_SELECTION);
                    yield -1;
                }
            };
        } while (mode < 0);
        return mode;
    }
}
