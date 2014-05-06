package org.dutchaug.workshop.beginners.listviews;

public class Animal {

    public String name;
    public String type;
    public int thumbnailResource;
    public int imageResource;
    public String infoUrl;

    public Animal(String name, String type, int thumbnailResource, int imageResource, String infoUrl) {
        this.name = name;
        this.type = type;
        this.thumbnailResource = thumbnailResource;
        this.imageResource = imageResource;
        this.infoUrl = infoUrl;
    }

}