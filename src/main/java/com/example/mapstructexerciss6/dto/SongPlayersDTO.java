package com.example.mapstructexerciss6.dto;

import java.util.List;

public class SongPlayersDTO {
    private long id;
    private String song;
    private String composer;
    private String poet;
    private String album;

    private List<PeopleDTO> songInstrumentalist;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public String getPoet() {
        return poet;
    }

    public void setPoet(String poet) {
        this.poet = poet;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public List<PeopleDTO> getSongInstrumentalist() {
        return songInstrumentalist;
    }

    public void setSongInstrumentalist(List<PeopleDTO> songInstrumentalist) {
        this.songInstrumentalist = songInstrumentalist;
    }

    @Override
    public String toString() {
        return String.format("[id=%s, song=%s, composer=%s, poet=%s, album=%s]", id, song, composer, poet, album);
    }
}
