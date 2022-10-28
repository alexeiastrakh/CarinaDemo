package com.solvd.carina.demo.gui.components;

public enum HeaderButton {

    NEWS("News"),
    REVIEWS("Reviews"),
    VIDEOS("Videos"),
    FEATURED("Featured"),
    PHONE_FINDER("Phone Finder"),
    DEALS("Deals"),
    MERCH("Merch"),
    COVERAGE("Coverage"),
    CONTACT("Contact"),
    HOME("Home");
    private String value;

    HeaderButton(String value){
        this.value = value;
    }

    public  String getValue() {
        return  value;
    }
}