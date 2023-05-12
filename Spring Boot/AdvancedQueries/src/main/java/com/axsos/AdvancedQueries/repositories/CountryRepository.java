package com.axsos.AdvancedQueries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.AdvancedQueries.models.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long>{
	@Query(value="select country.name ,countrylanguage.language as language ,countrylanguage.percentage as language_percentage from country join countrylanguage on country.code = countrylanguage.countrycode where countrylanguage.language=\"Slovene\" order by language_percentage desc;", nativeQuery=true)
    List<Object[]> getCountries();
    
    @Query(value="select country.name as country_name ,count(city.countrycode) as num_of_cities from country join city on country.code = city.countrycode group by country_name order by num_of_cities desc;", nativeQuery=true)
    List<Object[]> getCountries1();
    
    @Query(value="select country.name as country_name ,city.name as city_name,city.population as population from country join city on country.code = city.countrycode where country.name=\"mexico\" and city.population>500000 order by population desc;", nativeQuery=true)
    List<Object[]> getCountries2();
    
    @Query(value="select country.name as country_name ,countrylanguage.language as language ,countrylanguage.percentage as language_percentage from country join countrylanguage on country.code = countrylanguage.countrycode where countrylanguage.percentage>89 order by language_percentage desc;", nativeQuery=true)
    List<Object[]> getCountries3();
    
    @Query(value="select country.name as country_name ,country.population as population , country.surfacearea as surfacearea from country where population >100000 and surfacearea < 501;", nativeQuery=true)
    List<Object[]> getCountries4();
    
    @Query(value="select country.name as country_name ,country.GovernmentForm as government_form , country.capital as capital , country.lifeexpectancy as life_expectancy from country where country.GovernmentForm= \"Constitutional Monarchy\" and capital>200 and country.lifeexpectancy >75;", nativeQuery=true)
    List<Object[]> getCountries5();
    
    @Query(value="select country.name as country_name ,city.name as city_name,city.population as population , city.district from country join city on country.code = city.countrycode where country.name=\"Argentina\" and city.population>500000 and district=\"Buenos Aires\";", nativeQuery=true)
    List<Object[]> getCountries6();
    
    @Query(value="select country.region, count(country.region) as num_of_countries from country group by region order by num_of_countries desc;", nativeQuery=true)
    List<Object[]> getCountries7();
    
}

