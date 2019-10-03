package com.dansieproject.songr.models;

import javax.persistence.*;

@Entity
public class Song {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    public long id;

    @ManyToOne
    Album album;

    public String title;
    public int lengthSeconds;
    public int trackNumber;

    public Song(){};

    public Song(Album album, String title, int lengthSeconds, int trackNumber) {
        this.album = album;
        this.title = title;
        this.lengthSeconds = lengthSeconds;
        this.trackNumber = trackNumber;
    }

    public void setAlbum(Album a){
        this.album = a;
    }


    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", album=" + album +
                ", title='" + title + '\'' +
                ", lengthSeconds=" + lengthSeconds +
                ", trackNumber=" + trackNumber +
                '}';
    }
}
