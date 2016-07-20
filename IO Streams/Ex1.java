package com.endava.io;

import com.sun.deploy.util.StringUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by tvasile on 7/19/2016.
 */
public class Ex1 {

    public static int getCharacterOccurences(String filename, int position, String myCharacter) {
        int appearances = 0;

        try(RandomAccessFile accessFile = new RandomAccessFile(filename, "r")){
            long size = accessFile.length();
            accessFile.seek(position);
            while(accessFile.getFilePointer() < size) {
                String characters = accessFile.readLine();
                appearances += characters.length() - characters.replace(myCharacter, "").length();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return appearances;
    }

    public static void main(String[] args) {
        String fileName = "D:/java-io-files/testFile.txt";
        System.out.println(getCharacterOccurences(fileName, 10, "i"));
    }

}
