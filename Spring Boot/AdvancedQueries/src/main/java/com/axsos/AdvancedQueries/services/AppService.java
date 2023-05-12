package com.axsos.AdvancedQueries.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.axsos.AdvancedQueries.repositories.CityRepository;
import com.axsos.AdvancedQueries.repositories.CountryRepository;
import com.axsos.AdvancedQueries.repositories.LanguageRepository;


@Service
public class AppService {
	private final CountryRepository countryRepo;
	private final CityRepository cityRepo;
	private final LanguageRepository languageRepo;
	
	public AppService(CountryRepository countryRepo,CityRepository cityRepo,LanguageRepository languageRepo) {
        this.countryRepo = countryRepo;
        this.cityRepo=cityRepo;
        this.languageRepo=languageRepo;
        
    }
	
	public List<Object[]> getCountries(){
		return countryRepo.getCountries();
	}
	
	public List<Object[]> getCountries1(){
		return countryRepo.getCountries1();
	}
	
	public List<Object[]> getCountries2(){
		return countryRepo.getCountries2();
	}
	
	public List<Object[]> getCountries3(){
		return countryRepo.getCountries3();
	}
	
	public List<Object[]> getCountries4(){
		return countryRepo.getCountries4();
	}
	
	public List<Object[]> getCountries5(){
		return countryRepo.getCountries5();
	}
	
	public List<Object[]> getCountries6(){
		return countryRepo.getCountries6();
	}
	
	public List<Object[]> getCountries7(){
		return countryRepo.getCountries7();
	}
	
}
