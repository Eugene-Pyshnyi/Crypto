package ru.javarush.pyshnyi.crypto.caesar;

public class CaesarEncryption {
    public static String encrypt(String plaintext, int key, String alphabet) {
        StringBuilder cipherText = new StringBuilder();

        for (int i = 0; i < plaintext.length(); i++) {
            char currentChar = plaintext.charAt(i);
            int index = alphabet.indexOf(currentChar);

            if (index != -1) {
                int newIndex = (index + key) % alphabet.length();
                cipherText.append(alphabet.charAt(newIndex));
            } else {
                cipherText.append(currentChar);
            }
        }

        return cipherText.toString();
    }
}
