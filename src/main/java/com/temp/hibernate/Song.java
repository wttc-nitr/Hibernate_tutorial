package com.temp.hibernate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

// tells hibernate that this is a special class & not a POJO
@Entity
public class Song {
    // we can provide mapping for id also, but it's not necessary, since it's a primary key
    // & primary key is unique.

    // to tell hibernate that songId is the primary key
    @Id
    private int songId;

    // we don't need to provide mapping if property_name here is same as that of in DB.
    // songName property should be mapped with songname (in db)
    @Column(name = "songname")
    private String songName;

    @Column(name = "songartist")
    private String songArtist;

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongArtist() {
        return songArtist;
    }

    public void setSongArtist(String songArtist) {
        this.songArtist = songArtist;
    }
}
