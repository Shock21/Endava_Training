package com.endava.patterns.visitor;

/**
 * Created by tvasile on 7/31/2016.
 */
public class CharacterCountVisitor implements Visitor {

    @Override
    public int visit(Document document) {
        return document.getContent().length();
    }

}
