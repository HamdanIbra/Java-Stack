package com.axsos.AdvancedQueries.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.AdvancedQueries.models.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long>{

}
