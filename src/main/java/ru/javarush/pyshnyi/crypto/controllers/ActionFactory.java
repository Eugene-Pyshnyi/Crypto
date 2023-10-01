package ru.javarush.pyshnyi.crypto.controllers;

import ru.javarush.pyshnyi.crypto.commands.Actions;
import ru.javarush.pyshnyi.crypto.commands.Decode;
import ru.javarush.pyshnyi.crypto.commands.Encode;
import ru.javarush.pyshnyi.crypto.exceptions.CryptoExceptions;

public enum ActionFactory {
    ENCODE(new Encode()),
    DECODE(new Decode());

    private final Actions actions;

    ActionFactory(Actions actions) {
        this.actions = actions;
    }
    public static Actions find(String actionName) {
        try {
            ActionFactory value = ActionFactory.valueOf(actionName.toUpperCase());
            return value.actions;
        }catch (IllegalArgumentException exception) {
            throw new CryptoExceptions("Not found " + actionName, exception);
        }
    }
}
