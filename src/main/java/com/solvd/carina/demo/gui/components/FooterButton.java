package com.solvd.carina.demo.gui.components;

public enum FooterButton {

    NEWS("News"),
    REVIEWS("Reviews"),
    Compare("Compare"),
    Coverage("Coverage"),
    Glossary("Glossary"),
    FAQ("FAQ"),
    RSS_FEED("RSS feed"),
    YOUTUBE("Youtube"),
    FACEBOOK ("Facebook"),
    TWITTER ("Twitter"),
    INSTAGRAM ("Instagram"),
    HOME("Home");

    private String value;

    FooterButton(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}