package com.example.mapstructexerciss6.service;

import com.example.mapstructexerciss6.dto.PeopleDTO;
import com.example.mapstructexerciss6.dto.SongPlayersDTO;
import com.example.mapstructexerciss6.entity.SongPlayers;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SongPlayersService {
    List<SongPlayersDTO> getAllSongPlayers();

    SongPlayersDTO getSongPlayersById(long id);

    SongPlayers addSongPlayers(SongPlayers songPlayers);

    void delSongPlayers(long id);

    ResponseEntity<Object> updSongPlayers(SongPlayers songPlayers, long id);

    List<PeopleDTO> getPeopleBySong(String song);

    List<String> getAlbumBySong(String song);

    List<String> getSongByComposer(String composer);

    List<String> getSongByPoet(String poet);
}
