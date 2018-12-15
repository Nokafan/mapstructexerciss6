package com.example.mapstructexerciss6.service.impl;

import com.example.mapstructexerciss6.dto.PeopleDTO;
import com.example.mapstructexerciss6.dto.SongPlayersDTO;
import com.example.mapstructexerciss6.entity.People;
import com.example.mapstructexerciss6.entity.RockGroups;
import com.example.mapstructexerciss6.entity.SongPlayers;
import com.example.mapstructexerciss6.mapper.PeopleMapper;
import com.example.mapstructexerciss6.mapper.SongPlayersMapper;
import com.example.mapstructexerciss6.repository.PeopleRepository;
import com.example.mapstructexerciss6.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("peopleservice")
public class PeopleServiceImpl implements PeopleService {
    @Autowired
    private PeopleRepository repository;

    @Override
    public List<PeopleDTO> getAllPeople() {
        List<PeopleDTO> peopleDTOList = new ArrayList<>();
        List<People> peopleList = repository.findAll();
        for (People people : peopleList){
            peopleDTOList.add(PeopleMapper.PEOPLE_MAPPER.fromPeople(people));
        }
        return peopleDTOList;
    }

    @Override
    public PeopleDTO getPeopleById(long id) {
        Optional<People> peopleOptional = repository.findById(id);
        if (!peopleOptional.isPresent()){
            return null;
        }
        People people = peopleOptional.get();
        PeopleDTO peopleDTO = PeopleMapper.PEOPLE_MAPPER.fromPeople(people);
        return peopleDTO;
    }

    @Override
    public People addPeople(People people) {
        return repository.save(people);
    }

    @Override
    public void delPeople(long id) {
        repository.deleteById(id);
    }

    @Override
    public ResponseEntity<Object> updPeople(People people, long id) {
        Optional<People> peopleOptional = repository.findById(id);
        if (!peopleOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        people.setId(id);
        repository.save(people);
        return ResponseEntity.noContent().build();
    }

    @Override
    public List<RockGroups> getByHuman(String human) {
        List<RockGroups> rockGroupsList = new ArrayList<>();
        List<People> peopleList = repository.findPeopleByHuman(human);
        for (People people : peopleList){
            rockGroupsList.add(people.getRockGroups());
        }
        return rockGroupsList;
    }

    @Override
    public List<String> getSongByHuman(String human) {
        List<String> songList = new ArrayList<>();
        List<List<SongPlayersDTO>> songPlayersDTOListList = new ArrayList<>();
        List<People> peopleList = repository.searchByHuman(human);
        for (People people : peopleList){
            List<SongPlayers> songPlayersList = people.getSongItems();
            List<SongPlayersDTO> songPlayersDTOList = new ArrayList<>();
            for (SongPlayers songPlayers : songPlayersList){
                songPlayersDTOList.add(SongPlayersMapper.SONG_PLAYERS_MAPPER.fromSongPlayers(songPlayers));
                songList.add(songPlayers.getSong());
            }
            songPlayersDTOListList.add(songPlayersDTOList);
//            songPlayersList.add(people.getSongItems());
        }
//        return songPlayersDTOListList;
        return songList;
    }
}
