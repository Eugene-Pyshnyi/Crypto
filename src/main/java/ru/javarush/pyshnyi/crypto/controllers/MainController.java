package ru.javarush.pyshnyi.crypto.controllers;

import ru.javarush.pyshnyi.crypto.commands.Actions;
import ru.javarush.pyshnyi.crypto.result.Result;

public class MainController {
    public Result act(String actionName, String[] parameters) {
        //action == encode
        //parameters = [text.txt, encode.txt, 12]
        Actions action = ActionFactory.find(actionName);
        return action.execute(parameters);
    }
}
