package com.axsos.LoginAndRegistration.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.axsos.LoginAndRegistration.models.Book;
import com.axsos.LoginAndRegistration.models.LoginUser;
import com.axsos.LoginAndRegistration.models.User;
import com.axsos.LoginAndRegistration.repositories.BookRepository;
import com.axsos.LoginAndRegistration.repositories.UserRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Service
public class UserService {
	
	@PersistenceContext
    private EntityManager entityManager;

    
	@Autowired
    private UserRepository userRepo;
	
	@Autowired
    private BookRepository bookRepo;
	
	public List<Book> allBooks() {
        return bookRepo.findAll();
    }
	
	public Book createBook(Book b) {
        return bookRepo.save(b);
    }
	
	public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepo.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
	
	public void deleteBook(Long id) {
		// TODO Auto-generated method stub
		bookRepo.deleteById(id);
		
	}
	
	public Book updateBook(Book b) {
		// TODO Auto-generated method stub
		
		return bookRepo.save(b);

	}
	
	public User updateUser(User b) {
		// TODO Auto-generated method stub
		userRepo.save(b);
		return b;

	}
	
	public User register(User newUser, BindingResult result) {
        if(userRepo.findByEmail(newUser.getEmail()).isPresent()) {
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
            return userRepo.save(newUser);
        }
    }
	
	public User login(LoginUser newLogin, BindingResult result) {
        if(result.hasErrors()) {
            return null;
        }
        Optional<User> potentialUser = userRepo.findByEmail(newLogin.getEmail());
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
	
	
	public User findUserById(Long id) {
    	Optional<User> u = userRepo.findById(id);

    	if(u.isPresent()) {
			return u.get();
			} else {
			return null;
    	}
	}
	
	public List<Book> findAvailableBooks() {
	    String jpql = "SELECT b FROM Book b WHERE b.borrower IS NULL";
	    TypedQuery<Book> query = entityManager.createQuery(jpql, Book.class);
	    return query.getResultList();
	}
	

	
}
