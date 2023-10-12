package ru.javarush.pyshnyi.crypto;
import ru.javarush.pyshnyi.crypto.commands.BruteForce;
import ru.javarush.pyshnyi.crypto.commands.Decode;
import ru.javarush.pyshnyi.crypto.commands.Encode;
import java.util.Scanner;

public class Dialogue {
    public static String TEACHING;
    public static void run(){
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Выберите режим работы программы:");
            System.out.println("1. Encryption \n2. Decryption \n3. Brute Force decryption \n");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    Encode.encode();
                    break;
                case 2:
                    Decode.decode();
                    break;
                case 3:
                    BruteForce.bruteForce();
                    break;
                default:
                    System.err.println("Выберите один из вариантов");
            }
        } while (choice < 1 || choice > 3);
    }
}
