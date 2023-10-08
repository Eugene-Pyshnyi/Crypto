package ru.javarush.pyshnyi.crypto.commands;

import ru.javarush.pyshnyi.crypto.alphabet.Alphabet;
import ru.javarush.pyshnyi.crypto.caesar.CaesarDecryption;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class BruteForce extends CaesarDecryption {

    public static int calculateScore(String text, String representativeText) {
        String[] textWords = text.split("\\s+");
        String[] representativeWords = representativeText.split("\\s+");
        int matchingWords = 0;
        for (String word : textWords) {
            if (Arrays.asList(representativeWords).contains(word)) {
                matchingWords++;
            }
        }
        return matchingWords;
    }

    public static void bruteForceDecryption(String ciphertext,
                                            String representativeText, String alphabet, String outputFileName) {
        int bestScore = 0;
        String bestDecryption = "";

        for (int key = 1; key < alphabet.length(); key++) {
            String decryptedText = decrypt(ciphertext, key, alphabet);
            int score = calculateScore(decryptedText, representativeText);

            if (score > bestScore) {
                bestScore = score;
                bestDecryption = decryptedText;
            }
        }

        try {
            File outputFile = new File(outputFileName);
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            writer.write(bestDecryption);
            writer.close();

            System.out.println("Лучший результат сохранен в файле " + outputFileName);
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл");
        }
    }

    public static void bruteForce() {
        Scanner scanner = new Scanner(System.in);
        String inputFileName;
        String representativeFileName;
        String alphabet = Alphabet.getSYMBOLS();
        String outputFileName;

        System.out.print("Введите имя файла с зашифрованным текстом: ");
        inputFileName = scanner.nextLine();

        System.out.print("Введите имя файла с ожидаемым текстом: ");
        representativeFileName = scanner.nextLine();

        System.out.print("Введите имя файла для сохранения расшифрованного текста: ");
        outputFileName = scanner.nextLine();

        scanner.close();

        if (inputFileName.isEmpty()) {
            inputFileName = "encrypted.txt"; // Файл с зашифрованным текстом по умолчанию
        }

        if (representativeFileName.isEmpty()) {
            representativeFileName = "representative.txt"; // Файл с примером текста по умолчанию
        }

        if (outputFileName.isEmpty()) {
            outputFileName = "decrypted.txt"; // Файл для расшифрованного текста по умолчанию
        }

        try {
            File inputFile = new File(inputFileName);
            File representativeFile = new File(representativeFileName);

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedReader representativeReader = new BufferedReader(new FileReader(representativeFile));

            StringBuilder cipherText = new StringBuilder();
            StringBuilder representativeText = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                cipherText.append(line);
            }

            while ((line = representativeReader.readLine()) != null) {
                representativeText.append(line);
            }

            reader.close();
            representativeReader.close();

            bruteForceDecryption(cipherText.toString(), representativeText.toString(), alphabet, outputFileName);
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файлов");
        }
    }
}