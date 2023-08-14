package com.mapping.gmail;

import java.util.Arrays;
import java.util.List;

public class Temp {
       public static void main(String[] args) {
            String inputString = "This sample words .";
            List<String> wordsToCheck = Arrays.asList("sample", "words", "example");

            boolean containsAnyWord = false;

//            for (String word : wordsToCheck) {
//                if (inputString.contains(word)) {
//                    containsAnyWord = true;
//                    break;
//                }
//            }


            if (containsAnyWord) {
                System.out.println("The input string contains at least one of the words.");
            } else {
                System.out.println("The input string does not contain any of the words.");
            }
        }
    }
