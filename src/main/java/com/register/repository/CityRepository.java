package com.register.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.register.entity.CityEntity;

public interface CityRepository extends JpaRepository<CityEntity, Integer> {
    public List<CityEntity> findAllByStateId(Integer state);
}
