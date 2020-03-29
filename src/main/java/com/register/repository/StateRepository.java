package com.register.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.register.entity.StateEntity;

public interface StateRepository extends JpaRepository<StateEntity, Integer> {
      public List<StateEntity> findAllByCountryId(Integer countryId);
}
