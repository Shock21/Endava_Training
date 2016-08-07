package com.endava.patterns.visitor;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by tvasile on 7/31/2016.
 */
public class VisitorDemo {

    public static String readFromFile(String filePath) {
        String myDocument = new String();

        try {
            myDocument = new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return myDocument;
    }

    public static void main(String[] args) {

        String filePath = "D:/java-io-files/testFile.txt";

        Document document = new Document(readFromFile(filePath));

        Visitor words = new WordCountVisitor();

        Visitor characters = new CharacterCountVisitor();

        System.out.println("Number of words: " + words.visit(document));
        System.out.println("Number of characters: " + characters.visit(document));
    }
}
