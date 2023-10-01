package ru.javarush.pyshnyi.crypto.alphabet;

import java.io.File;

public class Alphabet {
    private static final String LETTERS = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    private static final String SYMBOLS = ",.:!-?\" ";
    private static final String ALPHABET = LETTERS.toLowerCase() +  SYMBOLS;
    public static final String TXT_FOLDER = System.getProperty("user.dir") + File.separator + "text" + File.separator;
}
