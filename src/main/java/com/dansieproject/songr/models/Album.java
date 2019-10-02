package com.dansieproject.songr.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    public String title;
    public String artist;
    public int songCount;
    public int lengthSeconds;
    public String imageUrl;

    public Album(){}

    public Album(String title, String artist, int songCount, int lengthSeconds, String imageUrl) {
        this.title = title;
        this.artist = artist;
        this.songCount = songCount;
        this.lengthSeconds = lengthSeconds;
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return String.format("The %s was written by %s. It has %d songs, and is %d minutes and %d seconds long.",title, artist, songCount, lengthSeconds/60, lengthSeconds%60);
    }
}
