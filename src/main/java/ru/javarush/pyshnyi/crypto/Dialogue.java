package ru.javarush.pyshnyi.crypto;
import ru.javarush.pyshnyi.crypto.commands.BruteForce;
import ru.javarush.pyshnyi.crypto.commands.Decode;
import ru.javarush.pyshnyi.crypto.commands.Encode;
import java.util.Scanner;

public class Dialogue {
    public static void run(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите режим работы программы:");
        System.out.println("1. Encrypt \n2. Decrypt \n3. Brute Force encrypt \n");
        int i = scanner.nextInt();
        switch (i) {
            case 1 :
                Encode.encode();
                break;
            case 2 :
                Decode.decode();
                break;
            case 3 :
                BruteForce.bruteForce();
                break;
        }
    }
}
