package com.register.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.register.entity.CityEntity;
import com.register.entity.CountryEntity;
import com.register.entity.StateEntity;
import com.register.repository.CityRepository;
import com.register.repository.CountryRepository;
import com.register.repository.StateRepository;

@Service
public class RegisterServiceImpl implements RegisterService {
    
	@Autowired
	private CountryRepository crepo;
	
	@Autowired
	private StateRepository stateRepo;
	
	@Autowired
    private CityRepository cityRepo;
	
	@Override
	public Map<Integer, String> getAllCountries() {
		List<CountryEntity> allCountry = crepo.findAll();
		Map<Integer,String> countryMap = new LinkedHashMap<Integer,String>();
		allCountry.forEach(countryEntity->{
			countryMap.put(countryEntity.getCountryId(),countryEntity.getCountryName());
		});
		return countryMap;
	}

	@Override
	public Map<Integer, String> getAllStatesByCountryId(Integer countryId) {
	  List<StateEntity> allState = stateRepo.findAllByCountryId(countryId);
	  Map<Integer,String> stateMap = new LinkedHashMap<Integer,String>();
	  allState.forEach(stateEntity->{
		  stateMap.put(stateEntity.getStateId(), stateEntity.getStateName());
	  });
		return stateMap;
	}

	@Override
	public Map<Integer, String> getAllCitiesByStateId(Integer stateId) {
		List<CityEntity> allCities = cityRepo.findAllByStateId(stateId);
		Map<Integer,String> cityMap = new LinkedHashMap<Integer,String>();
		allCities.forEach(cityEntity->{
			cityMap.put(cityEntity.getCityId(), cityEntity.getCityName());
		});
		return cityMap;
	}

}
