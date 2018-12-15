package com.example.mapstructexerciss6.repository;

import com.example.mapstructexerciss6.entity.RockGroups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RockGroupsRepository extends JpaRepository<RockGroups, Long> {
}
