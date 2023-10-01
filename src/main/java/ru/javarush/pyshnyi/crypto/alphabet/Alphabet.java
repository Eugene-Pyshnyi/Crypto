package ru.javarush.pyshnyi.crypto.alphabet;

import java.io.File;

public class Alphabet {
    private static final char[] SYMBOLS = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и','к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};
    public static final String TXT_FOLDER = System.getProperty("user.dir") + File.separator + "text" + File.separator;
}
