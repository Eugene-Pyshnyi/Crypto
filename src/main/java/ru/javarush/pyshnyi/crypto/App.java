package ru.javarush.pyshnyi.crypto;

import ru.javarush.pyshnyi.crypto.controllers.MainController;
import ru.javarush.pyshnyi.crypto.exceptions.CryptoExceptions;
import ru.javarush.pyshnyi.crypto.result.Result;

import java.util.Arrays;

public class App {
    private MainController mainController;
    public App() {
        mainController = new MainController();
    }
    public Result run(String[] args) {
        if (args.length > 0) {
            String action = args[0];
            String[] parameters = Arrays.copyOfRange(args, 1, args.length);
        mainController.act(action, parameters);
        }
        throw new CryptoExceptions();
    }
}
