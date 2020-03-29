package com.register.service;

import java.util.Map;

public interface RegisterService {
   public Map<Integer,String> getAllCountries();
   public Map<Integer,String> getAllStatesByCountryId(Integer countryId);
   public Map<Integer,String> getAllCitiesByStateId(Integer stateId);
 }
