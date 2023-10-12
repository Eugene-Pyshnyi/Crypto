package ru.javarush.pyshnyi.crypto.caesar;

public class CaesarDecryption {
    public static String FOR;
    public static String decrypt(String ciphertext, int key, String alphabet) {
        StringBuilder plainText = new StringBuilder();

        for (int i = 0; i < ciphertext.length(); i++) {
            char currentChar = ciphertext.charAt(i);
            int index = alphabet.indexOf(currentChar);

            if (index != -1) {
                int newIndex = (index - key + alphabet.length()) % alphabet.length();
                plainText.append(alphabet.charAt(newIndex));
            } else {
                plainText.append(currentChar);
            }
        }

        return plainText.toString();
    }
}
