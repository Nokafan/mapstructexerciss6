package com.example.mapstructexerciss6.controller;

import com.example.mapstructexerciss6.dto.AlbumDTO;
import com.example.mapstructexerciss6.entity.Album;
import com.example.mapstructexerciss6.service.impl.AlbumServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/album")
public class AlbumController {
    @Autowired
    private AlbumServiceImpl service;

    @GetMapping("/all")
    public List<AlbumDTO> getAllAlbum(){
        return service.getAllAlbum();
    }

    @GetMapping("/getbyid/{id}")
    public AlbumDTO getAlbumById(@PathVariable long id){
        return service.getAlbumById(id);
    }

    @PostMapping("/add")
    public Album addAlbum(@RequestBody Album album){
        return service.addAlbum(album);
    }

    @DeleteMapping("/del/{id}")
    public void delAlbum(@PathVariable long id ){
        service.delAlbum(id);
    }

    @PutMapping("/upd/{id}")
    public ResponseEntity<Object> updAlbum(@RequestBody Album album, @PathVariable long id){
        return service.updAlbum(album, id);
    }
}

