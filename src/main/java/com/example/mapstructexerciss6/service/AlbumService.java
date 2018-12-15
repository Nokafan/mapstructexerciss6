package com.example.mapstructexerciss6.service;

import com.example.mapstructexerciss6.dto.AlbumDTO;
import com.example.mapstructexerciss6.entity.Album;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AlbumService {

    List<AlbumDTO> getAllAlbum();

    AlbumDTO getAlbumById(long id);

    Album addAlbum(Album album);

    void delAlbum(long id);

    ResponseEntity<Object> updAlbum(Album album, long id);
}
