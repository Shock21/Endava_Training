package com.endava.design;

import java.util.ArrayList;

/**
 * Created by tvasile on 7/22/2016.
 */
public class AlphabetMappingService {

    public static final int FIRSTLETTERASCII = 97;

    public static ArrayList<LetterMapping> generateAlphabetLettersMapping() {

        ArrayList<LetterMapping>  alphabetLettersMappingList = new ArrayList<LetterMapping>();

        for(int i = 0; i < 26; i++) {
            String letter = String.valueOf((char) (FIRSTLETTERASCII + i));
            alphabetLettersMappingList.add(new LetterMapping(letter, i + 1));
        }

        return  alphabetLettersMappingList;
    }

}
