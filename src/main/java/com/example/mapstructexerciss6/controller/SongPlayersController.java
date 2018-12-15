package com.example.mapstructexerciss6.controller;

import com.example.mapstructexerciss6.dto.PeopleDTO;
import com.example.mapstructexerciss6.dto.SongPlayersDTO;
import com.example.mapstructexerciss6.entity.SongPlayers;
import com.example.mapstructexerciss6.service.SongPlayersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/songplayers")
public class SongPlayersController {
    @Autowired
    private SongPlayersService service;

    @GetMapping("/all")
    public List<SongPlayersDTO> getSongPlayers(){
        return service.getAllSongPlayers();
    }

    @GetMapping("/getbyid/{id}")
    public SongPlayersDTO getSongPlayersById(@PathVariable long id){
        return service.getSongPlayersById(id);
    }

    //найти всех исполнителей которые исполняли данную композицию
    @GetMapping("/getpeoplebysong/{song}")
    public List<PeopleDTO> getPeopleBySong(@PathVariable String song){
       return service.getPeopleBySong(song);
    }

    //найти все альбомы на которых издавалась данная композиция
    @GetMapping("/getalbumbysong/{song}")
    public List<String> getAlbumBySong(@PathVariable String song){
        return service.getAlbumBySong(song);
    }

    //найти все композиции заданного композитора
    @GetMapping("/getsongbycomposer/{composer}")
    public List<String> getSongByComposer(@PathVariable String composer){
        return service.getSongByComposer(composer);
    }

    //найти все композиции заданного поэта
    @GetMapping("/getsongbypoet/{poet}")
    public List<String> getSongByPoet(@PathVariable String poet){
        return service.getSongByPoet(poet);
    }

    @PostMapping("/add")
    public SongPlayers addSongPlayers(@RequestBody SongPlayers songPlayers){
        return service.addSongPlayers(songPlayers);
    }

    @DeleteMapping("/del/{id}")
    public void delSongPlayers(@PathVariable long id){
        service.delSongPlayers(id);
    }

    @PutMapping("/upd/{id}")
    public ResponseEntity<Object> updSongPlayers(@RequestBody SongPlayers songPlayers, @PathVariable long id){
        return service.updSongPlayers(songPlayers, id);
    }
}
