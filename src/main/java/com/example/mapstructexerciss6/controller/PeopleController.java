package com.example.mapstructexerciss6.controller;

import com.example.mapstructexerciss6.dto.PeopleDTO;
import com.example.mapstructexerciss6.dto.SongPlayersDTO;
import com.example.mapstructexerciss6.entity.People;
import com.example.mapstructexerciss6.entity.RockGroups;
import com.example.mapstructexerciss6.service.impl.PeopleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PeopleController {
    @Autowired
    private PeopleServiceImpl service;

    @GetMapping("/all")
    public List<PeopleDTO> getAllPeople(){
        return service.getAllPeople();
    }

    @GetMapping("/getbyid/{id}")
    public PeopleDTO getPeopleById(@PathVariable long id){
        return service.getPeopleById(id);
    }

    //в каких рок группах участвовал данный исполнитель
    @GetMapping("/getbyhuman/{human}")
    public List<RockGroups> getByHuman(@PathVariable String human){
        return service.getByHuman(human);
    }

    //найти все композиции заданного исполнителя
    @GetMapping("/getsongbyhuman/{human}")
    public List<String> getSongByHuman(@PathVariable String human){
        return service.getSongByHuman(human);
    }

    @PostMapping("/add")
    public People addPeople(@RequestBody People people){
        return service.addPeople(people);
    }

    @DeleteMapping("/del/{id}")
    public void delPeople(@PathVariable long id){
        service.delPeople(id);
    }

    @PutMapping("/upd/{id}")
    public ResponseEntity<Object> updPeople(@RequestBody People people, @PathVariable long id){
        return service.updPeople(people, id);
    }
}


