package com.register.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.register.domain.RegisterDomain;
import com.register.service.RegisterService;
import com.register.service.RegisterServiceImpl;

@Controller
public class RegisterController {
	
	@Autowired
	private RegisterServiceImpl rservice;
	
	@GetMapping(value="/registerForm")
	public String loadForm(Model model) {
		RegisterDomain rdomain = new RegisterDomain();																		
		List<String> gendarList = new ArrayList<String>();
		gendarList.add("Male");
		gendarList.add("Female");
		model.addAttribute("gendar", gendarList);
		model.addAttribute("countryMap",rservice.getAllCountries() );
		model.addAttribute("register", rdomain);
		return "register";
	}
    
	@GetMapping(value="/getStates")
	@ResponseBody
	public Map<Integer,String> getStatesByCountryId(@RequestParam("cid")Integer countryId){
		return rservice.getAllStatesByCountryId(countryId);
	}
	
	@GetMapping(value="/getCities")
	@ResponseBody
	public Map<Integer,String> getCitiesByStateId(@RequestParam("sid")Integer stateId){
		return rservice.getAllCitiesByStateId(stateId);
	}
	
}
