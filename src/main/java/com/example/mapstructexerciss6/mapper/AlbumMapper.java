package com.example.mapstructexerciss6.mapper;

import com.example.mapstructexerciss6.dto.AlbumDTO;
import com.example.mapstructexerciss6.entity.Album;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper/*(uses = {SongPlayersMapper.class})*/
public interface AlbumMapper {

    AlbumMapper ALBUM_MAPPER = Mappers.getMapper(AlbumMapper.class);

    AlbumDTO fromAlbum(Album album);

    /*@InheritInverseConfiguration
    Album toAlbum(AlbumDTO albumDTO);*/
}