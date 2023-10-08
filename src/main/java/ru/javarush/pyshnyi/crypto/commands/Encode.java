package ru.javarush.pyshnyi.crypto.commands;

import ru.javarush.pyshnyi.crypto.alphabet.Alphabet;
import ru.javarush.pyshnyi.crypto.caesar.CaesarEncryption;

import java.io.*;
import java.util.Scanner;

public class Encode extends CaesarEncryption {
    public static void encode() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ключ шифрования:");
        int key = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Укажите путь к файлу для шифрования:");
        String inputFileName = scanner.nextLine();
        if (inputFileName.isEmpty()) {
            inputFileName = "encrypt.txt";
        }

        String alphabet = Alphabet.getSYMBOLS();

        System.out.println("Введите имя файла для сохранения результатов или нажмите Enter:");
        String outputFileName = scanner.nextLine();
        if (outputFileName.isEmpty()) {
            outputFileName = "encrypted.txt";
        }
        scanner.close();

        try {
            File inputFile = new File(inputFileName);

            if (!inputFile.exists()) {
                inputFile.createNewFile();
                System.err.println("Создан новый файл: " + inputFileName);
            }

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            StringBuilder cipherText = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                cipherText.append(line);
            }
            reader.close();

            String encryption = encrypt(cipherText.toString(), key, alphabet);

            File outputFile = new File(outputFileName);
            if (!outputFile.exists()) {
                outputFile.createNewFile();
                System.err.println("Создан новый файл: " + outputFileName);
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            writer.write(encryption);
            writer.newLine();
            writer.close();
            System.out.println("Текст зашифрован и сохранен в файл " + outputFileName);
        } catch (IOException e) {
            System.err.println("Ошибка при обработке файлов");
        }
    }
}