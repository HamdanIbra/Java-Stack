package com.axsos.DojosAndNinjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.axsos.DojosAndNinjas.models.Dojo;


public interface DojoRepository extends CrudRepository<Dojo, Long>{
	List<Dojo> findAll();
}
