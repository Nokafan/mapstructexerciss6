package com.example.mapstructexerciss6.service.impl;

import com.example.mapstructexerciss6.entity.RockGroups;
import com.example.mapstructexerciss6.repository.RockGroupsRepository;
import com.example.mapstructexerciss6.service.RockGroupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("rockgroupservice")
public class RockGroupsServiceImpl implements RockGroupsService {
    @Autowired
    private RockGroupsRepository repository;

    @Override
    public List<RockGroups> getAllRockGroups() {
        return repository.findAll();
    }

    @Override
    public RockGroups getRockGroupsById(long id) {
        Optional<RockGroups> rockGroupsOptional = repository.findById(id);
        if (!rockGroupsOptional.isPresent()){
            return null;
        }
        RockGroups rockGroups = rockGroupsOptional.get();
        return rockGroups;
    }

    @Override
    public RockGroups addRockGroups(RockGroups rockGroups) {
        return repository.save(rockGroups);
    }

    @Override
    public void delRockGroups(long id) {
        repository.deleteById(id);
    }

    @Override
    public ResponseEntity<Object> updRockGroups(RockGroups rockGroups, long id) {
        Optional<RockGroups> rockGroupsOptional = repository.findById(id);
        if(!rockGroupsOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        rockGroups.setId(id);
        repository.save(rockGroups);
        return ResponseEntity.noContent().build();
    }
}
