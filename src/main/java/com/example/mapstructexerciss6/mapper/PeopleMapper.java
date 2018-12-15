package com.example.mapstructexerciss6.mapper;

import com.example.mapstructexerciss6.dto.PeopleDTO;
import com.example.mapstructexerciss6.entity.People;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = SongPlayersMapper.class)
public interface PeopleMapper {

    PeopleMapper PEOPLE_MAPPER = Mappers.getMapper(PeopleMapper.class);

    @Mapping(source = "songItems", target = "songPlayersList")
    PeopleDTO fromPeople(People people);
}
