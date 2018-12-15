package com.example.mapstructexerciss6.dto;

import com.example.mapstructexerciss6.entity.RockGroups;

import java.util.List;

public class PeopleDTO {
    private long id;
    private String human;
    private RockGroups rockGroups;
    private List<SongPlayersDTO> songPlayersList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHuman() {
        return human;
    }

    public void setHuman(String human) {
        this.human = human;
    }

    public RockGroups getRockGroups() {
        return rockGroups;
    }

    public void setRockGroups(RockGroups rockGroups) {
        this.rockGroups = rockGroups;
    }

    public List<SongPlayersDTO> getSongPlayersList() {
        return songPlayersList;
    }

    public void setSongPlayersList(List<SongPlayersDTO> songPlayersList) {
        this.songPlayersList = songPlayersList;
    }
}
