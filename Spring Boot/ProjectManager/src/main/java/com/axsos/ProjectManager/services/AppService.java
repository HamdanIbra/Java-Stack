package com.axsos.ProjectManager.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.axsos.ProjectManager.models.LoginUser;
import com.axsos.ProjectManager.models.Project;
import com.axsos.ProjectManager.models.Task;
import com.axsos.ProjectManager.models.User;
import com.axsos.ProjectManager.repositories.ProjectRepository;
import com.axsos.ProjectManager.repositories.TaskRepository;
import com.axsos.ProjectManager.repositories.UserRepository;

@Service
public class AppService {
private final UserRepository userRepository;
private final ProjectRepository projectRepository;
private final TaskRepository taskRepository;
	
	public AppService(UserRepository userRepository,ProjectRepository projectRepository,TaskRepository taskRepository) {
        this.userRepository = userRepository;
        this.projectRepository=projectRepository;
        this.taskRepository=taskRepository;
    }
	
	public List<User> allUsers() {
        return userRepository.findAll();
    }
	
	public List<Project> allProjects() {
        return projectRepository.findAll();
    }
	
	public User createUser(User b) {
        return userRepository.save(b);
    }
    
    public Project createProject(Project b) {
        return projectRepository.save(b);
    }
    
    public Task createTask(Task b) {
        return taskRepository.save(b);
    }
    
    public User findUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            return null;
        }
    }
    
    public Project findProject(Long id) {
        Optional<Project> optionalProject = projectRepository.findById(id);
        if(optionalProject.isPresent()) {
            return optionalProject.get();
        } else {
            return null;
        }
    }
	
    public void deleteUser(Long id) {
		// TODO Auto-generated method stub
    	userRepository.deleteById(id);
		
	}
	
	public void deleteProject(Long id) {
		// TODO Auto-generated method stub
		projectRepository.deleteById(id);
		
	}
    
	public User updateUser(User b) {
		// TODO Auto-generated method stub
		userRepository.save(b);
		return b;

	}
	
	public Project updateProject(Project b) {
		// TODO Auto-generated method stub
		projectRepository.save(b);
		return b;

	}
	
	public User register(User newUser, BindingResult result) {
        if(userRepository.findByEmail(newUser.getEmail()).isPresent()) {
            result.rejectValue("email", "Unique", "This email is already in use!");
        }
        if(!newUser.getPassword().equals(newUser.getConfirm())) {
            result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
        }
        if(result.hasErrors()) {
            return null;
        } else {
            String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
            newUser.setPassword(hashed);
            return userRepository.save(newUser);
        }
    }
	
	public User login(LoginUser newLogin, BindingResult result) {
        if(result.hasErrors()) {
            return null;
        }
        Optional<User> potentialUser = userRepository.findByEmail(newLogin.getEmail());
        if(!potentialUser.isPresent()) {
            result.rejectValue("email", "Unique", "Unknown email!");
            return null;
        }
        User user = potentialUser.get();
        if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
            result.rejectValue("password", "Matches", "Invalid Password!");
        }
        if(result.hasErrors()) {
            return null;
        } else {
            return user;
        }
    }
	
	public List<Project> findProjectsNotRelatedToUser(Long id){
		return projectRepository.findProjectsNotRelatedToUser(id);
	}
	
}
