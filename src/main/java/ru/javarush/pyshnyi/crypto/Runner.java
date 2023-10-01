package ru.javarush.pyshnyi.crypto;

import ru.javarush.pyshnyi.crypto.result.Result;

public class Runner {
    public static void main(String[] args) {

        App app = new App();
        Result result = app.run(args);
        System.out.println(result);
    }
}
