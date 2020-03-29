package com.register.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.register.entity.CountryEntity;

public interface CountryRepository extends JpaRepository<CountryEntity, Integer> {

}
