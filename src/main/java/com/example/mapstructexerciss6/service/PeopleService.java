package com.example.mapstructexerciss6.service;

import com.example.mapstructexerciss6.dto.PeopleDTO;
import com.example.mapstructexerciss6.entity.People;
import com.example.mapstructexerciss6.entity.RockGroups;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PeopleService {
    List<PeopleDTO> getAllPeople();

    PeopleDTO getPeopleById(long id);

    People addPeople(People people);

    void delPeople(long id);

    ResponseEntity<Object> updPeople(People people, long id);

    List<RockGroups> getByHuman(String human);

    List<String> getSongByHuman(String human);
}
