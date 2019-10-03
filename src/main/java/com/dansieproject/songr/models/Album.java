package com.dansieproject.songr.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Album {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    public long id;

    @OneToMany(mappedBy = "album")
    List<Song> songs;

    protected String title;
    protected String artist;
    protected int songCount;
    protected int lengthSeconds;
    protected String imageUrl;

    public long getId() {
        return id;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public String getArtist() {
        return artist;
    }

    public int getSongCount() {
        return songCount;
    }

    public int getLengthSeconds() {
        return lengthSeconds;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getTitle(){
        return this.title;
    }

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
