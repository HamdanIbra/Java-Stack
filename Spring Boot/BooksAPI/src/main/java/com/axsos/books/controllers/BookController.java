package com.axsos.books.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.axsos.books.models.Book;
import com.axsos.books.services.BookService;
@Controller
public class BookController {
	 private final BookService bookService;
	 public BookController(BookService bookService){
	     this.bookService = bookService;
	 }
	 
	 @RequestMapping("/books")
	 public String index(Model model) {
		 List<Book> allbooks=bookService.allBooks();
		 model.addAttribute("allbooks",allbooks);
	     return "showall.jsp";
	 }
	 
	 
	 
	 @RequestMapping("/api/books/{id}")
	 public String show(@PathVariable("id") Long id,Model model) {
	     Book book = bookService.findBook(id);
	     model.addAttribute("book",book);
	     return "show.jsp";
	 }
	 
	 // other methods removed for brevity
	 
	 
}
