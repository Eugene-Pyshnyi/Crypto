package ru.javarush.pyshnyi.crypto;

import ru.javarush.pyshnyi.crypto.result.Result;

public class Runner {
    public static void main(String[] args) {
        //encode text.txt encode.txt 12
        Application application = new Application();
        Result result = application.run(args);
        System.out.println(result);
    }
}
