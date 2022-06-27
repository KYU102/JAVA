package com.codingdojo.JavaBelt.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.JavaBelt.models.NameClass;
import com.codingdojo.JavaBelt.models.User;
import com.codingdojo.JavaBelt.services.NameService;
import com.codingdojo.JavaBelt.services.UserService;


@Controller
public class HomeController {
	
	@Autowired
	private UserService userServ;
	@Autowired
	private NameService nameService;
	
	@RequestMapping("/home")
	public String home(HttpSession sesh, Model model) {
		
		Long userId = ( Long) sesh.getAttribute("user_id");
		if(userId == null) {
			return "redirect:/";
		}
		else {
			User thisUser = userServ.findOne(userId);
			model.addAttribute("thisUser", thisUser);
			
			
			
			List<NameClass> allDaNames = nameService.allNames();
			model.addAttribute("allDaNames", allDaNames);
		}
		
		return "home.jsp";
	}
	
	@GetMapping("/show/{id}") 
	public String showOne(@PathVariable("id") Long id, Model model) {
		NameClass thisName = nameService.findName(id);
		model.addAttribute("thisName", thisName);

		return "showOne.jsp";
	}
	
	
	
	
	
}
