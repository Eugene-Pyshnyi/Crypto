package ru.javarush.pyshnyi.crypto.commands;

import ru.javarush.pyshnyi.crypto.result.Result;
import ru.javarush.pyshnyi.crypto.result.ResultCode;

public class BruteForce implements Actions{
    @Override
    public Result execute(String[] parameters) {
        //TODO something do
        return new Result("BrudeForce complete", ResultCode.OK);
    }
}
