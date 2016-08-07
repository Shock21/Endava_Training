package com.endava.patterns.visitor;

/**
 * Created by tvasile on 7/31/2016.
 */
public class Document implements Element {

    String content;

    public Document(String content) { this.content = content; }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int accept(Visitor visitor) {
        return visitor.visit(this);
    }

}
