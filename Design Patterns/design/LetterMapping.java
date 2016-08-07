package com.endava.design;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by tvasile on 7/22/2016.
 */
public class LetterMapping {

    Mapping<String, Integer> letterMapping;

    public LetterMapping(String letter, Integer number) {
        letterMapping = new Mapping<String, Integer>(letter, number);
    }

    @Override
    public String toString() {
        return "Letter: " + letterMapping.getKey() +
                " - " +
                "Value: " + letterMapping.getValue();
    }

    public static void main(String[] args) {
        AlphabetMappingService.generateAlphabetLettersMapping().forEach(mapping -> System.out.println(mapping));
    }
}
