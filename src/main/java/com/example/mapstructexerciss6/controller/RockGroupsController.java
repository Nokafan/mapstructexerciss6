package com.example.mapstructexerciss6.controller;

import com.example.mapstructexerciss6.entity.RockGroups;
import com.example.mapstructexerciss6.repository.RockGroupsRepository;
import com.example.mapstructexerciss6.service.impl.RockGroupsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rockgroups")
public class RockGroupsController {
    @Autowired
    private RockGroupsRepository repository;
    @Autowired
    private RockGroupsServiceImpl service;

    @GetMapping("/all")
    public List<RockGroups> getAllRockGroups(){
        return service.getAllRockGroups();
    }

    @GetMapping("/getbyid/{id}")
    public RockGroups getRockGroupsById(@PathVariable long id){
        return service.getRockGroupsById(id);
    }

    @PostMapping("/add")
    public RockGroups addRockGroups(@RequestBody RockGroups rockGroups){
        return service.addRockGroups(rockGroups);
    }

    @DeleteMapping("/del/{id}")
    public void delRockGroups(@PathVariable long id){
        service.delRockGroups(id);
    }

    @PutMapping("/upd/{id}")
    public ResponseEntity<Object> updRockGroups(@RequestBody RockGroups rockGroups, @PathVariable long id){
        return service.updRockGroups(rockGroups, id);
    }
}
