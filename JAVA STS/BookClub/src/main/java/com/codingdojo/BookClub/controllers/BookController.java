package com.codingdojo.BookClub.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.BookClub.models.Book;
import com.codingdojo.BookClub.models.User;
import com.codingdojo.BookClub.services.BookService;
import com.codingdojo.BookClub.services.UserService;


@Controller
public class BookController {
	
//	@Autowired
//	private UserService userService;
	@Autowired
	private BookService bookService;
	
	
	@GetMapping("/books/new")
	public String newBook(@ModelAttribute("book") Book book, Model model) {
		
//		does not need all users because we do not need to see that info
//		List<User> allDaUsers = userService.allUsers();
//		model.addAttribute("allDaUsers", allDaUsers);
		
		List<Book> allDaBooks = bookService.allBooks();
		model.addAttribute("allDaBooks", allDaBooks);
		
		
		return "newBook.jsp";
	}
	
	
	@PostMapping("/books/new")
	public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if (result.hasErrors()) {
			return "newBook.jsp";
		}
		else {
			
			bookService.createBook(book);
			return "redirect:/home";
		}
	}
	
	@GetMapping("/edit/{id}") 
	public String editBook(@PathVariable("id") Long id, Model model) {
		Book thisBook = bookService.findBook(id);
		model.addAttribute("thisBook", thisBook);
		return "edit.jsp";
	}

	
	@PutMapping("edit/{id}")
	public String update(@Valid @ModelAttribute("thisBook") Book editedBook, BindingResult result) {
		if (result.hasErrors()) {
			return "edit.jsp";
		}
		else {
			bookService.updateBook(editedBook);
			return "redirect:/show/{id}";
		}
	}
	
	@DeleteMapping ("/delete/{id}")
	public String destroy(@PathVariable ("id") Long id, RedirectAttributes flash) {
		bookService.deleteBook(id);
		flash.addFlashAttribute ("deleteSuccess", "Expense has been deleted!");
		return "redirect:/home";
	}
	
	
	
	
	
}
