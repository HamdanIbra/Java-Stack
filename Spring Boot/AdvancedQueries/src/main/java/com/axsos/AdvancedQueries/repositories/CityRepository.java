package com.axsos.AdvancedQueries.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.AdvancedQueries.models.City;

@Repository
public interface CityRepository extends CrudRepository<City, Long>{
	
}
