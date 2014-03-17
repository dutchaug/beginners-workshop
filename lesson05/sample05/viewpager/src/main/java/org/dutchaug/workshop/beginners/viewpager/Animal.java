package org.dutchaug.workshop.beginners.viewpager;

public class Animal {

    public String name;
    public String type;
    public int thumbnailResource;
    public int imageResource;
    public int soundResource;
    public String infoUrl;

    public Animal(String name, String type, int thumbnailResource, int imageResource, int soundResource, String infoUrl) {
        this.name = name;
        this.type = type;
        this.thumbnailResource = thumbnailResource;
        this.imageResource = imageResource;
        this.soundResource = soundResource;
        this.infoUrl = infoUrl;
    }

}