package com.axsos.DojosAndNinjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.axsos.DojosAndNinjas.models.Dojo;
import com.axsos.DojosAndNinjas.models.Ninja;
import com.axsos.DojosAndNinjas.repositories.DojoRepository;
import com.axsos.DojosAndNinjas.repositories.NinjaRepository;

@Service
public class AppService {
private final DojoRepository dojoRepository;
private final NinjaRepository ninjaRepository;
	
	public AppService(DojoRepository dojoRepository,NinjaRepository ninjaRepository) {
        this.dojoRepository = dojoRepository;
        this.ninjaRepository=ninjaRepository;
    }
	
	public List<Dojo> allDojos() {
        return dojoRepository.findAll();
    }
	
	public List<Ninja> allNinjas() {
        return ninjaRepository.findAll();
    }
    // creates a book
    public Dojo createDojo(Dojo b) {
        return dojoRepository.save(b);
    }
    
    public Ninja createNinja(Ninja b) {
        return ninjaRepository.save(b);
    }
    // retrieves a book
    public Dojo findDojo(Long id) {
        Optional<Dojo> optionalDojo = dojoRepository.findById(id);
        if(optionalDojo.isPresent()) {
            return optionalDojo.get();
        } else {
            return null;
        }
    }
    
    public Ninja findNinja(Long id) {
        Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
        if(optionalNinja.isPresent()) {
            return optionalNinja.get();
        } else {
            return null;
        }
    }
    
	public void deleteDojo(Long id) {
		// TODO Auto-generated method stub
		dojoRepository.deleteById(id);
		
	}
	
	public void deleteNinja(Long id) {
		// TODO Auto-generated method stub
		ninjaRepository.deleteById(id);
		
	}
	
	public Dojo updateDojo(Dojo b) {
		// TODO Auto-generated method stub
		dojoRepository.save(b);
		return b;

	}
	
	public Ninja updateNinja(Ninja b) {
		// TODO Auto-generated method stub
		ninjaRepository.save(b);
		return b;

	}
	
}
