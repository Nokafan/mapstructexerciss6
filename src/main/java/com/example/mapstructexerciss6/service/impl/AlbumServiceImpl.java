package com.example.mapstructexerciss6.service.impl;

import com.example.mapstructexerciss6.dto.AlbumDTO;
import com.example.mapstructexerciss6.entity.Album;
import com.example.mapstructexerciss6.mapper.AlbumMapper;
import com.example.mapstructexerciss6.repository.AlbumRepository;
import com.example.mapstructexerciss6.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("albumservice")
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private AlbumRepository repository;

    @Override
    public List<AlbumDTO> getAllAlbum() {
        List<AlbumDTO> albumDTOList = new ArrayList<>();
        List<Album> albumList = repository.findAll();
        for (Album album : albumList){
            albumDTOList.add(AlbumMapper.ALBUM_MAPPER.fromAlbum(album));
        }
        return albumDTOList;
    }

    @Override
    public AlbumDTO getAlbumById(long id) {
        Album album = repository.findAlbumById(id);
        AlbumDTO albumDTO = AlbumMapper.ALBUM_MAPPER.fromAlbum(album);
        return albumDTO;
    }

    @Override
    public Album addAlbum(Album album) {
        return repository.save(album);
    }

    @Override
    public void delAlbum(long id) {
        repository.deleteById(id);
    }

    @Override
    public ResponseEntity<Object> updAlbum(Album album, long id) {
        Optional<Album> albumOptional = repository.findById(id);
        if (!albumOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        album.setId(id);
        repository.save(album);
        return ResponseEntity.noContent().build();
    }
}
