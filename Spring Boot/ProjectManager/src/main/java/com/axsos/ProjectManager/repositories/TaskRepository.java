package com.axsos.ProjectManager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.ProjectManager.models.Task;
@Repository
public interface TaskRepository extends CrudRepository<Task, Long>{
	List<Task> findAll();
}
