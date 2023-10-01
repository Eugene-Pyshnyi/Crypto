package ru.javarush.pyshnyi.crypto.commands;

import ru.javarush.pyshnyi.crypto.result.Result;

public interface Actions {
    Result execute(String[] parameters);
}
