package com.dansieproject.songr;

public class Album {
    String title;
    String artist;
    int songCount;
    int lengthSeconds;
    String imageUrl;


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
