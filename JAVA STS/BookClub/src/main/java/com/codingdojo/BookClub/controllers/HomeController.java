package com.codingdojo.BookClub.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.BookClub.models.Book;
import com.codingdojo.BookClub.models.User;
import com.codingdojo.BookClub.services.BookService;
import com.codingdojo.BookClub.services.UserService;


@Controller
public class HomeController {
	
	@Autowired
	private UserService userServ;
	@Autowired
	private BookService bookService;
	
	@RequestMapping("/home")
	public String home(HttpSession sesh, Model model) {
		
		Long userId = ( Long) sesh.getAttribute("user_id");
		if(userId == null) {
			return "redirect:/";
		}
		else {
			User thisUser = userServ.findOne(userId);
			model.addAttribute("thisUser", thisUser);
			
			
			
			List<Book> allDaBooks = bookService.allBooks();
			model.addAttribute("allDaBooks", allDaBooks);
		}
		
		return "home.jsp";
	}
	
	@GetMapping("/show/{id}") 
	public String showOne(@PathVariable("id") Long id, Model model) {
		Book thisBook = bookService.findBook(id);
		model.addAttribute("thisBook", thisBook);
		System.out.println(thisBook.getId());
		return "showOne.jsp";
	}
	
	
	
	
	
}
