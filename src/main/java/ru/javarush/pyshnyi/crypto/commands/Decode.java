package ru.javarush.pyshnyi.crypto.commands;

import ru.javarush.pyshnyi.crypto.alphabet.Alphabet;
import ru.javarush.pyshnyi.crypto.caesar.CaesarDecryption;

import java.io.*;
import java.util.Scanner;


public class Decode extends CaesarDecryption{
        public static void decode() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите ключ для расшифровки:");
            int key = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Введите путь к файлу с зашифрованным текстом:");
            String inputFileName = scanner.nextLine();
            if (inputFileName.isEmpty()) {
                inputFileName = "encrypted.txt";
            }

            String alphabet = Alphabet.getSYMBOLS();

            System.out.println("Введите имя файла для сохранения расшифрованного текста или нажмите Enter:");
            String outputFileName = scanner.nextLine();

            if (outputFileName.isEmpty()) {
                outputFileName = "decrypted.txt";
            }

            scanner.close();

            try {
                File inputFile = new File(inputFileName);
                if (!inputFile.exists()) {
                    System.err.println("Файл с зашифрованным текстом не найден!");
                    return;
                }

                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                StringBuilder cipherText = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    cipherText.append(line);
                }

                reader.close();

                String decryption = decrypt(cipherText.toString(), key, alphabet);

                File outputFile = new File(outputFileName);
                if (!outputFile.exists()) {
                    outputFile.createNewFile();
                }

                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
                writer.write(decryption);
                writer.newLine();
                writer.close();
                System.out.println("Текст расшифрован и сохранен в файл " + outputFileName);
            } catch (IOException e) {
                System.err.println("Ошибка при чтении/записи файла");
            }
        }
    }