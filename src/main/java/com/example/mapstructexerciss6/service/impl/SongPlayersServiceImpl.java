package com.example.mapstructexerciss6.service.impl;

import com.example.mapstructexerciss6.dto.PeopleDTO;
import com.example.mapstructexerciss6.dto.SongPlayersDTO;
import com.example.mapstructexerciss6.entity.People;
import com.example.mapstructexerciss6.entity.SongPlayers;
import com.example.mapstructexerciss6.mapper.PeopleMapper;
import com.example.mapstructexerciss6.mapper.SongPlayersMapper;
import com.example.mapstructexerciss6.repository.SongPlayersRepository;
import com.example.mapstructexerciss6.service.SongPlayersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("songplayersservice")
public class SongPlayersServiceImpl implements SongPlayersService {
    @Autowired
    private SongPlayersRepository repository;

    @Override
    public List<SongPlayersDTO> getAllSongPlayers() {
        List<SongPlayersDTO> songPlayersDTOList = new ArrayList<>();
        List<SongPlayers> songPlayersList = repository.findAll();
        for (SongPlayers songPlayers : songPlayersList){
            songPlayersDTOList.add(SongPlayersMapper.SONG_PLAYERS_MAPPER.fromSongPlayers(songPlayers));
        }
        return songPlayersDTOList;
    }

    @Override
    public SongPlayersDTO getSongPlayersById(long id) {
        Optional<SongPlayers> songPlayersOptional = repository.findById(id);
        if (!songPlayersOptional.isPresent()){
            return null;
        }
        SongPlayers songPlayers = songPlayersOptional.get();
        SongPlayersDTO songPlayersDTO = SongPlayersMapper.SONG_PLAYERS_MAPPER.fromSongPlayers(songPlayers);
        return songPlayersDTO;
    }

    @Override
    public SongPlayers addSongPlayers(SongPlayers songPlayers) {
        return repository.save(songPlayers);
    }

    @Override
    public void delSongPlayers(long id) {
        repository.deleteById(id);
    }

    @Override
    public ResponseEntity<Object> updSongPlayers(SongPlayers songPlayers, long id) {
        Optional<SongPlayers> songPlayersOptional = repository.findById(id);
        if (!songPlayersOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        songPlayers.setId(id);
        repository.save(songPlayers);
        return ResponseEntity.noContent().build();
    }

    @Override
    public List<PeopleDTO> getPeopleBySong(String song) {
        List<SongPlayers> songPlayersList = repository.findSongPlayersBySong(song);
        List<List<People>> songInstrumentalistList = new ArrayList<>();
        for (SongPlayers songPlayers : songPlayersList){
            songInstrumentalistList.add(songPlayers.getSongInstrumentalist());
        }

        List<PeopleDTO> peopleDTOList = new ArrayList<>();
        for (List<People> peopleList : songInstrumentalistList){
            for (People people : peopleList){
                PeopleDTO peopleDTO = PeopleMapper.PEOPLE_MAPPER.fromPeople(people);
                peopleDTOList.add(peopleDTO);
            }
        }
        return peopleDTOList;
    }

    @Override
    public List<String> getAlbumBySong(String song) {
        List<SongPlayers> songPlayersList = repository.findSongPlayersBySong(song);
        List<String> albumList = new ArrayList<>();
        for (SongPlayers songPlayers :songPlayersList){
            albumList.add(songPlayers.getAlbum());
        }
        return albumList;
    }

    @Override
    public List<String> getSongByComposer(String composer) {
        List<SongPlayers> songPlayersList = repository.findSongPlayersByComposer(composer);
        List<String> songList = new ArrayList<>();
        for (SongPlayers songPlayers :songPlayersList){
            songList.add(songPlayers.getSong());
        }
        return songList;
    }

    @Override
    public List<String> getSongByPoet(String poet) {
        List<SongPlayers> songPlayersList = repository.findSongPlayersByPoet(poet);
        List<String> songList = new ArrayList<>();
        for (SongPlayers songPlayers : songPlayersList){
            songList.add(songPlayers.getSong());
        }
        return songList;
    }
}
