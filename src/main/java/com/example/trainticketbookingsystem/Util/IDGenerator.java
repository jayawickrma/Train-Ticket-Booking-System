package com.example.trainticketbookingsystem.Util;

import java.util.HashSet;
import java.util.Set;

public class IDGenerator {
    private static final Set<Integer> generatedNumbers = new HashSet<>();
    private static int minRange = 1;
    private static int maxRange = 1000;
    public static String generateId(String prefix){
        int randomNumber;
        do{
            randomNumber = (int) (Math.random() * (maxRange - minRange + 1)) + minRange;
        }while (generatedNumbers.contains(randomNumber));
        generatedNumbers.add(randomNumber);

        if (generatedNumbers.size() >= (maxRange - minRange + 1)){
            generatedNumbers.clear();
            minRange = 1000;
            maxRange = 10000;
        }
        return prefix + randomNumber;
    }
}
