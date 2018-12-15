package com.example.mapstructexerciss6.service;

import com.example.mapstructexerciss6.entity.RockGroups;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RockGroupsService {
    List<RockGroups> getAllRockGroups();

    RockGroups getRockGroupsById(long id);

    RockGroups addRockGroups(RockGroups rockGroups);

    void delRockGroups(long id);

    ResponseEntity<Object> updRockGroups(RockGroups rockGroups, long id);
}
