package ru.javarush.pyshnyi.crypto.commands;

import ru.javarush.pyshnyi.crypto.result.Result;
import ru.javarush.pyshnyi.crypto.result.ResultCode;

public class Decode implements Actions{
    @Override
    public Result execute(String[] parameters) {
        return new Result("decode all right", ResultCode.OK);
    }
}
