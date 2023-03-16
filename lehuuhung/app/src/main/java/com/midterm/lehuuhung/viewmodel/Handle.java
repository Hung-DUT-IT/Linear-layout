package com.midterm.lehuuhung.viewmodel;

import java.util.ArrayList;

public class Handle {
    public int countLetter(String input) {
        if (input == null) {
            return -1;
        }
        int letterCount = 0;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (Character.isLetter(ch)) {
                letterCount++;
            }
        }
        return letterCount;
    }
    public int countDigit(String input) {
        if (input == null) {
            return -1;
        }
        int numberCount = 0;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (Character.isDigit(ch)) {
                numberCount++;
            }
        }
        return numberCount;
    }
    public String removeEven(String input) {
        if (input == null) {
            return null;
        }
        String[] inputArr = input.split(",");
        ArrayList<String> outputArr = new ArrayList<String>();
        for (int i = 0; i < inputArr.length; i++) {
            int num = Integer.parseInt(inputArr[i]);
            if (num % 2 != 0) {
                outputArr.add(inputArr[i]);
            }
        }

        String output = String.join(",", outputArr);
        return output;
    }
}
