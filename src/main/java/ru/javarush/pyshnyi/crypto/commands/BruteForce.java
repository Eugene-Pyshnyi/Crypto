package ru.javarush.pyshnyi.crypto.commands;

import ru.javarush.pyshnyi.crypto.alphabet.Alphabet;
import ru.javarush.pyshnyi.crypto.caesar.CaesarDecryption;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class BruteForce extends CaesarDecryption {

    public static int calculateScore(String text, String representativeText) {
        // Реализуйте метрику для оценки схожести текстов
        // Например, можно использовать сравнение слов и их длин
        // и т.д. в зависимости от ваших предпочтений
        return 0; // Заглушка, замените на реальное вычисление
    }

    public static void bruteForce() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите зашифрованный текст:");
        String ciphertext = scanner.nextLine();
        String alphabet = Alphabet.getSYMBOLS();

        System.out.println("Введите имя файла с репрезентативным текстом (пример текста для сравнения):");
        String representativeFileName = scanner.nextLine();

        try {
            File representativeFile = new File(representativeFileName);
            BufferedReader representativeReader = new BufferedReader(new FileReader(representativeFile));
            StringBuilder representativeText = new StringBuilder();
            String line;

            while ((line = representativeReader.readLine()) != null) {
                representativeText.append(line);
            }
            representativeReader.close();

            int bestScore = Integer.MAX_VALUE;
            int bestKey = 0;
            String bestDecryption = "";

            for (int key = 1; key <= alphabet.length(); key++) {
                String decryption = decrypt(ciphertext, key, alphabet);
                int score = calculateScore(decryption, representativeText.toString());

                if (score < bestScore) {
                    bestScore = score;
                    bestKey = key;
                    bestDecryption = decryption;
                }
            }

            System.out.println("Наилучший ключ: " + bestKey);
            System.out.println("Наилучший расшифрованный текст:\n" + bestDecryption);
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла с репрезентативным текстом");
        }
    }
}