package com.endava.io;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by tvasile on 7/19/2016.
 */
public class Ex2 {

    public static ArrayList<String> getContent(String filename) {
        ArrayList<String> fileLines = new ArrayList<>();
        int bufferSize = 8 * 1024;

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filename), bufferSize)) {
            bufferedReader.lines().forEach(consumer -> fileLines.add(consumer));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileLines;
    }

    public static void reverseContent(ArrayList<String> lines) {
        Collections.reverse(lines);
        lines.forEach(line -> System.out.println(reverseLine(line)));
    }

    public static String reverseLine(String line) {
        StringBuilder builder= new StringBuilder();
        builder.append(line).reverse();
        line = builder.toString();
        builder = new StringBuilder();

        for(String word : line.split(" ")) {
            builder.append(reverseWord(word) + " ");
        }

        return builder.toString();
    }

    public static String reverseWord(String word) {
        byte[] wordAsBytes = word.getBytes();
        byte[] reversedWord = new byte[wordAsBytes.length];

        for(int i = 0; i < wordAsBytes.length; i++)
            reversedWord[i] = wordAsBytes[wordAsBytes.length - i - 1];

        return new String(reversedWord);
    }

    public static void main(String[] args) {
        String fileName = "D:/java-io-files/testFile2.txt";
        ArrayList<String> fileLines = getContent(fileName);
        reverseContent(fileLines);
    }

}
